package com.example.bookorder.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookorder.models.Paper;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long>{

	// FIND ALL PAPER
	@Query(value = "SELECT * FROM paper", nativeQuery = true)
	public List<Paper> getAllPaper();
	
	// FIND PAPER BY ID
	@Query(value = "SELECT * FROM paper p WHERE p.paper_id = ?", nativeQuery = true)
	public Paper getPaperById(Long id);
	
	// CREATE PAPER
	@Modifying
	@Query(value = "INSERT INTO paper (quality_name, price) VALUES (:qualityName, :paperPrice)",
			nativeQuery = true)
	public int insertToPaper(@Param("qualityName") String qualityName, @Param("paperPrice") BigDecimal paperPrice);
	
	// UPDATE PAPER
	@Modifying
	@Query(value = "UPDATE paper SET quality_name = ?, price = ? WHERE paper_id = ?",
			nativeQuery = true)
	public int updatePaper(@Param("qualityName") String qualityName,
			@Param("paperPrice") BigDecimal paperPrice,
			@Param("paperId") Long id);
	
	// DELETE PAPER
	@Modifying
	@Query(value = "DELETE FROM paper p WHERE p.paper_id = ?", nativeQuery = true)
	public int deletePaper(@Param("paperId") Long id);
	
}
