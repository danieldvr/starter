package com.senac.starter.controllers;

import com.senac.starter.models.Usuario;
import com.senac.starter.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("usuario/usuarios");
        List<Usuario> usuarios =usuarioRepository.findAll();
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharUsuario(@PathVariable Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);
        ModelAndView modelAndView  = new ModelAndView("usuario/usuario-detalhe");
        modelAndView.addObject("usuario",usuario);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("usuario/usuario-detalhe");
        Usuario usuario = new Usuario();
        modelAndView.addObject("usuario", usuario);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarUsuario(Usuario usuario){

        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Usuario usuario = usuarioRepository.findUsuarioById(id);
        usuarioRepository.delete(usuario);
        return "redirect:/usuarios";
    }
}
