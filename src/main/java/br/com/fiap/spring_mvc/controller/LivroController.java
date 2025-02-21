package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.dto.LivroRequest;
import br.com.fiap.spring_mvc.model.Livro;
import br.com.fiap.spring_mvc.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Livro")
public class LivroController {
    @Autowired
    LivroService livroService
    @GetMapping("/Cadastro")
    public ModelAndView livroCadastro(){
        ModelAndView mv = new ModelAndView("livroCadastro");
        return mv;
    }
    @PatchMapping("/cadastrar")
    public ModelAndView cadastrarLivro(@Valid @ModelAttribute LivroRequest livroRequest) {
        Livro livro = livroService.salvarLivro(livroRequest);

        return  listarLivros();
    }
    @GetMapping("/lista")
    public ModelAndView listarLivros(){
        return new ModelAndView("livrolista");
    }
}
