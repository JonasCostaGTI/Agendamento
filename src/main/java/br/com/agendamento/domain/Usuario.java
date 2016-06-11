package br.com.agendamento.domain;

import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SessionScoped
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "usuario", nullable = false, length = 30)
	private String usuario;

	@Column(name = "senha", nullable = false, unique = true, length = 11)
	private String senha;

}
