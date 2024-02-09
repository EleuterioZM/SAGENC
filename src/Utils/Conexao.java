package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eleuterio_Mabecuane
 */
public class Conexao {
  public static Connection getConexao(){
      try {
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagenc","root","");
          System.out.println("Conectado com sucesso!");
          return connection;
      } catch (SQLException ex) {
          Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("Erro na conexao com o baco de dados!");
      }
      
      
      return null;
      
  }
    
}
