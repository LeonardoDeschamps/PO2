/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.Conexao;
import controle.EstadoDB;
import java.sql.Connection;
import modelo.Estado;

/**
 *
 * @author 5257
 */
public class TesteInsereEstado {
    public static void main(String[] args) {
        Estado estado = new Estado("BA", "Bahia");
        Connection conexao = Conexao.getConexao();
        boolean inseriu = EstadoDB.SetInsereEstado(estado, conexao);
        if(inseriu){
            System.out.println("Estado inserido!");
        }
        else{
            System.out.println("Erro ao inserir estado!");
        }             
        Conexao.setFechaConexao(conexao);
    }
}
