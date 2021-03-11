package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Entity_Usuario;

public interface Ser_Usuario {

	public List<Entity_Usuario> usuarios();
	
	public Entity_Usuario UsuariofindById(int id);
	
	public String saveUsuario(Entity_Usuario usuario);
	
	public String updateUsuario(Entity_Usuario usuario);
	
	public String deleteUsuario(int id);
}
