package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuario")
@Getter @ Setter @AllArgsConstructor @NoArgsConstructor @Data @Builder

public class Entity_Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(min=2,max=50,message="Longitud mínima de caracteres 2")
	@Column(name="nombre", length = 50)
	private String nombre;
	
	@NotBlank
	@Size(min=2,max=50,message="Longitud mínima de caracteres 2")
	@Column(name="usuario", length = 50)
	private String usuarion;
	
	@NotBlank
	@Column(name="contrasena", length = 50)
	private String contrasena;
	

	@Transient
	private String ccontrasena;

}
