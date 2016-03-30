package br.com.agendamento.conexao;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

public class HibernateConexaoTeste {

	@Test
	@Ignore
	public void conectar() {
		Session sessao = HibernateConexao.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateConexao.getFabricaDeSessoes().close();
	}

}
