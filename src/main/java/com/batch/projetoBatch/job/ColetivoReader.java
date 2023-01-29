package com.batch.projetoBatch.job;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.projetoBatch.repository.ColetivoRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class ColetivoReader {
	
	@Autowired
	private ColetivoRepository coletivoRepository;
	
	public class MeuItemReader<T> implements ItemReader<T> {

		private List<T> lista;
				
		public MeuItemReader(List<T> lista) {
			this.lista = lista;
		}

		@Override
		public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
			if (lista.isEmpty()) {
				return lista.remove(0);
			}
			return null;
		}
		
	}

    @Bean
    @StepScope
    ItemReader<Long> coletivoResponse()  {

        List<Long> lista = coletivoRepository.findIdDosColetivos();
        System.out.println(lista);

        return new MeuItemReader<Long>(lista);
    }

}
