package com.projeto.siga.ProjetoSiga.persistence;

import com.projeto.siga.ProjetoSiga.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DisciplinaDao {

    @Autowired
    GenericDao gDao;

    public List<Disciplina> listarDisciplinas() throws SQLException, ClassNotFoundException {
        Connection c = gDao.getConnection();
        List<Disciplina> lista = new ArrayList<Disciplina>();
        String sql = "SELECT codigo, nome, sigla, turno, num_aulas FROM disciplina";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setCodigo(rs.getString("codigo"));
            disciplina.setNome(rs.getString("nome"));
            disciplina.setSigla(rs.getString("sigla"));
            disciplina.setTurno(rs.getString("turno"));
            disciplina.setNumAulas(rs.getInt("num_aulas"));
            lista.add(disciplina);
        }
        rs.close();
        ps.close();
        c.close();
        return lista;
    }
}
