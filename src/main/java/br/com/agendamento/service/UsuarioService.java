package br.com.agendamento.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.agendamento.DAO.UsuarioDAO;
import br.com.agendamento.domain.Usuario;

@Path("usuarios")
public class UsuarioService {
	
	// http://localhost:8081/Agendamento/service/usuarios
		@Path("/Lista")//android
		@GET
		public String listar() {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> usuarios = usuarioDAO.listar();
			
			Gson gson = new Gson();
			String clientesJson = gson.toJson(usuarios);
			return clientesJson;

		}
		
		
		//localhost:8081/Agendamento/service/usuarios
		@Path("/Salvar")//android
		@POST
		public String salvar(String json) {
			Gson gson = new Gson();
			
			Usuario usuario = gson.fromJson(json, Usuario.class);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);
			
			String usuarioJson = gson.toJson(usuario);
			return usuarioJson;
			
		}
		
		// http://localhost:8081/Agendamento/service/usuarios/codigo
			@Path("{id}")
			@GET
			public String buscarPorCodigo(@PathParam("id") Long codigo) {

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarPorcodigo(codigo);

				Gson gson = new Gson();
				String usuarioJson = gson.toJson(usuario);

				return usuarioJson;

			}
			
			
			// http://localhost:8081/Agendamento/service/usuarios/codigo
			@DELETE
			@Path("{id}")
			public String excluir(@PathParam("id") Long id) {
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarPorcodigo(id);
				
				usuarioDAO.excluir(usuario);
				
				Gson gson = new Gson();
				String usuarioJson = gson.toJson(usuario);
				
				return usuarioJson;
				
			}
			
			
			// http://localhost:8081/Agendamento/service/usuarios
			@Path("/Editar")//android
			@PUT
			public String editar(String json) {
				
				Gson gson = new Gson();
				Usuario usuario = gson.fromJson(json, Usuario.class);
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioDAO.editar(usuario);
				
				String usuarioJson = gson.toJson(usuario);
				
				return usuarioJson;
				
				
			}

}
