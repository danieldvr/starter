package com.senac.starter.controllers;

import com.senac.starter.models.Resultado;
import com.senac.starter.repositorys.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired

    ResultadoRepository resultadoRepository;

    @GetMapping("")
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("resultado/resultados");
        List<Resultado> resultados =resultadoRepository.findAll();
        modelAndView.addObject("resultados", resultados);
        return modelAndView;

    }

    @GetMapping("/{id}")
    public ModelAndView detalharresultado(@PathVariable Long id){

        Resultado resultado = resultadoRepository.findResultadoByid(id);
        ModelAndView modelAndView  = new ModelAndView("resultado/resultado-detalhe");
        modelAndView.addObject("resultado",resultado);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView adicionar(){

        ModelAndView modelAndView = new ModelAndView("resultado/resultado-detalhe");
        Resultado resultado = new Resultado();
        modelAndView.addObject("resultado", resultado);
        return modelAndView;
    }

    @PostMapping("/add")
    public String adicionarresultado(Resultado resultado){

        resultadoRepository.save(resultado);
        return "redirect:/resultados";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){

        Resultado resultado = resultadoRepository.findResultadoByid(id);
        resultadoRepository.delete(resultado);
        return "redirect:/resultados";
    }
}
