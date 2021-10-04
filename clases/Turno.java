package clases;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turno {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Persona> jugadores;
	
	@Column
	private Timestamp fecha;


	public void setJugadores(List<Persona> jugadores) {
		this.jugadores = jugadores;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", jugadores=" + jugadores + ", fecha=" + fecha + "]";
	}
	
	
	
}
