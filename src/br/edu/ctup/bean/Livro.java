package br.edu.ctup.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Livro")
public class Livro {
	@Column 
	private String nomeLivro, nomeAutor;
	private double preco;
	private int estoqueInicial, numPaginas;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoqueInicial() {
		return estoqueInicial;
	}
	public void setEstoqueInicial(int estoqueInicial) {
		this.estoqueInicial = estoqueInicial;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	} 
	
	
	
}
