package com.example.bookorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{

	// FIND ALL PUBLISHER
	@Query(value = "SELECT * FROM publisher", nativeQuery = true)
	public List<Publisher> getAllPublishers();
	
	// FIND PUBLISHER BY ID
	@Query(value = "SELECT * FROM publisher p WHERE p.publisher_id =?",
			nativeQuery = true)
	public Publisher getPublisherById(@Param("publisher_id") Long id);
	
	// CREATE PUBLISHER
	@Modifying
	@Query(value = "INSERT INTO publisher (company_name, country, paper_id) VALUES (:companyName, :country, :paperId)",
			nativeQuery = true)
	public int insertToPublisher(@Param("companyName") String companyName,
			@Param("country") String country, @Param("paperId") Long paperId);
	
	// UPDATE PUBLISHER
	@Modifying
	@Query(value = "UPDATE publisher p SET company_name =?, country =?, paper_id =? WHERE p.publisher_id =?", 
			nativeQuery = true)
	public int updatePublisher(@Param("companyName") String companyName,
			@Param("country") String country, @Param("paperId") Long paperId,
			@Param("publisher_id") Long id);
	
	// DELETE PUBLISHER
	@Modifying
	@Query(value = "DELETE FROM publisher p WHERE p.publisher_id =?", nativeQuery = true)
	public int deletePublisher(@Param("publisher_id") Long id);
	
}
