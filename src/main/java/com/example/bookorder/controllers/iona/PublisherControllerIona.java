package com.example.bookorder.controllers.iona;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.exceptions.ResourceNotFoundException;
import com.example.bookorder.models.Paper;
import com.example.bookorder.models.Publisher;
import com.example.bookorder.models.dtos.PublisherDto;
import com.example.bookorder.repositories.PaperRepository;
import com.example.bookorder.repositories.PublisherRepository;
import com.io.iona.core.enums.ActionFlow;
import com.io.iona.implementations.pagination.DefaultPagingParameter;
import com.io.iona.springboot.actionflows.custom.CustomAfterReadAll;
import com.io.iona.springboot.actionflows.custom.CustomBeforeInsert;
import com.io.iona.springboot.actionflows.custom.CustomOnInsert;
import com.io.iona.springboot.controllers.HibernateCRUDController;
import com.io.iona.springboot.sources.HibernateDataSource;
import com.io.iona.springboot.sources.HibernateDataUtility;

@RestController
@RequestMapping("/api/publisher-iona")
public class PublisherControllerIona extends HibernateCRUDController<Publisher, PublisherDto> implements CustomOnInsert<Publisher, PublisherDto>, 
	CustomAfterReadAll<Publisher, PublisherDto>, CustomBeforeInsert<Publisher, PublisherDto>{

	@Autowired
	PublisherRepository publisherRepository;
	@Autowired
	PaperRepository paperRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public Publisher onInsert(HibernateDataUtility hibernateDataUtility, HibernateDataSource<Publisher, PublisherDto> dataSource) throws Exception {
		Publisher publisher = dataSource.getDataModel();
		List<Paper> list = paperRepository.findAll();
		Paper paper = new Paper();
	    
		for (Paper p : list) {
		    if (p.getPaperId() != publisher.getPaper().getPaperId()) {
		        paper.setPaperId(publisher.getPaper().getPaperId());
		        paper.setPaperPrice(new BigDecimal(1000));
		        paper.setQualityName("Paper Baru");
		    }
		}
		    
		paperRepository.save(paper);
		publisherRepository.save(publisher);
		return dataSource.getDataModel();
	}
	
	@Override
	public List<PublisherDto> afterReadAll(HibernateDataUtility hibernateDataUtility, HibernateDataSource<Publisher, PublisherDto> dataSource, 
			DefaultPagingParameter defaultPagingParameter) throws Exception {
		List<Publisher> list = dataSource.getResult(ActionFlow.ON_READ_ALL_ITEMS, List.class);
		List<PublisherDto> listDto = new ArrayList<PublisherDto>();
		
		for (Publisher p : list) {
			PublisherDto dto = mapper.map(p, PublisherDto.class);
			Paper paper = paperRepository.findById(p.getPaper().getPaperId()).orElseThrow(()-> new ResourceNotFoundException("Paper", "id", p.getPaper().getPaperId()));
			dto.setQualityName(paper.getQualityName());
			listDto.add(dto);
		}
		
		return listDto;
	}
	
	@Override
	public void beforeInsert(HibernateDataUtility hibernateDataUtility, HibernateDataSource<Publisher, PublisherDto> dataSource) throws Exception {
		Publisher publisher = dataSource.getDataModel();
		PublisherDto dto = mapper.map(publisher, PublisherDto.class);
		paperRepository.findById(dto.getPaperId()).orElseThrow(()-> new ResourceNotFoundException("Paper", "id", dto.getPaperId()));
	}
}
