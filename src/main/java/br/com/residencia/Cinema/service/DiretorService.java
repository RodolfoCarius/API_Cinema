package br.com.residencia.Cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.Cinema.entity.Diretor;
import br.com.residencia.Cinema.repository.DiretorRepository;

@Service
public class DiretorService {
	@Autowired
	DiretorRepository diretorRepository;
	
	public List<Diretor> getAllDiretores(){
		return diretorRepository.findAll();
	}
	
	public Diretor getDiretorById(Integer id) {
		return diretorRepository.findById(id).orElse(null);
	}
	
	public Diretor saveDiretor (Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	public Diretor updateDiretor(Diretor diretor, Integer id) {
		Diretor diretorExistenteNoBanco = getDiretorById(id);
		//diretorExistenteNoBanco.setFilmes(diretor.getFilmes());
		diretorExistenteNoBanco.setNome(diretor.getNome());
		return diretorRepository.save(diretorExistenteNoBanco);
	}
	
	public Diretor deleteDiretor(Integer id) {
		diretorRepository.deleteById(id);
		return getDiretorById(id);
	}
}
