package com.exact.service.documentos.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.exact.service.documentos.entity.TipoDocumento;
import com.exact.service.documentos.service.ITipoDocumentoService;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

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
	
//	@PostMapping
//	public ResponseEntity<Iterable<TipoDocumento>> guardar(@RequestBody Iterable<TipoDocumento> tiposDocumento){
//		Iterable<TipoDocumento> tiposDocumentoNuevo = null;
//		ResponseEntity<Iterable<TipoDocumento>> response = null;
//		try {
//			tiposDocumentoNuevo = tipoDocumentoService.guardar(tiposDocumento);
//			response = new ResponseEntity<Iterable<TipoDocumento>>(tiposDocumentoNuevo, HttpStatus.OK);	
//			return response;
//		} catch (Exception e) {	
//			response = new ResponseEntity<Iterable<TipoDocumento>>(tiposDocumentoNuevo, HttpStatus.BAD_REQUEST);		
//			return response;
//		}
//		
//	}

	 @GetMapping(params = {"ids"})
	 public ResponseEntity<Iterable<TipoDocumento>> listarByIds(@RequestParam List<Long> ids){
		 return new ResponseEntity<Iterable<TipoDocumento>>(tipoDocumentoService.listarByIds(ids), HttpStatus.OK);
	 }
	 
	 @GetMapping("/activos")
		public ResponseEntity<Iterable<TipoDocumento>> listarActivos(){
		 return new ResponseEntity<Iterable<TipoDocumento>>(tipoDocumentoService.listarActivos(), HttpStatus.OK);
	}
	 
	 @PostMapping
		public ResponseEntity<TipoDocumento> guardar(@RequestBody String tipoDocumento){
		 	ObjectMapper mapper = new ObjectMapper();	
			TipoDocumento tipodocumentoBD=null;
			try {
				tipodocumentoBD = mapper.readValue(tipoDocumento, TipoDocumento.class);
				tipodocumentoBD.setActivo(true);
				return new ResponseEntity<TipoDocumento>(tipoDocumentoService.guardarTipoDocumento(tipodocumentoBD), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<TipoDocumento>(HttpStatus.BAD_REQUEST);
			}
	}
	 
	 @PutMapping("/{id}")
		public ResponseEntity<TipoDocumento> modificar(@PathVariable Long id , @RequestBody String tipoDocumento){
		 	ObjectMapper mapper = new ObjectMapper();
			TipoDocumento tipodocumentoBD=null;
			try {
				tipodocumentoBD = mapper.readValue(tipoDocumento, TipoDocumento.class);
				tipodocumentoBD.setId(id);
				 return new ResponseEntity<TipoDocumento>(tipoDocumentoService.guardarTipoDocumento(tipodocumentoBD), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<TipoDocumento>(HttpStatus.BAD_REQUEST);
		}
			
	}
	 
	
	
}
