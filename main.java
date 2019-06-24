

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ana_r
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    //Os valores de alguns alimentos já foram inseridos diretamente no banco.

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/alimentos?useSSL=false&useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "computa";
        
        //Buscar os dados dos alimentos do banco
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, usuario, senha);
        Statement stmt = con.createStatement();
        ResultSet rs;
        
        Alimento a;
        //Criacao da tabela de Alimentos
        TabelaAlimentos ta = new TabelaAlimentos();
        
        //Busca dos alimentos referentes à refeicao almoco no banco de dados
        //       ----------- Carboidratos ------------
        rs = stmt.executeQuery("SELECT * FROM carboidratos");
        
            while (rs.next()) {
               a = new Alimento(rs.getString(2), rs.getInt(3), "carboidratos");
               ta.addAlimento(a);
            }
        //       ----------- Proteínas ------------
        rs = stmt.executeQuery("SELECT * FROM proteinas");
        
            while (rs.next()) {
               a = new Alimento(rs.getString(2), rs.getInt(3), "proteinas");
               ta.addAlimento(a);
            }
        //       ----------- Frutas ------------
        rs = stmt.executeQuery("SELECT * FROM frutas");
        
            while (rs.next()) {
               a = new Alimento(rs.getString(2), rs.getInt(3), "frutas");
               ta.addAlimento(a);
            }
        //       ----------- Ferro ------------
        rs = stmt.executeQuery("SELECT * FROM ferro");
        
            while (rs.next()) {
               a = new Alimento(rs.getString(2), rs.getInt(3), "ferro");
               ta.addAlimento(a);
            }
        //       ----------- Saladas ------------
        rs = stmt.executeQuery("SELECT * FROM saladas");
        
            while (rs.next()) {
               a = new Alimento(rs.getString(2), rs.getInt(3), "saladas");
               ta.addAlimento(a);
            }
        //       ----------- Legumes ------------
        rs = stmt.executeQuery("SELECT * FROM legumes");
        
            while (rs.next()) {
               a = new Alimento(rs.getString(2), rs.getInt(3), "legumes");
               ta.addAlimento(a);
            }
        
        //Configuração dos dados pessoais e médicos do paciente
        Esporte e = new Esporte("natacao", 350);
        Paciente p = new Paciente(111111, "maria");

        p.setDadosMedicos(57, 1.5, null, 0);

        Dieta dieta = new Dieta(p, ta);
        Refeicao r;
        r = dieta.SimulatedAnnealing();
        rs = stmt.executeQuery("SELECT * FROM refeicao WHERE codigo_refeicao = " + dieta.getCodigo());
        
        while(rs.next()){
            r = dieta.SimulatedAnnealing();
            rs = stmt.executeQuery("SELECT * FROM refeicao WHERE codigo_refeicao = " + dieta.getCodigo());
        }
        
        System.out.println("----------"+ r.getRefeicao()+ "--------");
        for (int i = 0; i < r.getR().size(); i++) {
            System.out.println(r.getR().get(i).getTipo() + ": " + r.getR().get(i).getNome());
        }
        
        
        int dia = 7;
        System.out.println("Calorias ingeridas: " + r.caloriasTotais());
        String val = "" + p.getCpf() + ",'" + r.getRefeicao() + "'," + dia + ",'" + r.getR().get(0).getNome() + "','" + r.getR().get(1).getNome() + "','" + r.getR().get(2).getNome() + "','" + r.getR().get(3).getNome() + "','" + r.getR().get(4).getNome() + "','" + r.getR().get(5).getNome() + "'," + r.caloriasTotais() + "," + dieta.getCodigo() + "";
        stmt.executeUpdate("INSERT INTO refeicao VALUES(" + val + ")");
        
        rs.close();
        stmt.close();
        con.close();
        
        

    }
}
