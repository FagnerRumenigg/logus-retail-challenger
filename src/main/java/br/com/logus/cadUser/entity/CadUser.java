package br.com.logus.cadUser.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name="cadusuarios")
public class CadUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	@Column(name="idcadusuario")
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
	@Column(name="dat_Cadastro")
	private LocalDate datCadastro;
	
	@Getter @Setter
	@Column(name="dat_desativacao")
	private LocalDate datDesativacao;
}
