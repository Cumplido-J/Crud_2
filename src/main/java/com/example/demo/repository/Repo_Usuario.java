package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Entity_Usuario;

@Repository
public interface Repo_Usuario extends JpaRepository<Entity_Usuario, Serializable>{

}
