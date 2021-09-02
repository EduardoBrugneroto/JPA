package br.com.alura.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public	CategoriaDao(EntityManager em) {
		this.em = em;
	}


	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}

