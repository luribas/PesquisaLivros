package br.edu.ctup.DAO;

import java.util.List;
import br.edu.ctup.bean.Cliente;
import javax.persistence.Entity;

//objetivo dessa interface � definir os m�todos de acesso ao BD
//m�todos minimos: cadastratCliente, Listar todos, listar por nome, autencica��o

public interface ClienteDAO {

	public void salvar(Cliente cliente);
	public void excluir(Integer codigo);
	public Cliente editar(Integer codigo);
	public List<Cliente> listarTodos();
	public Cliente buscarPorNomeCliente (String nome);
	public Cliente autenticar(String login, String senha);
	
}