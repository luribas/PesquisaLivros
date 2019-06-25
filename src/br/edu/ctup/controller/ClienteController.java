package br.edu.ctup.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.edu.ctup.DAOImpl.ClienteDAOImpl;
import br.edu.ctup.bean.Cliente;

public class ClienteController {

	private Cliente cliente = new Cliente();
	private List<Cliente> listaClientes;
	private ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
	
	public ClienteController() {
		cliente = new Cliente();
	}
	
	public ClienteController(String nome, String rg, String cpf, String login, String senha) {
		cliente = new Cliente();
	}
		
	public void salvar() throws IOException {
		clienteDAOImpl.salvar(cliente);
		cliente = new Cliente();
		FacesContext.getCurrentInstance().getExternalContext().redirect("Sucesso.xhtml");
	}
	
	public void listarTodos() {
		ClienteDAOImpl clienteDAOimpl = new ClienteDAOImpl();
		listaClientes = clienteDAOimpl.listarTodos();
			
	}
	
	// getters e setters para cliente e lista
	public Cliente getCliente() {
		return cliente;
	}
	
		public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaClientes() {
		ClienteDAOImpl clienteDAOimpl = new ClienteDAOImpl();
		List<Cliente> clientes = clienteDAOimpl.listarTodos();
		return clienteDAOimpl.listarTodos();
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
		
	// excluir cliente
	public void excluir() {// pega o valor do id ("codigo") que esta atrelado ao link
		
		Integer codigo = Integer.parseInt(
				(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo"));
		clienteDAOImpl.excluir(codigo);
		cliente = new Cliente();
	}
	
	//editar cliente
	public void editar() throws IOException {// pega o valor do id que esta atrelado ao link 
		Integer codigo = Integer.parseInt(
				(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo"));
			cliente = clienteDAOImpl.editar(codigo);
			 
	}
	
	// autenticar
	
	public void autenticarCliente() throws IOException {
		cliente = clienteDAOImpl.autenticar(getCliente().getLogin(), getCliente().getSenha());
		if(cliente != null)
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("ClienteLogado.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Erro.xhtml");
		}
	}
}
