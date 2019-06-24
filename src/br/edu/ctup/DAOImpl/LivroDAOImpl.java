package br.edu.ctup.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ctup.DAO.DAO;
import br.edu.ctup.DAO.LivroDAO;
import br.edu.ctup.bean.Cliente;
import br.edu.ctup.bean.Livro;

public class LivroDAOImpl extends DAO implements LivroDAO{
	
	Livro livro = new Livro();
	EntityManager em = getEntityManager();

// salvar livro novo
	@Override
	public void CadastrarLivro(Livro livro) {
		EntityManager em = getEntityManager();
		try {
				if(livro.getCodigo() == null) {
					em.getTransaction().begin(); // inicia
					em.persist(livro);
					em.getTransaction().commit();	// envia para o bd
				} else {
					em.getTransaction().begin();
					em.merge(livro);
					em.getTransaction().commit();
				}
		} catch(Exception e) {
			e.getStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

// listar livros cadastrados
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> listarTodosLivros() {
		Query q = em.createQuery("select object(l) from Livro as l");
		return q.getResultList();
	}

// BUSCAS!
	@Override
	public List<Livro> buscarPorNomelivro(String nome) {
		em = getEntityManager();
		Query q = em.createQuery("from Livro where nome=:nomeLivro");
		q.setParameter("nome", nome);
		livro = (Livro) q.getSingleResult();
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> buscarPorCodigolivro(Integer codigo) {
		em = getEntityManager();
		Query q = em.createQuery("from Livro where codigo=:codigo");
		q.setParameter("codigo", codigo);
		livro = (Livro) q.getSingleResult();
		return q.getResultList();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> buscarPorAutorlivro(String autor) {
		em = getEntityManager();
		Query q = em.createQuery("from Livro where autor=:nomeAutor");
		q.setParameter("autor", autor);
		livro = (Livro) q.getSingleResult();
		return q.getResultList();
	}

	
// excluir livro cadastrado atraves de id/codigo
	@Override
	public void excluir(Integer codigo) {
		em = getEntityManager();
		em.getTransaction().begin();
		Livro livro = em.find(Livro.class, codigo);
		em.remove(livro);
		em.getTransaction().commit();
			}

// edita livro atraves de id/codigo
	@Override
	public Livro editar(Integer codigo) {
		em = getEntityManager();
		return em.find(Livro.class, codigo);
	}

	
}
