package br.com.agendamento.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.agendamento.DAO.ClienteDAO;
import br.com.agendamento.domain.Cliente;


@Path("clientes")
public class ClienteService {
	
	
	@Path("/Ola")//android
	@GET
	public String ola() {
		return "Ola Mundo";

	}
	
	

	// http://localhost:8081/Agendamento/service/clientes
	@Path("/Lista")//android
	@GET
	public String listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = clienteDAO.listar();
		
		Gson gson = new Gson();
		String clientesJson = gson.toJson(clientes);
		return clientesJson;

	}
	
	
	//localhost:8081/Agendamento/service/clientes
	@Path("/Salvar")//android
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		
		Cliente cliente = gson.fromJson(json, Cliente.class);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.merge(cliente);
		
		String clienteJson = gson.toJson(cliente);
		return clienteJson;
		
	}
	
	// http://localhost:8081/Agendamento/service/clientes/codigo
		@Path("{id}")
		@GET
		public String buscarPorCodigo(@PathParam("id") Long codigo) {

			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.buscarPorcodigo(codigo);

			Gson gson = new Gson();
			String clienteJson = gson.toJson(cliente);

			return clienteJson;

		}
		
		
		// http://localhost:8081/Agendamento/service/clientes/codigo
		@DELETE
		@Path("{id}")
		public String excluir(@PathParam("id") Long id) {
			
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.buscarPorcodigo(id);
			
			clienteDAO.excluir(cliente);
			
			Gson gson = new Gson();
			String clienteJson = gson.toJson(cliente);
			
			return clienteJson;
			
		}
		
		
		// http://localhost:8081/Agendamento/service/clientes
		@Path("/Editar")//android
		@PUT
		public String editar(String json) {
			
			Gson gson = new Gson();
			Cliente cliente = gson.fromJson(json, Cliente.class);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.editar(cliente);
			
			String clienteJson = gson.toJson(cliente);
			
			return clienteJson;
			
			
		}

}
