package com.mario.colegio.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="caja")
public class CajaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name="idmatricula")
	private MatriculasEntity matricula;
	
    @Column(name="importe")
    private double importe;
	
    
	
	public CajaEntity( MatriculasEntity matricula, double importe) {
		super();
		this.matricula = matricula;
		this.importe = importe;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public MatriculasEntity getMatricula() {
		return matricula;
	}



	public void setMatricula(MatriculasEntity matricula) {
		this.matricula = matricula;
	}



	public double getImporte() {
		return importe;
	}



	public void setImporte(double importe) {
		this.importe = importe;
	}



	public CajaEntity() {
		// TODO Auto-generated constructor stub
	}

}
