package CadAlunos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Conexao;


public class ConexaoBDMariaDB {
	private static Conexao Conexao;// = new Conexao("127.0.0.1", "cadalunos", "root", "123456",3306);
    public static  Connection connection = null;
     static String url = "jdbc:mysql://127.0.0.1:3306/cadalunos";
	 static String user = "root";
	 static String pwd = "12345";
    
    public ConexaoBDMariaDB(Conexao Conexao){
        ConexaoBDMariaDB.Conexao = Conexao;
    }
    
    public static  boolean Conectar() throws SQLException{
        if(Conexao != null){
    		try {
    			/*
				ConexaoBDMariaDB.connection = DriverManager.getConnection(url, user, pwd);
				*/
    			String url1 = "jdbc:mysql://" + Conexao.getHost() + ":" + Conexao.getPorta() + "/" + Conexao.getDataBase(); //ajeitei utilizando a classe
    			Class.forName("com.mysql.jdbc.Driver"); //faltou esta
    			ConexaoBDMariaDB.connection = DriverManager.getConnection(url1, Conexao.getUsuario(), Conexao.getSenha());    			
    			
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                return false;
			}	
        }else {
            return false;
        }
    }
    
    public static boolean Insert(Aluno alunos){
        PreparedStatement stmt = null;
        try{
            //inserindo o comando SQL:
            stmt = connection.prepareStatement("INSERT INTO alunos(nome, email, idade, matricula) VALUES(?, ?, ?, ?)");
          
            stmt.setString(1, alunos.getNome());
            stmt.setString(2, alunos.getEmail());
            stmt.setInt(3, alunos.getIdade());
            stmt.setString(4, alunos.getMatricula());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + ex.getMessage(), "Erro ao gravar dados no banco de dados.", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public List<Aluno> Buscar(Aluno alunos) {
           
        PreparedStatement stmt = null;
        try {
            List<Aluno> list = new ArrayList<>();
            
            if(ConexaoBDMariaDB.Conectar()) {
             
                 stmt = connection.prepareStatement("SELECT * FROM alunos");

                 ResultSet rs = stmt.executeQuery();

                 while(rs.next()) {
                      alunos = new Aluno();
                      alunos.setNome(rs.getString("nome"));
                      alunos.setEmail(rs.getString("email"));
                      alunos.setIdade(rs.getInt("idade"));
                      alunos.setMatricula(rs.getString("matricula"));
                      list.add(alunos);

                     
                 }

                 rs.close();
                 stmt.close();
                 

                 return list;
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
        return null;
      
    }


}
