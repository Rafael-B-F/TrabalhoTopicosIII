package br.upf.ads175.service;

import br.upf.ads175.entity.Autor;
import br.upf.ads175.entity.Emprestimo;
import br.upf.ads175.entity.Livro;
import br.upf.ads175.repository.AutorRepository;
import br.upf.ads175.repository.EmprestimoRepository;
import br.upf.ads175.repository.LivroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BibliotecaService {

    @Inject
    private AutorRepository autorRepository;

    @Inject
    private LivroRepository livroRepository;

    @Inject
    private EmprestimoRepository emprestimoRepository;

    @Transactional
    public List<Autor> listarTodosAutores() {
        return autorRepository.findAll();
    }

    @Transactional
    public List<Autor> listarTodosAutoresComSeusLivros() {
        return autorRepository.findAllComLivros();
    }

    @Transactional
    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    @Transactional
    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    @Transactional
    public Long contarTotalLivros() {
        return livroRepository.count();
    }

    @Transactional
    public Long contarLivrosDisponiveis() {
        return livroRepository.countByDisponivel(true);
    }

    @Transactional
    public Long contarEmprestimosAtivos() {
        return emprestimoRepository.countAtivos();
    }

    @Transactional
    public Long contarTotalAutores() {
        return autorRepository.count();
    }
}