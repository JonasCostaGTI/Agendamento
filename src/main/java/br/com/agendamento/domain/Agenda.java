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
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	@Column(name = "dia_consulta", nullable = false)
	private String dia;

	@Column(name = "hora_inicial", nullable = false)
	private String horario_inicio;

	@Column(name = "hora_final", nullable = false)
	private String horario_fim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(String horario_inicio) {
		this.horario_inicio = horario_inicio;
	}

	public String getHorario_fim() {
		return horario_fim;
	}

	public void setHorario_fim(String horario_fim) {
		this.horario_fim = horario_fim;
	}
	
	

		
	

}
