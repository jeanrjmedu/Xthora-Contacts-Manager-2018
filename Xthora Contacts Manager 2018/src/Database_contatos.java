
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_contatos {

     String lenderecos[];
     String lcelulares[];
    String ltelefones[];
    String lnomes[];
    //String id[];
    int id[];
    String url;
    String user;
    String password;
    Connection c;
    String SQL;
    PreparedStatement stb;

    Database_contatos() throws Exception {
        
        try {

        url = "jdbc:mysql://localhost";
        user = "root";
        password = "";
        c = DriverManager.getConnection(url, user, password);

        SQL = "CREATE DATABASE IF NOT EXISTS lista_contatosB;";
        stb = c.prepareStatement(SQL);
        stb.execute(SQL);

        SQL = "use lista_contatosB;";
        stb = c.prepareStatement(SQL);
        stb.execute(SQL);

        SQL = "CREATE TABLE IF NOT EXISTS Contatos (id int(255) NOT NULL AUTO_INCREMENT, nome varchar(255) NOT NULL, telefone varchar(255) NOT NULL, celular varchar(255) NOT NULL, endereco varchar(255) NOT NULL, PRIMARY KEY (id));";
        stb = c.prepareStatement(SQL);
        stb.execute(SQL);
        }catch (Exception ex) 
        {
            System.out.println("Não conectou");
        }
        
      
    }

    public void addTabela(String nome, String Telefone, String Celular, String Endereco) throws SQLException {
        //int qtd = rowQtd() + 1;
        //String a = Integer.toString(qtd);

        
        SQL = "INSERT INTO Contatos (nome, telefone, celular, endereco) VALUES ('" + nome + "', '" + Telefone + "', '" + Celular + "','" + Endereco + "');";
        stb = c.prepareStatement(SQL);
        stb.execute(SQL);
    }

    public void remTabela(int index) throws SQLException {
        initDados();
        
        SQL = "DELETE FROM Contatos WHERE id=" + id[index] + ";";
        
        stb = c.prepareStatement(SQL);
        stb.execute(SQL);

    }
    
    public void EditTabela (int index, String nome, String Telefone, String Celular, String Endereco) throws SQLException
    {
        initDados();
        
        SQL = "UPDATE Contatos SET nome = '"+ nome + "', telefone ='" + Telefone + "', celular = '" + Celular + "', endereco ='" + Endereco + "' WHERE id=" + id[index] + ";";
        
        stb = c.prepareStatement(SQL);
        stb.execute(SQL);
    }

    public int rowQtd() throws SQLException {

        Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT * FROM Contatos");
        r.last();

        return r.getRow();

    }

    public void initDados() throws SQLException {
        System.out.println("criou");
        lnomes = new String[rowQtd()];
        ltelefones = new String[rowQtd()];
        lcelulares = new String[rowQtd()];
        lenderecos = new String[rowQtd()];
        id = new int[rowQtd()];

        Statement st = c.createStatement();
        ResultSet lista = st.executeQuery("SELECT id, nome, telefone, celular, endereco FROM Contatos");

        int a = 0;
        while (lista.next()) {

            //id[a] = (String) lista.getString("id");
            id[a] = Integer.parseInt(lista.getString("id"));
            lnomes[a] = (String) lista.getString("nome");
            ltelefones[a] = (String) lista.getObject("telefone");
            lenderecos[a] = (String) lista.getObject("endereco");
            lcelulares[a] = (String) lista.getObject("celular");
            a++;
        }
    }
}
