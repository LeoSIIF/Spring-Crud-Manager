package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

@Entity
@Table(name="eventos")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Nome não pode ser vazio!")
    private String eventName;
    @Temporal(TemporalType.DATE) @Past(message = "Data não pode ser futura!")
    private Date dateStart;
    @Temporal(TemporalType.DATE) @Future(message = "Data não pode ser passada!")
    private Date dateEnd;
    @NotBlank(message = "Localização não pode ser vazia!")
    private String location;
    @ManyToOne
    @JoinColumn(name="coord_id", nullable = false)
    private Coord coord;
	
	public Event() {};
	
	public Event(Integer id)
	{
		this.id = id;
		setEventName("");
		setDateStart(null);
		setDateEnd(null);
		setLocation("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	
	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

}
