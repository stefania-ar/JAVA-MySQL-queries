package clases;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;



public class Select{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); //inicializamos una transacciónn para guardar datos
		Persona pp = em.find(Persona.class, 3);
		//String ss= "SELECT * FROM Persona ORDER BY Id";


		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery <Persona> q = cb.createQuery(Persona.class);
		Root<Persona> c = q.from(Persona.class);

		//Join<Direccion> p = c.join("capital", JoinType.LEFT);
		q.groupBy(c.get("dir"));
		TypedQuery<Persona> find = em.createQuery(q);
		List<Persona> findAllBooks = find.getResultList();

		//FROM Person p JOIN PhoneBookEntry n ON p.firstName = n.firstName
		TypedQuery <Object[]> query =
				em.createQuery("SELECT n.ciudad, n.calle, COUNT(c), COUNT (DISTINCT c.dir) "
						+ "FROM Persona c JOIN Direccion n ON c.dir= n.id" 
						+ " GROUP BY c.dir", Object[].class);

		List<Object[]> l= query.getResultList();
		for (Object[] persona : l) {
			int i=0;
			System.out.println(persona[0]+ " "+ persona[1]+ " "+ " hay personas "+persona[2]+  " viviendo en esta direccion");
			i++;
		}

		for (Persona p : findAllBooks) {
			System.out.println(p);
		}
		System.out.println(pp);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
