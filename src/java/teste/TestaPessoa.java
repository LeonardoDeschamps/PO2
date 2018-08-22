/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.PessoaDB;
import controle.Conexao;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Pessoa;

/**
 *
 * @author 5257
 */
public class TestaPessoa {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ArrayList lista = PessoaDB.getPessoas(conexao);
        for(int i = 0; i < lista.size(); i++){
            Pessoa pessoa = (Pessoa) lista.get(i);
            System.out.println("Código: " + pessoa.getCid_codigo());            
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Cidade: " + pessoa.getCid_codigo());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("E-mail: " + pessoa.getEmail());
            System.out.println("***********");
        }
        Conexao.setFechaConexao(conexao);
    }
}
