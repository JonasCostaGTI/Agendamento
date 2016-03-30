package br.com.agendamento.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.agendamento.DAO.ClienteDAO;
import br.com.agendamento.DAO.ServicoDAO;
import br.com.agendamento.domain.Agenda;
import br.com.agendamento.domain.Cliente;
import br.com.agendamento.domain.Servico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;
	private Servico servico;
	private Agenda agenda;
	private List<Cliente> clientes;
	private List<Servico> servicos;
	
	
	
	

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void novo() {
		cliente = new Cliente();
		agenda = new Agenda();
		
		cliente.setAgenda(agenda);
		
		ServicoDAO servicoDAO = new ServicoDAO();
		servicos = servicoDAO.listar();
		

	}

	@PostConstruct
	public void listar() {

		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao tentar listar Clientes");
			e.printStackTrace();
		}

	}

	// salvar
	public void salvar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);

			novo();
			clientes = clienteDAO.listar();
			Messages.addFlashGlobalInfo("Cliente Armazenado com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar armazenar cliente");
			e.printStackTrace();
		}
	}

	// excluir
	public void excluir(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			clientes = clienteDAO.listar();
			Messages.addFlashGlobalInfo("Cliente excluido com sucesso");
		} catch (RuntimeException e) {
			Messages.addFlashGlobalError("Erro ao tentar excluir cliente");
			e.printStackTrace();
		}
	}

	// editar
	public void editar(ActionEvent evento) {
		cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
		
		ServicoDAO servicoDAO = new ServicoDAO();
		servicos = servicoDAO.listar();
	}

}