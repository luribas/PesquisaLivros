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
	
	public void salvar() throws IOException {
		System.out.println("Nome: " + cliente.getNome());
		//clienteDAOImpl.salvar(cliente);
		cliente = new Cliente();
		FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
	}
	
	public void listarTodos() {
		ClienteDAOImpl clienteDAOimpl = new ClienteDAOImpl();
		listaClientes = clienteDAOimpl.listarTodos();
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaClientes() {
		//verificar console
		return clienteDAOImpl.listarTodos();
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void excluir() {// pega o valor do id que esta atrelado ao link ao
		
		Integer codigo = Integer.parseInt(
				(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo"));
		clienteDAOImpl.excluir(codigo);
		cliente = new Cliente();
	}

	public void editar() {// pega o valor do id que esta atrelado ao link ao
		Integer codigo = Integer.parseInt(
				(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo"));
			// cliente = clienteDAOImpl.editar(codigo);
			 
		//cliente = clienteDAOImpl.selecionarPorId(id);
	}
	
}
