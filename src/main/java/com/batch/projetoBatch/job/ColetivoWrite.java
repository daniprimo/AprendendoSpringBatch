package com.batch.projetoBatch.job;

import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.batch.projetoBatch.dto.ColetivoResponse;

@Configuration
public class ColetivoWrite {
	
	@Autowired
	private MongoTemplate mongoTemplate;

    @Bean
    MongoItemWriter<ColetivoResponse> writer() {
        MongoItemWriter<ColetivoResponse> writer = new MongoItemWriter<ColetivoResponse>();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("ColetivoResponse");
        return writer;
    }
}