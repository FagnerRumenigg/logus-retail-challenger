package br.com.logus.cadUser.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.logus.cadUser.entity.CadUser;

@Repository
public interface CadUserRepository extends JpaRepository<CadUser,Integer>{

	@Query(value = "SELECT * FROM CADUSUARIOS WHERE DCR_LOGIN = :LOGIN", nativeQuery=true)
	List<CadUser> findByUsuario(@Param("LOGIN") String login);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE CADUSUARIOS SET DCR_USUARIO = :USUARIO, DCR_LOGIN = :LOGIN, DCR_SENHA = :SENHA,"+
	"DAT_CADASTRO = :CADASTRO, DAT_DESATIVACAO = :DESATIVACAO WHERE idcadusuario = :ID", nativeQuery=true)
	void update(@Param("USUARIO") String usuario, @Param("LOGIN") String login, @Param("SENHA") String senha,
			@Param("CADASTRO") LocalDateTime cadastro, @Param("DESATIVACAO") LocalDateTime desativacao, @Param("ID") Integer id);
	
}
