/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Estado;

/**
 *
 * @author 1005440
 */
public class EstadoDB {

    public static ArrayList getEstados(Connection conexao) {
        ArrayList lista = new ArrayList();

        try {
            ResultSet rs = conexao.createStatement().executeQuery("SELECT * FROM estado");

            while(rs.next()) {
                lista.add(new Estado(rs.getString("est_sigla"), rs.getString("nome")));
            }
        }
        catch(SQLException erro) {
            System.out.println("Erro de SQL: " + erro.getMessage());
        }

        return lista;
    }

}
