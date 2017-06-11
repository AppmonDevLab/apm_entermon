import java.sql.*;
import org.sqlite.JDBC;


public class DBhelper 
{
    public static DBhelper getInstance() {
        if (instance == null) instance = new DBhelper();
        return instance;
    }
    
    private static DBhelper instance;
    
    private String name = "jdbc:sqlite:entermon.db";
    
    private static Connection conn;
    
    private void getConn() {
        if (conn == null) {
            try
            {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(name);
                //Connection conn = DriverManager.getConnection("jdbc:sqlite:path(路径)/name.db");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private DBhelper() {
        try {
            getConn();
            Statement stat = conn.createStatement();
            stat.executeUpdate( "create table if not exists user(username varchar(64) NOT MULL, password varchar(64) NOT NULL, coin INT NOT NULL);" );
            stat.executeUpdate( "insert into user values('tester','123qwe',100);" ); 
            stat.executeUpdate( "insert into user values('tester2','123qwe',1);" ); 

            ResultSet rs = stat.executeQuery("select * from table1;"); 

            while (rs.next()) {

            System.out.print("name = " + rs.getString("name") + " "); //列属性一
            System.out.println("age = " + rs.getString("age")); //列属性二
            }
            rs.close();
            conn.close();
        } catch( Exception e ) {
         e.printStackTrace();
        }
    }
    
    public void insertUser(String username，String password) {
        try {
             getConn();
             PreparedStatement prep = conn.prepareStatement("insert into user values (?,?,?);");
             prep.setString(1, username);
             prep.setString(2, password);
             prep.setString(3, "0");
             prep.addBatch();
             conn.setAutoCommit(false);
             prep.executeBatch();
             conn.setAutoCommit(true);
             conn.close();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public int queryUser(String username，String password) {
        try {
            String name, pw;
            int coin;
            getConn();
            PreparedStatement prep = conn.prepareStatement("select * from user where username=?;");
            prep.setString(1, username);
            ResultSet rs = prep.executeQuery();
            while(rs.next()) {
                name = rs.getString("username");
                pw = rs.getString("password");
                coin = rs.getInt("coin");
            }
            conn.close();
            if (name.equals(username)&&pw.equals(password)) return coin;
            else return -1;
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    
}