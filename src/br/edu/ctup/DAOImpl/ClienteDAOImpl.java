package br.edu.ctup.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ctup.DAO.ClienteDAO;
import br.edu.ctup.DAO.DAO;
import br.edu.ctup.bean.Cliente;

public class ClienteDAOImpl extends DAO implements ClienteDAO {
	
	private Cliente cliente = new Cliente();
	EntityManager em = getEntityManager();
	
	@Override
	public void salvar(Cliente cliente) {
		em = getEntityManager();
		try { 									// tratamento de erro
				if(cliente.getCodigo() == null) {
					em.getTransaction().begin(); // abre conexao 
					em.persist(cliente);
					em.getTransaction().commit();	
				} else {
					em.getTransaction().begin();
					em.merge(cliente);
					em.getTransaction().commit();
				}
		} catch(Exception e) {
			e.getStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void excluir(Integer codigo) {
		em = getEntityManager();
		try{
			em.getTransaction().begin();    //inicia o processo de transacao
			Cliente cliente = em.find(Cliente.class, codigo); 	//faz a persistencia
			em.remove(cliente);
			em.getTransaction().commit();	//manda bala para o BD
			
		}catch (Exception e) {
			//em caso de erro entra aqui e cancela
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<Cliente> listarTodos() {
		EntityManager em= getEntityManager();
		Query q = em.createQuery("select object(c) from Cliente as c");
		return q.getResultList();
	}


	@SuppressWarnings("finally")
	@Override
	public Cliente buscarPorNomeCliente(String nome) {
		EntityManager em = getEntityManager();
		try{
			Query query = em.createQuery("from Cliente where nome=:nome");
			query.setParameter("nome", nome);
			cliente = (Cliente) query.getSingleResult();
		}catch(Exception nre){
			cliente = null;
		}finally{
			em.close();
			return cliente;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public Cliente autenticar(String login, String senha) {
		em = getEntityManager();
		try {
			Query query = em.createQuery("from Cliente where login=:login and senha=:senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			cliente = (Cliente) query.getSingleResult();
		} catch (Exception nre) {
			cliente = null;
		} finally {
			em.close(); // encerra em caso de erro
			return cliente;
		}
	}

	@Override
	public Cliente editar(Integer codigo) {
		em = getEntityManager();
		return em.find(Cliente.class, codigo);
	}



}
