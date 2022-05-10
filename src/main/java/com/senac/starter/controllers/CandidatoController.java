package com.senac.starter.controllers;

import com.senac.starter.models.Candidato;
import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.CandidatoRepository;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("candidato/candidatos");
        List<Candidato> candidatos =candidatoRepository.findAll();
        modelAndView.addObject("candidatos", candidatos);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharUsuario(@PathVariable Long id){

        Candidato candidato = candidatoRepository.findCandidatoById(id);
        ModelAndView modelAndView  = new ModelAndView("candidato/candidato-detalhe");
        modelAndView.addObject("candidato",candidato);

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios",usuarios);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("candidato/candidato-detalhe");
        Candidato candidato = new Candidato();
        modelAndView.addObject("candidato", candidato);

        List<Usuario> usuarios = usuarioRepository.findAll();
        modelAndView.addObject("usuarios",usuarios);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarUsuario(Candidato candidato){

        candidatoRepository.save(candidato);
        return "redirect:/candidatos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Candidato candidato = candidatoRepository.findCandidatoById(id);
        candidatoRepository.delete(candidato);
        return "redirect:/candidatos";
    }
}

