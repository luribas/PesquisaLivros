package br.edu.ctup.DAO;

import java.util.List;

import br.edu.ctup.bean.Livro;

public interface LivroDAO {
 //metodos mínimos: cadastrarLivro, ListarTodos, buscar por nome livro, buscar por codigo, excluir
	
	void salvar (Livro livro);
	List<Livro> listarTodos();
	List <Livro> buscarPorNomelivro(String nome); // permitir a busca pelo nome completo ou parte do nome
	List<Livro> buscarLivroCodigo(Livro livro);
	List <Livro> buscarPorAutorlivro(String autor);
	List<Livro> buscarLivro(Livro livro);
	void excluir(Integer codigo);
	Livro editar (Integer codigo);
	
}