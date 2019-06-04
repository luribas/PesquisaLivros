package br.edu.ctup.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente {

	@Column 
	private String nome, rg, cpf, login, senha;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codigo; 
	
}
