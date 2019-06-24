package br.edu.ctup.DAO;

import java.util.List;
import br.edu.ctup.bean.Cliente;

//objetivo dessa interface é definir os métodos de acesso ao BD
//métodos minimos: cadastratCliente, Listar todos, listar por nome, autencicação

public interface ClienteDAO {

	void salvar(Cliente cliente);
	void excluir(Integer codigo);
	Cliente editar(Integer codigo);
	List<Cliente> listarTodos();
	Cliente buscarPorNomeCliente (String nome);
	Cliente autenticar(String login, String senha);
	
}