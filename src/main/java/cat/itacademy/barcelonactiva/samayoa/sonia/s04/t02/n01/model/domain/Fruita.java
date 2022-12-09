package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FRUITA")
public class Fruita {
	@Id
	@Column(name = "Fruita_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "quantitatKg")
	private int quilos;

	public Fruita(String nom, int quilos) {
		this.nom = nom;
		this.quilos = quilos;
	}

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuilos() {
		return quilos;
	}
	
	public void setQuilos(int quilos) {
		this.quilos = quilos;
	}

	public void modificarQuilos(int cantidadModificar) {
		this.quilos += cantidadModificar;
	}

	@Override
	public String toString() {
		return "Fruita-> id: " + id + ", nom: " + nom + ", quilos: " + quilos;
	}

}
