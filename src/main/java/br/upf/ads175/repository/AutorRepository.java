package br.upf.ads175.repository;

import br.upf.ads175.entity.Autor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AutorRepository {

    @Inject
    @PersistenceContext
    private EntityManager em;

    public List<Autor> findAll() {
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        return !autores.isEmpty() ? autores : null;
    }

    public List<Autor> findAllComLivros() {
        List<Autor> autores = em.createQuery("SELECT DISTINCT a FROM Autor a LEFT JOIN FETCH a.livros", Autor.class).getResultList();
        return !autores.isEmpty() ? autores : null;
    }

    public Long count () {
        return em.createQuery("SELECT COUNT(a) FROM Autor a", Long.class).getSingleResult();
    }
}