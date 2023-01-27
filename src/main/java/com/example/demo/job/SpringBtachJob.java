package com.example.demo.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class SpringBtachJob {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job imprimeOlaJob(Step step) {
		return jobBuilderFactory.get("imprimeOlaJob").start(step).build();
	}

}
