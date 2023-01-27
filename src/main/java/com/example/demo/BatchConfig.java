package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job imprimeOlaJob() {
		return jobBuilderFactory.get("imprimeOlaJob").start(imprimeParImparStep()).incrementer(new RunIdIncrementer())
				.build();
	}

	public Step imprimeParImparStep() {
		return stepBuilderFactory.get("imprimeParImparStep").<Integer, String>chunk(10).reader(contaAteDezReader())
				.processor(parOuImparProcessor()).writer(imprimeWriter()).build();
	}

	public ItemWriter<String> imprimeWriter() {
		return item ->	item.forEach(System.out::println);
	}

	public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		
		return new FunctionItemProcessor<Integer, String>
		(item -> item % 2 == 0 ? String.format("Item %s é par", item) : String.format("Item %s é impar", item));
	}

	public IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> numeroDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		return new IteratorItemReader<Integer>(numeroDeUmAteDez.iterator());
	}

	private Step imprimeOlaStep() {
		return stepBuilderFactory.get("imprimeOlaStep").tasklet(imprimeOlaTasklet(null)).build();
	}

	@Bean
	@StepScope
	public Tasklet imprimeOlaTasklet(@Value("#{jobParameters['nome']}") String nome) {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println(String.format("Ola, %s!", nome));
				return RepeatStatus.FINISHED;
			}
		};
	}

}
