package clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); //inicializamos una transacciónn para guardar datos
		Direccion f = new Direccion("Tandil", "San Martin 12");
		em.persist(f);
		//Turno t= new Turno();
		
		//em.persist(t);
		//Persona p= new Persona(3, "Santi", 33, f);
		//Persona p1= new Persona(4, "Paula", 26, f);
		Persona p= new Persona(6, "Manuel Logo", 25, f);
		Persona p1= new Persona(5, "Cecilia Morón", 25, f);
		em.persist(p1);
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
