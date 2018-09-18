package com.exact.service.documentos.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="tipo_cuantificacion")
public class TipoCuantificacion implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_cuantificacion_id", columnDefinition="TINYINT")
	private Long id;
	@Column(nullable=false, length=100, unique=true)
	private String nombre;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="tipo_cuantificacion_id")
	@NotEmpty
	private Set<UnidadCuantificacion> unidadesCuantificacion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<UnidadCuantificacion> getUnidadesCuantificacion() {
		return unidadesCuantificacion;
	}
	public void setUnidadesCuantificacion(Set<UnidadCuantificacion> unidadesCuantificacion) {
		this.unidadesCuantificacion = unidadesCuantificacion;
	}
	
	public void addUnidadCuantificacion(UnidadCuantificacion unidadCuantificacion) {
		this.unidadesCuantificacion.add(unidadCuantificacion);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
