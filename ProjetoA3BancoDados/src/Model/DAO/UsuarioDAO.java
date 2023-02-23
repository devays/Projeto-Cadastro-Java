package Model.DAO;

import Connection.ConnectionFactory;
import Model.bean.Usuario;
import Model.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    
        public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
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
        
        public void delete(Usuario u){
            
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setInt(1, u.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " +ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        }
        
        public List<Usuario> read(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<Usuario> usuarios = new ArrayList<>();
            
            try {
                stmt = con.prepareStatement("SELECT * FROM usuario");
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    Usuario usuario = new Usuario();
                    
                    usuario.setId(rs.getInt("id"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuarios.add(usuario);
                }
                        
                        } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                ConnectionFactory.closeConnection(con, stmt, rs);
            
            }
        
            return usuarios;
        }

//    public Iterable<Usuario> read() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
}
