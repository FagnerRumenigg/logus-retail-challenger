package br.com.logus.cadUser.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.logus.cadUser.DTO.CadUserDTO;
import br.com.logus.cadUser.entity.CadUser;
import br.com.logus.cadUser.repository.CadUserRepository;

@Service
public class CadUserService {

	@Autowired
	private CadUserRepository repository;
	
	public Boolean insertUser(CadUserDTO cadUsuarioDto) {
		List<CadUser> userExists = repository.findByUsuario(cadUsuarioDto.getDcrLogin());
		CadUser user = new CadUser(null, cadUsuarioDto.getDcrUsuario(), cadUsuarioDto.getDcrLogin(), cadUsuarioDto.getDcrSenha(), LocalDateTime.now(), LocalDateTime.now());
		if(userExists.isEmpty()) {
			repository.save(user);
			return true;
		}else {
			return false;
		}
	}
	
	public List<CadUser> findAll(){
		repository.flush();
		return repository.findAll(Sort.by("idCadUsuario"));
	}
	
	public Boolean updateUser(Integer id, CadUserDTO cadUsuarioDto ) {
		List<CadUser> userExists = repository.findByUsuario(cadUsuarioDto.getDcrLogin());
		if(userExists.isEmpty()) {
			repository.update(cadUsuarioDto.getDcrUsuario(), cadUsuarioDto.getDcrLogin(), cadUsuarioDto.getDcrSenha(), LocalDateTime.now(), LocalDateTime.now(), id);
			return true;
		}else {
			return false;
		}
	}
	
	public void deleteUser(Integer id) {
		repository.deleteById(id);;
	}
}
