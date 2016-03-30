package br.com.agendamento.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.agendamento.conexao.HibernateConexao;

public class GenericDAO<Entidade> {

	// descobre tipo da classe
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	// salvar
	public void salvar(Entidade entidade) {
		// conecta
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// lista
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}

	}

	// busca por codigo
	@SuppressWarnings("unchecked")
	public Entidade buscarPorcodigo(Long codigo) {
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			// where
			consulta.add(Restrictions.idEq(codigo));

			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}

	}

	// excluir
	public void excluir(Entidade entidade) {
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// editar
	public void editar(Entidade entidade) {
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// Merge
	public void merge(Entidade entidade) {
		// conecta
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	// lista Ordenado asc
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campoOrdenacao) {
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.asc(campoOrdenacao));
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}

	}

}
