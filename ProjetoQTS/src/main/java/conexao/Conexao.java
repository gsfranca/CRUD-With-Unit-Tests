
package conexao;

/**
 *
 * @author ana
 */

import javax.swing.JOptionPane;
import java.sql.*; 

public class Conexao {
    final private String driver = "com.mysql.cj.jdbc.Driver"; 
    final private String url = "jdbc:mysql://127.0.0.1/exemplocurso"; 
    final private String usuario = "root"; 
    final private String senha = ""; 
    private Connection conexao; 
    public Statement statement; 
    public ResultSet resultset; 
    
    public boolean conecta() {
        
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            JOptionPane.showMessageDialog(null,"Conexao estabelecida","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null,"Driver nao localizado" +Driver,"Mensgem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;                     
        }catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null,"Fonte de dados nao localizada" + Fonte ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } 
        return result;
    }
    
    public void desconecta() {
       
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null,"Conexao com o banco fechada","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException fecha){
            
        }
    }
    
    public void executaSQL (String sql) {
      
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch (SQLException excecao){
            JOptionPane.showMessageDialog(null,"Erro no comando! \n Erro: " + excecao, "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE );
        }
    }
    
    public boolean Create(Integer id, String nome, String estoque){
          
        try {
            String insert_sql = "insert into produto (id, nome, estoque) values ('" + id + "','" + nome + "','" + estoque + "')";

            statement = conexao.createStatement();
            int rowsAffected = statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "O código de criação (Create) está executando corretamente!", "Relatório de Criação", JOptionPane.INFORMATION_MESSAGE);

            return rowsAffected > 0; // Retorna true se a inserção foi bem-sucedida

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n " + errosql, "Reporte de Criação", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        
    }
    
    public boolean Delete(Integer id){
        
        try{
            statement = conexao.createStatement();
            String insert_sql="delete from produto where id = " + id;
            statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "O código de exclusão (Delete) está executando corretamente!", "Relatório de Exclusão", JOptionPane.INFORMATION_MESSAGE);
            return true;

        }catch (SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na exclusão: \n "+errosql, "Reporte de Exclusão", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }
    
    public boolean Update(Integer id, String nome, String estoque){
        
        try{
            
            statement = conexao.createStatement();
            String update_sql = "update produto set nome='" + nome + "',estoque='" + estoque + "' where id = " + id;
            statement.executeUpdate(update_sql);
            JOptionPane.showMessageDialog(null, "O código de alteração (Update) está executando corretamente!", "Relatório de Alteração", JOptionPane.INFORMATION_MESSAGE);
            return true;
            
        }catch (SQLException errosql){
            
            JOptionPane.showMessageDialog(null, "\n Erro na alteração: \n "+errosql, "Reporte de Alteração", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
    }
    
    public boolean Read(){
        
        try{
            
            statement = conexao.createStatement();
            String insert_sql="select * from produto";
            statement.executeQuery(insert_sql);
            JOptionPane.showMessageDialog(null, "O código de leitura (Read) está executando corretamente!", "Relatório de Leitura", JOptionPane.INFORMATION_MESSAGE);
            
            return true;
            
        }catch (SQLException errosql){
            
            JOptionPane.showMessageDialog(null, "\n Erro na leitura: \n "+errosql, "Reporte de leitura", JOptionPane.INFORMATION_MESSAGE);
            return false;
            
        }
        
    }
    
    }