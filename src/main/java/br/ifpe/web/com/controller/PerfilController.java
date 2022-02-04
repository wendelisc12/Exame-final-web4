package br.ifpe.web.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web.com.exception.ServiceException;
import br.ifpe.web.com.model.Perfil;
import br.ifpe.web.com.service.PerfilService;

@Controller
public class PerfilController {
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping("/")
	public String exibirIndex() {
		return "index";
	}
	
	@GetMapping("/exibirCadastro")
	public String exibirCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/exibirEstudante")
	public String exibirEstudante() {
		return "estudante";
	}
	
	@GetMapping("/exibirProfessor")
	public String exibirProfessor() {
		return "professor";
	}
	
	@GetMapping("/exibirGestor")
	public String exibirGestor() {
		return "gestor";
	}
	
	@PostMapping("/salvarPerfil")
	public String salvarPerfil(Perfil perfil) {
		this.perfilService.inserirPerfil(perfil);
		return "index";
	}
	
	@PostMapping("/loginPerfil")
	public String loginPerfil(Perfil perfil) throws ServiceException {
		try {
			 
			 if(perfilService.efetuarLogin(perfil).equals("Estudante")) {
				 return "redirect:/exibirEstudante";
			 }
			 if(perfilService.efetuarLogin(perfil).equals("Professor")) {
				 return "redirect:/exibirProfessor";
			 }
			 if(perfilService.efetuarLogin(perfil).equals("Gestor")) {
				 return "redirect:/exibirGestor";
			 }
			 
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
		
		System.out.println(perfil);
		return "redirect:/";
	}
}
