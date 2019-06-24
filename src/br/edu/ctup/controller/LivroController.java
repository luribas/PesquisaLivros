package br.edu.ctup.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.edu.ctup.DAOImpl.LivroDAOImpl;
import br.edu.ctup.bean.Livro;

public class LivroController {

	private Livro livro = new Livro();
	private List<Livro> listaLivros;
	LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
	
	public LivroController() {
		livro = new Livro();
	}

// salvar livro 
	public void salvar() throws IOException {
		livroDAOImpl.CadastrarLivro(livro);
		livro = new Livro();
	}

// excluir livro 
	public void excluir() {
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLivro"));
		livroDAOImpl.excluir(id);
	}

// editar livro 
	public void editar() {
		Integer id = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idLivro"));
		livro = livroDAOImpl.editar(id);
	}
	
// Listagem
	public void listarTodos() {
		LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
		listaLivros = livroDAOImpl.listarTodosLivros();
	}

	
// Getters e setters Livro e Lista
	public Livro getLivro() {
		return livro;
	}
	public void setCliente(Livro livro) {
		this.livro = livro;
	}
	
	public List<Livro> getListaLivros() {
		LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
		List<Livro> livros = livroDAOImpl.listarTodosLivros();
		for (Livro l : livros) {
			System.out.println("Título: " + l.getNomeLivro());
		}
		return livroDAOImpl.listarTodosLivros();
	}
	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}
}
