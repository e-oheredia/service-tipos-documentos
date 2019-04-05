package com.exact.service.documentos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exact.service.documentos.dao.ITipoDocumentoDao;
import com.exact.service.documentos.entity.TipoDocumento;

@Service
public class TipoDocumentoService implements ITipoDocumentoService {
	
	@Autowired
	ITipoDocumentoDao tipoDocumentoDao;

	@Override
	@Transactional
	public Iterable<TipoDocumento> guardar(Iterable<TipoDocumento> tiposDocumento){
		Iterable<TipoDocumento> tiposDocumentoNoIncluidos = 
				(Iterable<TipoDocumento>) tipoDocumentoDao.listarNoEncontrados(
				((List<TipoDocumento>)tiposDocumento).stream().map(TipoDocumento::getId).collect(Collectors.toList())); 
		tipoDocumentoDao.deleteAll(tiposDocumentoNoIncluidos);
		List<TipoDocumento> nuevosTiposDocumento = new ArrayList<TipoDocumento>();		
		tiposDocumento.forEach(
				tipoDocumento -> {
					nuevosTiposDocumento.add(tipoDocumentoDao.save(tipoDocumento));
					});
		return nuevosTiposDocumento;		
	}

	@Override
	public Iterable<TipoDocumento> listarPrimerNivel() {
		return tipoDocumentoDao.listarPrimerNivel();
	}

	@Override
	public Iterable<TipoDocumento> listarByIds(Iterable<Long> ids) {
		return tipoDocumentoDao.findAllById(ids);
	}
	
	@Override
	public TipoDocumento guardarTipoDocumento(TipoDocumento tipoDocumento) {
		return tipoDocumentoDao.save(tipoDocumento);
	}

	@Override
	public Iterable<TipoDocumento> listarActivos() {
		Iterable<TipoDocumento> tipodocumentosBD = tipoDocumentoDao.findAll();
		List<TipoDocumento> tipodocumentos = StreamSupport.stream(tipodocumentosBD.spliterator(), false).collect(Collectors.toList());
		tipodocumentos.removeIf(tipodoc -> !tipodoc.isActivo());
		return tipodocumentos;
				
	}
	
	
	
}
