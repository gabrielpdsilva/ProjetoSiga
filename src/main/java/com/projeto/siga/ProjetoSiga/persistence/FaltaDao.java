package com.projeto.siga.ProjetoSiga.persistence;

import com.projeto.siga.ProjetoSiga.model.Aluno;
import com.projeto.siga.ProjetoSiga.model.Disciplina;
import com.projeto.siga.ProjetoSiga.model.Falta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class FaltaDao {
    @Autowired
    GenericDao gDao;

    public void registrarFalta(Falta falta) throws SQLException, ClassNotFoundException {
        Connection c = gDao.getConnection();

        java.sql.Date dataFormatadaSql = new java.sql.Date(falta.getData().getTime());

        String sql = "INSERT INTO faltas(ra_aluno, codigo_disciplina, data, falta) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, falta.getAluno().getRa());
        ps.setString(2, falta.getDisciplina().getCodigo());
        ps.setDate(3, dataFormatadaSql);
        ps.setInt(4, falta.getFalta());
        ps.execute();
        ps.close();
        c.close();
        System.out.println("Inseriu com sucesso meu bruxo");
    }
}
