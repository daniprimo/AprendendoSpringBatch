package com.springbatch.arquivolargurafixa.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springbatch.arquivolargurafixa.dominio.Cliente;

@Configuration
public class ArquivoLarguraFixaWriterConfig {
	// new Range[]{new Range(1,10), new Range(11, 20), new Range(21, 23), new
	// Range(24, 43)
	@Bean
	@StepScope
	public FlatFileItemWriter<Cliente> leituraArquivoLarguraFixaWriter(
			@Value("#{jobParameters['arquivoClientesSaida']}") Resource arquivoClienteSaida) {
		return new FlatFileItemWriterBuilder<Cliente>()
				.name("leituraArquivoLarguraFixaWriter")
				.resource(arquivoClienteSaida)
				.formatted().format("%-9s %-9s %-2s %-19s")
				.names(new String [] {"nome", "sobrenome", "idade", "email"})
				.build();

	}
}
