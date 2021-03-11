package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Entity_Usuario;
import com.example.demo.repository.Repo_Usuario;

@Service
public class Impl_Usuario implements Ser_Usuario{

	@Autowired
	private Repo_Usuario repo_usuario;
	
	@Override
	public List<Entity_Usuario> usuarios() {
		
		return repo_usuario.findAll();
	}

	@Override
	public Entity_Usuario UsuariofindById(int id) {
		
		return repo_usuario.findById(id).get();
	}

	@Override
	public String saveUsuario(Entity_Usuario usuario) {
		boolean cont=( usuario.getContrasena().equals(usuario.getCcontrasena())) ? true : false;
	
		
		if (cont) {
			repo_usuario.save(usuario);
			return "Registro exitoso";
		}else {
			return "incongruencias de contraseñas";
		}
	}

	@Override
	public String updateUsuario(Entity_Usuario usuario) {
		boolean cont=( usuario.getContrasena()==usuario.getCcontrasena() ) ? true : false;
		if (cont) {
			repo_usuario.save(usuario);
			return "Actualización exitosa";
		}else {
			return "incongruencias de contraseñas";
		}
	}

	@Override
	public String deleteUsuario(int id) {
		repo_usuario.delete(UsuariofindById(id));
		return "Eliminacion exitosa";
	}

}
