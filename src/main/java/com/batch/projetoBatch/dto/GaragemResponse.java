package com.batch.projetoBatch.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GaragemResponse {

	@Id
	private Long id;
	private String nome;
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
