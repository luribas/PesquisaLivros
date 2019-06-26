package br.edu.ctup.DAO;

import java.util.List;
import br.edu.ctup.bean.Cliente;
import javax.persistence.Entity;

//objetivo dessa interface é definir os métodos de acesso ao BD
//métodos minimos: cadastratCliente, Listar todos, listar por nome, autencicação

public interface ClienteDAO {

	public void salvar(Cliente cliente);
	public void excluir(Integer codigo);
	public Cliente editar(Integer codigo);
	public List<Cliente> listarTodos();
	public Cliente buscarPorNomeCliente (String nome);
	public Cliente autenticar(String login, String senha);
	
}