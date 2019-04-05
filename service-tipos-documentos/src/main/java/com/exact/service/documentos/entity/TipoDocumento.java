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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tipo_documento_id")	
	private Long id; 
	
	@Column(nullable=false, length=100, unique=true)
	private String nombre;
	
	@Column(nullable=false)
	private boolean activo;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="jerarquia_tipo_documento", joinColumns = { @JoinColumn(name = "tipo_documento_padre_id") },
    inverseJoinColumns = { @JoinColumn(name = "tipo_documento_hijo_id") })
	private Set<TipoDocumento> tiposDocumento;		

	public Set<TipoDocumento> getTiposDocumento() {
		return tiposDocumento;
	}
	public void setTiposDocumento(Set<TipoDocumento> tiposDocumento) {
		this.tiposDocumento = tiposDocumento;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="tipo_documento_tipo_cuantificacion", joinColumns = { @JoinColumn(name = "tipo_documento_id") },
            inverseJoinColumns = { @JoinColumn(name = "tipo_cuantificacion_id") })	
	private Set<TipoCuantificacion> tiposCuantificacion;
	
	public Set<TipoCuantificacion> getTiposCuantificacion() {
		return tiposCuantificacion;
	}
	public void setTiposCuantificacion(Set<TipoCuantificacion> tiposCuantificacion) {
		this.tiposCuantificacion = tiposCuantificacion;
	}
	
	
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
