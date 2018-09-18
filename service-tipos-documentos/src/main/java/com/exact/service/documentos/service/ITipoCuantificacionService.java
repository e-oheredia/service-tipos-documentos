package com.exact.service.documentos.service;

import com.exact.service.documentos.entity.TipoCuantificacion;

public interface ITipoCuantificacionService {
	public Iterable<TipoCuantificacion> guardar(Iterable<TipoCuantificacion> tipoCuantificacion);  
	public Iterable<TipoCuantificacion> listarTodos();
}
