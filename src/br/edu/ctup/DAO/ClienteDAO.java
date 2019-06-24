package br.edu.ctup.DAO;

import java.util.List;
import br.edu.ctup.bean.Cliente;

//objetivo dessa interface � definir os m�todos de acesso ao BD
//m�todos minimos: cadastratCliente, Listar todos, listar por nome, autencica��o

public interface ClienteDAO {

	void salvar(Cliente cliente);
	void excluir(Integer codigo);
	Cliente editar(Integer codigo);
	List<Cliente> listarTodos();
	Cliente buscarPorNomeCliente (String nome);
	Cliente autenticar(String login, String senha);
	
}