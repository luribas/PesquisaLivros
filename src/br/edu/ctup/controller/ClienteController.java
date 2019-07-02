package br.edu.ctup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import br.edu.ctup.DAOImpl.ClienteDAOImpl;
import br.edu.ctup.DAOImpl.JavaWEBDAOImpl;
import br.edu.ctup.bean.Cliente;

public class ClienteController {

	public Cliente cliente = new Cliente();
	private List<Cliente> listaClientes;
	private List<Cliente> listaPesquisa;
	ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
	
	public ClienteController() {
		cliente = new Cliente();
	}
	
	public ClienteController(String nome, String rg, String cpf, String login, String senha) {
		cliente = new Cliente();
	}
	
	//lista de pesquisa de clientes
	public List<Cliente> getListaPesquisa() {
		return listaPesquisa;
	}
	public void setListaPesquisa(List<Cliente> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}
	
	//	Salvar
	public void salvar() throws IOException {
		clienteDAOImpl.salvar(cliente);
		cliente = new Cliente();
		FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
	}
		
	//listar
	public void listarTodos() {
		ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
		listaClientes = clienteDAOImpl.listarTodos();
			
	}
	
	// getters e setters para cliente e lista
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ClienteDAOImpl getClienteDAOImpl() {
			return clienteDAOImpl;
		}

	public void setClienteDAOImpl(ClienteDAOImpl clienteDAOImpl) {
		this.clienteDAOImpl = clienteDAOImpl;
		}

	public List<Cliente> getListaClientes() {
		ClienteDAOImpl clienteDAOIMpl = new ClienteDAOImpl();
		listaClientes = clienteDAOImpl.listarTodos();
		

		return listaClientes;
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
	
	// buscar
	
	public void buscarCliente() throws IOException {
		listaPesquisa = clienteDAOImpl.buscarCliente(cliente);
		if(!listaPesquisa.isEmpty())
		{
			FacesContext.getCurrentInstance().getExternalContext().redirect("BuscaCliente.xhtml");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Erro.xhtml");
		}
	}
}
