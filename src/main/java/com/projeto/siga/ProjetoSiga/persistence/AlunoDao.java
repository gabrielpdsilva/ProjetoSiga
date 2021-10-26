package com.projeto.siga.ProjetoSiga.persistence;

import com.projeto.siga.ProjetoSiga.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AlunoDao {

    @Autowired
    GenericDao gDao;

    public Aluno buscarAluno(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection c = gDao.getConnection();
        String sql = "SELECT ra, nome FROM aluno WHERE ra = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, aluno.getRa());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            aluno.setNome(rs.getString("nome"));
        }
        System.out.println(aluno.getNome());
        rs.close();
        ps.close();
        c.close();
        return aluno;
    }
}