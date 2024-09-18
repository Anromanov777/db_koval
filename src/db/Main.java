package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static Statement statement;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\JAVA\\dbe\\My_cats.db");
        statement = conn.createStatement();
        int a = statement.executeUpdate("CREATE TABLE if not exists types(id INTEGER PRIMARY KEY AUTOINCREMENT,type VARCHAR(100) NOT NULL)");
        System.out.println("Затронуто строк "+ insert_type("Абиссинская кошка"));
        System.out.println("Затронуто строк "+ insert_type("Австралийский мист"));
        System.out.println("Затронуто строк "+ insert_type("Американская жесткошерстная"));

    }

    private static int insert_type(String type) throws SQLException {
        String s = "INSERT INTO types (type) VALUES('" + type + "')";
      int a =  statement.executeUpdate(s);
        return a;
    }
}
