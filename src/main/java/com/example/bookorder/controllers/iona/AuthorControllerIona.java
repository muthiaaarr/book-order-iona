package com.example.bookorder.controllers.iona;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookorder.models.Author;
import com.example.bookorder.models.dtos.AuthorDto;
import com.io.iona.core.enums.ActionFlow;
import com.io.iona.implementations.pagination.DefaultPagingParameter;
import com.io.iona.springboot.actionflows.custom.CustomAfterReadAll;
import com.io.iona.springboot.actionflows.custom.CustomBeforeInsert;
import com.io.iona.springboot.controllers.HibernateCRUDController;
import com.io.iona.springboot.sources.HibernateDataSource;
import com.io.iona.springboot.sources.HibernateDataUtility;

@RestController
@RequestMapping("/api/author-iona")
public class AuthorControllerIona extends HibernateCRUDController<Author, AuthorDto> implements CustomAfterReadAll<Author, AuthorDto>
	/*implements CustomBeforeInsert<Author, AuthorDto>*/{

	ModelMapper mapper = new ModelMapper();
	
	/*@Override
	public void beforeInsert(HibernateDataUtility hibernateDataUtility, HibernateDataSource<Author, AuthorDto> dataSource) throws Exception {
		Author author = dataSource.getDataModel();
		author.setAuthorId(1);
		
	}*/
	
	@Override
	public List<AuthorDto> afterReadAll(HibernateDataUtility hibernateDataUtility, HibernateDataSource<Author, AuthorDto> dataSource,
			DefaultPagingParameter defaultPagingParameter) throws Exception {
		List<Author> author = dataSource.getResult(ActionFlow.ON_READ_ALL_ITEMS, List.class);
		List<AuthorDto> authorDto = new ArrayList<AuthorDto>();
		
		for (Author a : author) {
			AuthorDto dto = mapper.map(a, AuthorDto.class);
			authorDto.add(dto);
		}
		
		return authorDto;
	}
}
