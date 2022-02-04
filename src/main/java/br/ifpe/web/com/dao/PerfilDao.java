package br.ifpe.web.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.web.com.model.Perfil;

@Repository
public interface PerfilDao extends JpaRepository<Perfil, Integer>{
	
	public Perfil findByCpfAndSenha(String cpf, String senha);
	
}
