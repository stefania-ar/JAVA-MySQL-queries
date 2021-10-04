package clases;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

@Entity
public class Persona {
	
	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private int edad;
	@ManyToOne
	private Direccion dir;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "jugadores")
	private List<Turno> turnos;
	
	public Persona(int id, String nombre, int edad, Direccion dir) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.dir = dir;
	}
	
	public List<Persona> getPersonasConTurno(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		

		String select = "SELECT * FROM persona_turno"; 
		@SuppressWarnings("unchecked")
		List <Persona> personasConTurno= em.createQuery(select).getResultList();
		
		return personasConTurno;
		
	}
	
	public Persona () {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", dir=" + dir + "]";
	}
}
