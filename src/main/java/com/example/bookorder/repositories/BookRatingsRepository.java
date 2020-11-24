package com.example.bookorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.BookRatings;

@Repository
public interface BookRatingsRepository extends JpaRepository<BookRatings, Long>{

	// FIND ALL RATINGS
	@Query(value = "SELECT * FROM book_ratings", nativeQuery = true)
	public List<BookRatings> getAllRatings();
	
	// FIND RATING BY ID
	@Query(value = "SELECT * FROM book_ratings WHERE rating_id =?", nativeQuery = true)
	public BookRatings getRatingById(@Param("raingId") Long id);
	
	// CREATE RATING
	@Modifying
	@Query(value = "INSERT INTO book_ratings (rating_score, book_id, reviewer_id) "
			+ "VALUES (:ratingScore, :bookId, :reviewerId)", nativeQuery = true)
	public int insertIntoRating(@Param("ratingScore") int ratingScore,
			@Param("bookId") Long bookId,
			@Param("reviewerId") Long reviewerId);
	
	// UPDATE RATING
	@Modifying
	@Query(value = "UPDATE book_ratings SET rating_score =?, book_id =?, reviewer_id =? "
			+ "WHERE rating_id =?", nativeQuery = true)
	public int updateRating(@Param("ratingScore") int ratingScore,
			@Param("bookId") Long bookId,
			@Param("reviewerId") Long reviewerId,
			@Param("ratingId") Long ratingId);
	
	// DELETE RATING
	@Modifying
	@Query(value = "DELETE FROM book_ratings WHERE rating_id =?", nativeQuery = true)
	public int deleteRating(@Param("ratingId") Long id);
	
}
