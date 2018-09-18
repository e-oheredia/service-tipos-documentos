package com.exact.service.documentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exact.service.documentos.entity.TipoCuantificacion;
import com.exact.service.documentos.service.ITipoCuantificacionService;

@RestController
@RequestMapping("/tiposcuantificacion")
public class TipoCuantificacionController {
	
	@Autowired
	ITipoCuantificacionService tipoCuantificacionService;		
	
	@GetMapping
	public ResponseEntity<Iterable<TipoCuantificacion>> listarTodos(){
		Iterable<TipoCuantificacion> tiposCuantificacion = tipoCuantificacionService.listarTodos();
		return new ResponseEntity<Iterable<TipoCuantificacion>>(tiposCuantificacion, HttpStatus.OK);
	}

}
