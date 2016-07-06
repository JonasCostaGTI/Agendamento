package br.com.agendamento.conexao;

import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConexao {

	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			// busca o arquico hibernate.cfg.xml
			Configuration configuracao = new Configuration().configure();
			
			URL url = new URL("jdbc:mysql://"+System.getenv("OPENSHIFT_MYSQL_DB_HOST") + ":" + 
					System.getenv("OPENSHIFT_MYSQL_DB_PORT")+ "/agendamento");
			
			configuracao.configure(url);

			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();

			SessionFactory fabrica = configuracao.buildSessionFactory();

			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
