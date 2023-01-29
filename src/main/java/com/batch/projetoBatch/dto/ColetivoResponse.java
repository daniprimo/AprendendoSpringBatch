package com.batch.projetoBatch.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_coletivo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ColetivoResponse {

	@Id
	private Long id;
	private String placa;
	private String prefixo;
	private String modelo;
	private String cor;
	private String doc;
	private String status;	 
	@ManyToOne
	private GaragemResponse garagem;
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	
}
