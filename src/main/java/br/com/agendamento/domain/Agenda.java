/**
 * 
 */
package br.com.agendamento.domain;

import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@Temporal(TemporalType.DATE)
	@Column(name = "dia_consulta", nullable = false)
	private Date dia;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inicial", nullable = false)
	private Date horario_inicio;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_final", nullable = false)
	private Date horario_fim;

	public Date getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(Date horario_inicio) {
		this.horario_inicio = horario_inicio;
	}

	public Date getHorario_fim() {
		return horario_fim;
	}

	public void setHorario_fim(Date horario_fim) {
		this.horario_fim = horario_fim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((horario_fim == null) ? 0 : horario_fim.hashCode());
		result = prime * result + ((horario_inicio == null) ? 0 : horario_inicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (horario_fim == null) {
			if (other.horario_fim != null)
				return false;
		} else if (!horario_fim.equals(other.horario_fim))
			return false;
		if (horario_inicio == null) {
			if (other.horario_inicio != null)
				return false;
		} else if (!horario_inicio.equals(other.horario_inicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", dia=" + dia + ", horario_inicio=" + horario_inicio + ", horario_fim="
				+ horario_fim + "]";
	}
	
	

}
