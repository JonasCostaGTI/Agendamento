package br.com.agendamento.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("service")
public class AgendamentoResourcesConfig extends ResourceConfig {

	// aonde vao estar meus servicos
	public AgendamentoResourcesConfig() {
		packages("br.com.agendamento.service");
	}

}
