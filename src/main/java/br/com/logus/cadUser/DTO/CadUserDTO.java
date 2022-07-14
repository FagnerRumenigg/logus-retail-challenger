package br.com.logus.cadUser.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CadUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Integer idCadUsuario;
	
	@Getter @Setter
	@Column(name="dcr_usuario")
	private String dcrUsuario;
	
	@Getter @Setter
	@Column(name="dcr_login")
	private String dcrLogin;
	
	@Getter @Setter
	@Column(name="dcr_senha")
	private String dcrSenha;

	@Getter @Setter
	private LocalDateTime datCadastro;
	
	@Getter @Setter
	@Column(name="dat_desativacao")
	private LocalDateTime datDesativacao;
}
