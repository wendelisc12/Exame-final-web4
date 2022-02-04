package br.ifpe.web.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web.com.dao.PerfilDao;
import br.ifpe.web.com.exception.ServiceException;
import br.ifpe.web.com.model.Perfil;

@Service
public class PerfilService {
	@Autowired
	private PerfilDao perfilDao;

	public String efetuarLogin(Perfil perfil) throws ServiceException {
		Perfil conta = perfilDao.findByCpfAndSenha(perfil.getCpf(), perfil.getSenha());

		if (conta == null) {
			throw new ServiceException("Login e senha inválidos");
		}
		System.out.println(conta.getTipoPerfil());
		return conta.getTipoPerfil().toString();
	}
	
	public void inserirPerfil(Perfil perfil) {
		perfilDao.save(perfil);
	}
}
