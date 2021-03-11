package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Entity_Usuario;
import com.example.demo.service.Ser_Usuario;

@Controller
public class Crud {

	@Autowired
	private Ser_Usuario ser_Usuario;
	
	@GetMapping("/Usuario")
	public ModelAndView inicioPrincipal() {
		ModelAndView vista = new ModelAndView("user");
		vista.addObject("user",new Entity_Usuario());
		vista.addObject("lista", ser_Usuario.usuarios());
		return vista;
	}
	
	@PostMapping("/RegistroUsuario")
	public String registrarUsuario(@Valid @ModelAttribute ("user") Entity_Usuario usuario,
			 BindingResult result,RedirectAttributes flash, Model model) {
		
		String a="";
		if (result.hasErrors()) {
			model.addAttribute("user", usuario);
			model.addAttribute("lista", ser_Usuario.usuarios());
			return "/user";
		} else {
			try {
				if(ser_Usuario.saveUsuario(usuario).equals("incongruencias de contraseñas")) {
					model.addAttribute("user", usuario);
					flash.addFlashAttribute("aa", "Contraseñas no identicas");
					a= "redirect:/Usuario";
				}else {
					flash.addFlashAttribute("success", "Registro exitoso");
					a="redirect:/Usuario";	
				}
				model.addAttribute("lista", ser_Usuario.usuarios());
			} catch (Exception e) {
				flash.addFlashAttribute("danger", "Error al registrar");
				return "redirect:/Usuario";
			}
		}
		return a;
	}
	
	@GetMapping("/EliminarUsuario/{id}")
	public String eliminarEmpleado(@PathVariable(name="id",required = true) int id,RedirectAttributes flash) {
		try {
			flash.addFlashAttribute("success", ser_Usuario.deleteUsuario(id));
		}catch (Exception e) {
			flash.addFlashAttribute("danger", "Error al eliminar");
			return "redirect:/Usuario";
		}
		return "redirect:/Usuario";
	}
	
	@GetMapping("/ModificarUsuario/{id}")
	public ModelAndView ModificarEmpleados(@PathVariable(name="id",required = true) int id) {
		ModelAndView vista = new ModelAndView("user");
		vista.addObject("user", ser_Usuario.UsuariofindById(id));
		vista.addObject("lista", ser_Usuario.usuarios());
		return vista;
	}
	
}
