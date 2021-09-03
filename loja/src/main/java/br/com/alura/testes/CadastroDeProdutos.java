package br.com.alura.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.loja.Categoria;
import br.com.alura.loja.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDeProdutos {
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodosProNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
	
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Iphone");
		System.out.println(precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Iphone X", "128 gb", new BigDecimal("3500"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}
}
