package br.edu.ctup.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Livro {
	@Column 
	private String nomeLivro, nomeAutor;
	private double preco;
	private int estoqueInicial, numPaginas;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codigo; 
	
}
