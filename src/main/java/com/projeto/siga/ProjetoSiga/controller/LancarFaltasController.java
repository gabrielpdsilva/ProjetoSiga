package com.projeto.siga.ProjetoSiga.controller;

import com.projeto.siga.ProjetoSiga.model.Aluno;
import com.projeto.siga.ProjetoSiga.model.Disciplina;
import com.projeto.siga.ProjetoSiga.model.Falta;
import com.projeto.siga.ProjetoSiga.persistence.AlunoDao;
import com.projeto.siga.ProjetoSiga.persistence.DisciplinaDao;
import com.projeto.siga.ProjetoSiga.persistence.FaltaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class LancarFaltasController {
    @Autowired
    AlunoDao aDao;

    @Autowired
    FaltaDao fDao;

    @Autowired
    DisciplinaDao dDao;

    //GET
    @RequestMapping(name = "lancar-faltas", value = "/lancar-faltas", method = RequestMethod.GET)
    public ModelAndView init(ModelMap model) {
        String erro = "";
        List<Disciplina> listaDeDisciplinas = new ArrayList<>();
        try {
            listaDeDisciplinas = dDao.listarDisciplinas();
            for(Disciplina d: listaDeDisciplinas) {
                System.out.println(d.getNome());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            erro = e.getMessage();
        } finally {
            model.addAttribute("listaDeDisciplinas", listaDeDisciplinas);
            model.addAttribute("erro", erro);
        }
        return new ModelAndView("lancar-faltas");
    }

    // TODO finish
    //POST
    @RequestMapping(name = "lancar-faltas", value = "/lancar-faltas", method = RequestMethod.POST)
    public ModelAndView op(
            @RequestParam Map<String, String> allRequestParam,
            ModelMap model
    ) {

        Aluno aluno = new Aluno();
        aluno.setRa("1");

        String codigoDisciplina = allRequestParam.get("disciplinas");
        Disciplina disciplina = new Disciplina();
        disciplina.setCodigo(codigoDisciplina);

        Date data = new Date();
        int numFalta = 4;
        String erro = "";
        Falta falta = new Falta();
        falta.setAluno(aluno);
        falta.setData(data);
        falta.setDisciplina(disciplina);
        falta.setFalta(numFalta);
        try {
            fDao.registrarFalta(falta);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            erro = e.getMessage();
        } finally {
            model.addAttribute("erro", erro);
        }
        return new ModelAndView("lancar-faltas");
    }
}
