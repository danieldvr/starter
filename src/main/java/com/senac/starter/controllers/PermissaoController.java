package com.senac.starter.controllers;

import com.senac.starter.models.Permissao;
import com.senac.starter.repositorys.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    PermissaoRepository permissaoRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("permissao/permissoes");
        List<Permissao> permissoes =permissaoRepository.findAll();
        modelAndView.addObject("permissoes", permissoes);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharPermissao(@PathVariable Long id){

        Permissao permissao = permissaoRepository.findPermissaoById(id);
        ModelAndView modelAndView  = new ModelAndView("permissao/permissao-detalhe");
        modelAndView.addObject("permissao",permissao);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("permissao/permissao-detalhe");
        Permissao permissao = new Permissao();
        modelAndView.addObject("permissao", permissao);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarPermissao(Permissao permissao){

        permissaoRepository.save(permissao);
        return "redirect:/permissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Permissao permissao = permissaoRepository.findPermissaoById(id);
        permissaoRepository.delete(permissao);
        return "redirect:/permissoes";
    }
}
