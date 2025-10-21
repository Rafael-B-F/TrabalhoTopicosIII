package br.upf.ads175.repository;

import br.upf.ads175.entity.Autor;
import br.upf.ads175.entity.Livro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class LivroRepository {

    @Inject
    @PersistenceContext
    private EntityManager em;

    public List<Livro> findAll() {
        List<Livro> livros = em.createQuery("SELECT l FROM Livro l LEFT JOIN FETCH l.autor", Livro.class).getResultList();
        return !livros.isEmpty() ? livros : null;
    }

    public Long count() {
        return em.createQuery("SELECT COUNT(l) FROM Livro l", Long.class).getSingleResult();
    }

    public Long countByDisponivel(Boolean disponivel) {
        return em.createQuery("SELECT COUNT(l) FROM Livro l WHERE l.disponivel = :disponivel", Long.class)
                .setParameter("disponivel", disponivel)
                .getSingleResult();
    }
}