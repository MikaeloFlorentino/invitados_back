package com.example.mikaelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mikaelo.entity.Invitado;

@Repository
public interface InvitadosRepository  extends JpaRepository<Invitado, Integer>{

	Invitado findByNombre(String nombre);

	/*
	 * @Query("select c from Click c where c.annio =:#{#cl.annio} and c.mes =:#{#cl.mes} order by c.numeroClick")
	List<Click> getMes(@Param("cl") Click click);
	 */
	@Transactional
	  @Modifying
	@Query("update Invitado i set i.confirmaAsistencia=:#{#in.confirmaAsistencia}, i.fechaConfimacion=NOW() where i.id=:#{#in.id}")
	void confirmaAsistencia(@Param("in") Invitado invitado);
	

	@Transactional
	  @Modifying
	@Query("update Invitado i set i.mensaje=:#{#in.mensaje}  where i.id=:#{#in.id}")
	void actualizaMensaje(@Param("in") Invitado invitado);
}
