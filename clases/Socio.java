package clases;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Socio {

	@Id
	private int id;
	
	@OneToOne(cascade= CascadeType.ALL)
	@MapsId  //Mapea sobre el id, lo hace id a ambos, la PK es tambien FK (????
	private Persona pers;
	@Column
	private String tipo;
	
	public Socio() {
		
	}
	
	public Socio(Persona p, String tipo) {
		this.pers=p;
		this.tipo=tipo;
	}
}
