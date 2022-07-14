package br.com.logus.cadUser.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logus.cadUser.DTO.CadUserDTO;
import br.com.logus.cadUser.entity.CadUser;
import br.com.logus.cadUser.service.CadUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class CadUserController {
	
	private final CadUserService service;
	
	@GetMapping
	public ResponseEntity<List<CadUser>> findAll(){
		List<CadUser> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity insertUsuario(@RequestBody CadUserDTO cadUsuarioDto) {
		if(cadUsuarioDto.getDcrSenha().matches("^(?=.*[!#@$%&])(?=.*[0-9])(?=.*[a-z]).{8,}$")) {
			Boolean isSave = service.insertUser(cadUsuarioDto);
			if(isSave) {
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Esse login já esta sendo usado"); 
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("A senha deve conter no mínimo 8 caracteres, é necessário ao menos 1 símbolo e 1\r\n"
					+ "número "); 
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity updateUsuario(@PathVariable Integer id, @RequestBody CadUserDTO cadUsuarioDto){
		Boolean isSave = service.updateUser(id, cadUsuarioDto);
		if(isSave) {
			return ResponseEntity.ok().body("Atualizado");		
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Esse login já esta sendo usado"); 
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteUsuario(@PathVariable Integer id) {
		service.deleteUser(id);
		return ResponseEntity.ok().body(null);
	}
}
