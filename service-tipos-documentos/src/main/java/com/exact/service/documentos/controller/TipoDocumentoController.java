package com.exact.service.documentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.documentos.entity.TipoDocumento;
import com.exact.service.documentos.service.ITipoDocumentoService;

@RestController
@RequestMapping("/tiposdocumento")
public class TipoDocumentoController {
	
	@Autowired
	ITipoDocumentoService tipoDocumentoService;		
	
	@GetMapping
	public ResponseEntity<Iterable<TipoDocumento>> listarPrimerNivel(){
		Iterable<TipoDocumento> tiposDocumento = tipoDocumentoService.listarPrimerNivel();
		return new ResponseEntity<Iterable<TipoDocumento>>(tiposDocumento, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Iterable<TipoDocumento>> guardar(@RequestBody Iterable<TipoDocumento> tiposDocumento){
		Iterable<TipoDocumento> tiposDocumentoNuevo = null;
		ResponseEntity<Iterable<TipoDocumento>> response = null;
		try {
			tiposDocumentoNuevo = tipoDocumentoService.guardar(tiposDocumento);
			response = new ResponseEntity<Iterable<TipoDocumento>>(tiposDocumentoNuevo, HttpStatus.OK);	
			return response;
		} catch (Exception e) {	
			response = new ResponseEntity<Iterable<TipoDocumento>>(tiposDocumentoNuevo, HttpStatus.BAD_REQUEST);		
			return response;
		}
		
	}
	
<<<<<<< HEAD
	 @GetMapping(params="ids")
=======
	 @GetMapping(params = {"ids"})
>>>>>>> branch 'master' of https://github.com/e-oheredia/service-tipos-documentos
	 public ResponseEntity<Iterable<TipoDocumento>> listarByIds(@RequestParam List<Long> ids){
		 return new ResponseEntity<Iterable<TipoDocumento>>(tipoDocumentoService.listarByIds(ids), HttpStatus.OK);
	 }
	
	
}
