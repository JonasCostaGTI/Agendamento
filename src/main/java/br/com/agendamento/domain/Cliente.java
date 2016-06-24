/**
 * 
 */
package br.com.agendamento.domain;

import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author jonascosta
 *
 */

@Entity
@SessionScoped
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false, length = 30)
	private String nome;

	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private Long cpf;

	@Column(name = "email", nullable = false, unique = true, length = 30)
	private String email;

	@Column(name = "telefone", nullable = false, unique = true, length = 8)
	private Long telefone;

	@Column(name = "horario", nullable = false)
	private String horario;

	@Column(name = "servico", nullable = false)
	private String servico;

	@Column(name = "dia", nullable = false)
	private String dia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
				+ ", horario=" + horario + ", servico=" + servico + ", dia=" + dia + "]";
	}
	
	

}