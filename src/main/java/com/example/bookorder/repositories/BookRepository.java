package com.example.bookorder.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	// FIND ALL BOOKS
	@Query(value = "SELECT * FROM book", nativeQuery = true)
	public List<Book> getAllBooks();
	
	// FIND BOOK BY ID
	@Query(value = "SELECT * FROM book WHERE book_id =?", nativeQuery = true)
	public Book getBookById(@Param("bookId") Long bookId);
	
	// CREATE BOOK
	@Modifying
	@Query(value = "INSERT INTO book (title, real_date, author_id, publisher_id) "
			+ "VALUES (:title, :releaseDate, :authorId, :publisherId)",
			nativeQuery = true)
	public int insertIntoBook(@Param("title") String title,
			@Param("releaseDate") Date date,
			@Param("authorId") Long authorId,
			@Param("publisherId") Long publisherId);
	
	// UPDATE BOOK
	@Modifying
	@Query(value = "UPDATE book SET title =?, real_date =?, author_id =?, publisher_id=?"
			+ " WHERE book_id =?",
			nativeQuery = true)
	public int updateBook(@Param("title") String title,
			@Param("releaseDate") Date date,
			@Param("authorId") Long authorId,
			@Param("publisherId") Long publisherId,
			@Param("bookId") Long id);
	
	// DELETE BOOK
	@Modifying
	@Query(value = "DELETE FROM book WHERE book_id =?", nativeQuery = true)
	public int deleteBook(@Param("bookId") Long bookId);
}
