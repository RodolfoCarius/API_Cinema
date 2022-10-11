package br.com.residencia.Cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.Cinema.entity.Genero;
import br.com.residencia.Cinema.repository.GeneroRepository;

@Service
public class GeneroService {
	@Autowired
	GeneroRepository generoRepository;
	
	public List<Genero> getAllGeneros(Genero genero){
		return generoRepository.findAll();
	}
	
	public Genero getGeneroById(Integer id) {
		return generoRepository.findById(id).orElse(null);
	}
	
	public Genero saveGenero(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero updateGenero(Genero genero, Integer id) {
		Genero generoExistenteNoBanco = getGeneroById(id);
		generoExistenteNoBanco.setFilmes(genero.getFilmes());
		generoExistenteNoBanco.setGenero(genero.getGenero());
		generoExistenteNoBanco.setIdGenero(genero.getIdGenero());
		return generoRepository.save(generoExistenteNoBanco);
	}
	
	public Genero deleteGenero(Integer id) {
		generoRepository.deleteById(id);
		return getGeneroById(id);
	}
}
