package com.example.demo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBtachStepConfig {


	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	@StepScope
	public Step imprimeOlaStep(Tasklet tasklet) {
		return stepBuilderFactory
				.get("imprimeOlaStep")
				.tasklet(tasklet)
				.build();
	}

}
