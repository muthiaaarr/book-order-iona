package com.example.bookorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Reviewer;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long>{

	// FIND ALL REVIEWER
	@Query(value = "SELECT * FROM reviewer", nativeQuery = true)
	public List<Reviewer> getAllReviewer();
	
	// FIND REVIEWER BY ID
	@Query(value = "SELECT * FROM reviewer WHERE reviewer_id =?", nativeQuery = true)
	public Reviewer getReviewerById(@Param("reviewerId") Long id);
	
	// CREATE REVIEWER
	@Modifying
	@Query(value = "INSERT INTO reviewer (name, country, verified) "
			+ "VALUES (:reviewerName, :country, :verified)", nativeQuery = true)
	public int insertIntoReviewer(@Param("reviewerName") String reviewerName,
			@Param("country") String country,
			@Param("verified") Boolean verified);
	
	// UPDATE REVIEWER
	@Modifying
	@Query(value = "UPDATE reviewer SET name =?, country =?, verified =?"
			+ " WHERE reviewer_id =?", nativeQuery = true)
	public int updateReviewer(@Param("reviewerName") String reviewerName,
			@Param("country") String country,
			@Param("verified") Boolean verified,
			@Param("reviewerId") Long id);
	
	// DELETE REVIEWER
	@Modifying
	@Query(value = "DELETE FROM reviewer WHERE reviewer_id =?", nativeQuery = true)
	public int deleteReviewer(@Param("reviewerId") Long id);
	
}
