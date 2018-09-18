package com.exact.service.documentos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exact.service.documentos.entity.TipoCuantificacion;

@Repository
public interface ITipoCuantificacionDao extends CrudRepository<TipoCuantificacion, Long>{

}
