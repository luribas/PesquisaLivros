package br.edu.ctup.DAO;

import java.util.List;

import br.edu.ctup.bean.Livro;

public interface LivroDAO {
 //metodos mínimos: cadastrarLivro, ListarTodos, buscar por nome livro, buscar por codigo, excluir
	
	void CadastrarLivro (Livro livro);
	List<Livro> listarTodosLivros();
	List <Livro> buscarPorNomelivro(String nome); // permitir a busca pelo nome completo ou parte do nome
	List <Livro> buscarPorCodigolivro(Integer codigo);
	List <Livro> buscarPorAutorlivro(String autor);
	void excluir(Integer codigo);
	Livro editar (Integer codigo);
	
}