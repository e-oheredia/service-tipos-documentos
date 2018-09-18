package com.exact.service.documentos.service;

import com.exact.service.documentos.entity.TipoDocumento;

public interface ITipoDocumentoService {
	
	public Iterable<TipoDocumento> guardar(Iterable<TipoDocumento> tiposDocumento); 
	public Iterable<TipoDocumento> listarPrimerNivel();
	Iterable<TipoDocumento> listarByIds(Iterable<Long> ids);
	
	
}
