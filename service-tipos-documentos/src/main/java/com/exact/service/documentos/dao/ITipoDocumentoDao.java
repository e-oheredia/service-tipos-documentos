package com.exact.service.documentos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exact.service.documentos.entity.TipoDocumento;

@Repository
public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Long>{
	
	@Query(value="SELECT TD.* FROM tipo_documento TD WHERE TD.tipo_documento_id NOT IN (SELECT JTD.tipo_documento_hijo_id FROM jerarquia_tipo_documento JTD)", 
			nativeQuery=true
		   )
	public Iterable<TipoDocumento> listarPrimerNivel();
	
	@Query("SELECT TD FROM TipoDocumento TD WHERE TD.id NOT IN :ids")
	public Iterable<TipoDocumento> listarNoEncontrados(@Param("ids") List<Long> ids);
	
}
