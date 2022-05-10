package com.senac.starter.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.senac.starter.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class SiteController {

    @GetMapping
    public ModelAndView dashBoard() {

        return new ModelAndView("index");
    }

    @GetMapping("/aviso")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        Usuario usuario = new Usuario("paulo", 60, true);

        LocalDateTime now = LocalDateTime.now();
        String mensagem = "";
        if (usuario.isCasado()) {
            mensagem = "Bem vindo " + usuario.getNome() + " agora são: " + now.getHour()
                    + " horas e " + now.getMinute() + " minutos.\n" + "Verificamos que você é casado e tem " + usuario.getIdade() + " anos";

        } else {
            mensagem = "Bem vindo " + usuario.getNome() + " agora são: " + now.getHour()
                    + " horas e " + now.getMinute() + " minutos.\n" + "Verificamos que você não é casado e tem " + usuario.getIdade() + " anos";
        }


        modelAndView.addObject("mensagem", mensagem);
        return modelAndView;
    }
}









