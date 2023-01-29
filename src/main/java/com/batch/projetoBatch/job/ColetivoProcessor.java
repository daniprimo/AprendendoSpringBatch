  package com.batch.projetoBatch.job;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.batch.projetoBatch.dto.ColetivoResponse;

@Configuration
public class ColetivoProcessor implements ItemProcessor<Long, ColetivoResponse> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	@Override
	public ColetivoResponse process(Long item) throws Exception {
		String sql = "SELECT * FROM tb_coletivo WHERE id = ?";
		ColetivoResponse coletivoResponse = (ColetivoResponse) jdbcTemplate.queryForObject(
				sql, new Object[] {item}, new BeanPropertyRowMapper(ColetivoResponse.class));
		coletivoResponse.setId(item);
		return coletivoResponse;
	}
	
	
}
