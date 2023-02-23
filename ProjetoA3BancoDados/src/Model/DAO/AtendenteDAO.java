package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Atendente;
import Model.bean.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AtendenteDAO {
    
   public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM atendente WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();

             if (rs.next()) {
                   
               check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu erro aqui: " +ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    } 
   
   public void delete(Atendente a){
       
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
   
       try{
           stmt = con.prepareStatement("DELETE FROM atendente WHERE id = ?");
           stmt.setInt(1, a.getId());
           
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
  
       } catch (SQLException ex){
           JOptionPane.showMessageDialog(null, "Erro ao excluír" + ex);
       } finally{
           ConnectionFactory.closeConnection(con, stmt);       
       }
   }
   
   public List<Atendente> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Atendente> atendentes = new ArrayList<>();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM atendente");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    Atendente atendente = new Atendente();
                    
                    atendente.setId(rs.getInt("id"));
                    atendente.setNome(rs.getString("login"));
                    atendente.setSenha(rs.getString("senha"));
                    atendentes.add(atendente);
                }
                        
                        } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            
            }
        
            return atendentes;
}
}