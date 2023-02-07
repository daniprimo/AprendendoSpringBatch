package com.springbatch.demonstrativoorcamentario.writer;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import com.springbatch.demonstrativoorcamentario.dominio.GrupoLancamento;

@Component
public class DemonstrativoOrcamentarioRodape implements FlatFileFooterCallback {
	private Double totalGeral = 0.0;

	@Override
	public void writeFooter(Writer writer) throws IOException {
		writer.append("\n");
		writer.append(
				String.format("\t\t\t\t\t\t\t Total: %s\n", NumberFormat.getCurrencyInstance().format(totalGeral)));
		writer.append(String.format("\t\t\t\t\t\t\t Codigo de Autenticacao: %s\n", "fkyew6868fewjfhjjewf"));
	}

	@BeforeWrite
	public void beforeWriter(List<GrupoLancamento> grupos) {
		for (GrupoLancamento grupoLancamento : grupos) {
			totalGeral += grupoLancamento.getTotal();
		}
	}

}
