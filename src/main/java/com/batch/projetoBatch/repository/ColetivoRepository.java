package com.batch.projetoBatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batch.projetoBatch.dto.ColetivoResponse;

@Repository
public interface ColetivoRepository extends JpaRepository<ColetivoResponse, Long> {
	String sql = "SELECT id FROM tb_coletivo";

	@Query(value = sql, nativeQuery = true)
	List<Long> findIdDosColetivos();
	
	
	

}
