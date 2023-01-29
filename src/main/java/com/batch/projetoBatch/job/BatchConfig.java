package com.batch.projetoBatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.projetoBatch.dto.ColetivoResponse;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {
	
	

	@Bean
	Step step(StepBuilderFactory stepBuilderFactory, ItemReader<Long> reader,
			ItemProcessor<Long, ColetivoResponse> processor, ItemWriter<ColetivoResponse> writer) {
		log.info("Passou pelo step");
		return stepBuilderFactory
				.get("step")
				.<Long, ColetivoResponse>chunk(10)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean
	Job job(JobBuilderFactory jobBuilderFactory, Step step) {
		log.info("Passou pelo job");
		return jobBuilderFactory.get("job1").start(step).build();
	}

}
