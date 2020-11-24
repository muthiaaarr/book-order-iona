package com.example.bookorder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	// FIND ALL AUTHOR
	@Query(value = "SELECT * FROM author", nativeQuery = true)
	public List<Author> getAllAuthor();
	
	// FIND AUTHOR BY ID
	@Query(value = "SELECT * FROM author a WHERE a.author_id =?", nativeQuery = true)
	public Author getAuthorById(@Param("authorId") Long id);
	
	// CREATE AUTHOR
	@Modifying
	@Query(value = "INSERT INTO author (f_name, l_name, gender, age, country, rating)"
			+ "VALUES (:firstName, :lastName, :gender, :age, :country, :rating)", 
			nativeQuery = true)
	public int insertIntoAuthor(@Param("firstName") String firstName,
			@Param("lastName") String lastName, 
			@Param("gender") String gender,
			@Param("age") Integer age, 
			@Param("country") String country,
			@Param("rating") String rating);
	
	// UPDATE AUTHOR
	@Modifying
	@Query(value = "UPDATE author a SET f_name =?, l_name=?, gender=?, "
			+ "age =?, country =?, rating=? WHERE a.author_id =?", nativeQuery = true)
	public int updateAuthor(@Param("firstName") String firstName,
			@Param("lastName") String lastName, 
			@Param("gender") String gender,
			@Param("age") Integer age,
			@Param("country") String country,
			@Param("rating") String rating, 
			@Param("author_id") Long id);
	
	// DELETE AUTHOR
	@Modifying
	@Query(value = "DELETE FROM author a WHERE a.author_id =?", nativeQuery = true)
	public int deleteAuthor(@Param("authorId") Long id);
	
}
