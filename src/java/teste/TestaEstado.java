/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.Conexao;
import controle.EstadoDB;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Estado;

/**
 *
 * @author 5257
 */
public class TestaEstado {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ArrayList lista = EstadoDB.getEstados(conexao);
        for(int i = 0; i < lista.size(); i++){
            Estado estado = (Estado) lista.get(i);
            System.out.println("Sigla: " + estado.getEst_sigla());
            System.out.println("Nome: " + estado.getNome());
            System.out.println("***********");
        }
        Conexao.setFechaConexao(conexao);
    }
}
