package com.example.gestao_de_livros.Controller;

import com.example.gestao_de_livros.Model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    private ArrayList<Livro> listaDeLivros = new ArrayList<>();

    @GetMapping("/lista")
    public ArrayList<Livro> listarTodos() {
        return listaDeLivros;
    }

    @PostMapping("/inserir")
    public String inserirLivro(@RequestBody Livro livro) {
        listaDeLivros.add(livro);
        return "Livro inserido com sucesso!";
    }

    @GetMapping("/existe-livro")
    public boolean existeLivro(@RequestParam String nome) {
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equals(nome)) {
                return true;
            }
        }
        return false;
        }

    @GetMapping("/pesquisa-titulo")
    public Livro pesquisaTitulo(@RequestParam String titulo) {
        for (Livro livro : listaDeLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }
    }

