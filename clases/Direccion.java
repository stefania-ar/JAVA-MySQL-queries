package clases;

import java.util.ArrayList;
import java.util.List;

/**import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;**/
import javax.persistence.*;

@Entity
public class Direccion {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column
	private String ciudad;
	@Column
	private String calle;
	@OneToMany(mappedBy="dir", fetch=FetchType.LAZY)
	private List<Persona> habitantes;
	
	public Direccion() {
		this.habitantes= new ArrayList<Persona>();
	}
	
	public Direccion(String ciudad, String calle) {
		super();
		this.ciudad = ciudad;
		this.calle = calle;
		this.habitantes= new ArrayList<Persona>();
	}



	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", calle=" + calle + "]";
	}
}
