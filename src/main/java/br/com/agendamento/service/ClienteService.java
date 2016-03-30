package br.com.agendamento.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.agendamento.DAO.ClienteDAO;
import br.com.agendamento.domain.Cliente;


@Path("clientes")
public class ClienteService {

	// http://localhost:8081/Agendamento/service/clientes
	@GET
	public String listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = clienteDAO.listar();
		
		Gson gson = new Gson();
		String clientesJson = gson.toJson(clientes);

		return clientesJson;

	}

}
