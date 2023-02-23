package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Cadastro;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CadastroDAO {
    private final Connection connection;
    Long id;
    String login;
    String senha;
    
    public CadastroDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Cadastro cadastro){
        String sql = "INSERT INTO usuario(login,senha) VALUES(?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setString(2, cadastro.getSenha());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu erro aqui: " +ex);
    }
    
  }
}