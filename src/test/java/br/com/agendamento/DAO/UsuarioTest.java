/**
 * 
 */
package br.com.agendamento.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agendamento.domain.Usuario;

/**
 * @author jonascosta
 *
 */
public class UsuarioTest {

	@Test
	@Ignore
	public void salvar() {

		Usuario usuario = new Usuario();
		usuario.setSenha(12341L);
		usuario.setUsuario("czc2v4");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

	}

	@Test
	@Ignore
	public void listar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuario = usuarioDAO.listar();

		if (usuario == null) {
			System.out.println("Nao ha usuarios cadastrados");
		} else {
			for (Usuario usuario2 : usuario) {
				System.out.println("");
				System.out.println("usuario: " + usuario2.getUsuario());
				System.out.println("senha: " + usuario2.getSenha());

			}
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigoExcluir = 1L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorcodigo(codigoExcluir);

		if (usuario == null) {
			System.out.println("Nao ha usuarios cadastrados");
		} else {
			usuarioDAO.excluir(usuario);
			System.out.println("Usuario: " + usuario.getUsuario() + " excluido com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {

		Long codigoEditar = 3L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorcodigo(codigoEditar);

		if (usuario == null) {
			System.out.println("Nao ha usuarios cadastrados");
		} else {
			
			usuario.setUsuario("blablabla");
			usuarioDAO.editar(usuario);
		}
	}

}
