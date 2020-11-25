package com.example.bookorder.controllers.iona;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Paper;
import com.example.bookorder.models.Publisher;
import com.example.bookorder.models.dtos.PublisherDto;
import com.example.bookorder.repositories.PaperRepository;
import com.example.bookorder.repositories.PublisherRepository;
import com.io.iona.springboot.actionflows.custom.CustomOnInsert;
import com.io.iona.springboot.controllers.HibernateCRUDController;
import com.io.iona.springboot.sources.HibernateDataSource;
import com.io.iona.springboot.sources.HibernateDataUtility;

@RestController
@RequestMapping("/api/publisher-iona")
public class PublisherControllerIona extends HibernateCRUDController<Publisher, PublisherDto> implements CustomOnInsert<Publisher, PublisherDto> {

	@Autowired
	PublisherRepository publisherRepository;
	@Autowired
	PaperRepository paperRepository;
	
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
}
