package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="coordenadores")
public class Coord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Nome não pode ser vazio!")
	private String fullName;
	@NotBlank(message = "E-mail não pode ser vazio!")
	@Email(message = "E-mail incorreto!")
	private String email;
	@NotBlank(message = "Número não pode ser vazio!")
	private String number;
	private String role;
	@OneToMany(mappedBy="coord", cascade = CascadeType.REMOVE)
	private List<Event> events;


	public Coord() {};
	
	public Coord(Integer id)
	{
		this.id = id;
		setFullName("");
		setEmail("");
		setNumber("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
