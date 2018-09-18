package com.exact.service.documentos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exact.service.documentos.dao.ITipoCuantificacionDao;
import com.exact.service.documentos.entity.TipoCuantificacion;

@Service
public class TipoCuantificacionService implements ITipoCuantificacionService {
	
	@Autowired
	ITipoCuantificacionDao tipoCuantificacionDao;
	
	@Override
	public Iterable<TipoCuantificacion> guardar(Iterable<TipoCuantificacion> tiposCuantificacion) {
		List<TipoCuantificacion> nuevosTiposCuantificacion = new ArrayList<TipoCuantificacion>();		
		tiposCuantificacion.forEach(
				tipoCuantificacion -> {
					nuevosTiposCuantificacion.add(tipoCuantificacionDao.save(tipoCuantificacion));
					});
		return nuevosTiposCuantificacion;
	}

	@Override
	public Iterable<TipoCuantificacion> listarTodos() {
		return tipoCuantificacionDao.findAll();
	}

}
