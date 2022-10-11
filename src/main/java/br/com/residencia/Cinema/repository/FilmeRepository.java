package br.com.residencia.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.Cinema.entity.Filme;

public interface FilmeRepository extends JpaRepository <Filme , Integer>{

}
