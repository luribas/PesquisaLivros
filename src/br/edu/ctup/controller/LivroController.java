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
	private List<Livro> listaPesquisaLivro;
	
	public LivroController() {
		livro = new Livro();
	}

// salvar livro 
	public void salvar() throws IOException {
		livroDAOImpl.salvar(livro);
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
	
// Listagem total
	public void listarTodos() {
		LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
		listaLivros = livroDAOImpl.listarTodos();
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
		List<Livro> livros = livroDAOImpl.listarTodos();
		for (Livro l : livros) {
			System.out.println("Título: " + l.getNomeLivro());
		}
		return livroDAOImpl.listarTodos();
	}
	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public List<Livro> getListaPesquisaLivro() {
		return listaPesquisaLivro;
	}

	public void setListaPesquisaLivro(List<Livro> listaPesquisaLivro) {
		this.listaPesquisaLivro = listaPesquisaLivro;
	}
	
	// buscar + buscar por codigo
	public void buscarLivro() throws IOException {
		listaPesquisaLivro = livroDAOImpl.buscarLivro(livro);
		if(!listaPesquisaLivro.isEmpty())
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("BuscaLivro.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Erro.xhtml");
		}
	}
	
	// BUSCAR POR ID
	public void buscarLivroCodigo() throws IOException {
		listaPesquisaLivro = livroDAOImpl.buscarLivroCodigo(livro);
		if(listaPesquisaLivro != null)
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("BuscarLivro.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("BuscarLivroErro.xhtml");
		}
	
}
	
}
