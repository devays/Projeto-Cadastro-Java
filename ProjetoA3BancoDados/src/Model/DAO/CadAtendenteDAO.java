/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Atendente;
import Model.bean.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Faustão
 */
public class CadAtendenteDAO {
    private final Connection connection;
    Long id;
    String login;
    String senha;
    
    public CadAtendenteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Atendente atendente){
        String sql = "INSERT INTO atendente(login,senha) VALUES(?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente.getNome());
            stmt.setString(2, atendente.getSenha());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu erro aqui: " +ex);
    }
    
  }
}
