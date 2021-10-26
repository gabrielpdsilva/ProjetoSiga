package com.projeto.siga.ProjetoSiga.controller;

import java.sql.SQLException;
import java.util.Map;

import com.projeto.siga.ProjetoSiga.model.Aluno;
import com.projeto.siga.ProjetoSiga.persistence.AlunoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LancarNotasController {

    @Autowired
    AlunoDao aDao;

    //GET
    @RequestMapping(name = "lancar-notas", value = "/lancar-notas", method = RequestMethod.GET)
    public ModelAndView init(ModelMap model) {

        return new ModelAndView("lancar-notas");
    }

    //POST
    @RequestMapping(name = "lancar-notas", value = "/lancar-notas", method = RequestMethod.POST)
    public ModelAndView op(
            @RequestParam Map<String, String> allRequestParam,
            ModelMap model
    ) {
        String raAluno = allRequestParam.get("raAluno");
        String erro = "";
        Aluno a = new Aluno();
        a.setRa("1");
        try {
            a = aDao.buscarAluno(a);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            erro = e.getMessage();
        } finally {
            //model.addAttribute("listaPratoReserva", listaPratoReserva);
            model.addAttribute("erro", erro);
        }
        return new ModelAndView("lancar-notas");
    }

}
