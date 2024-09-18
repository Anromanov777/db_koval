package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\JAVA\\dbe\\My_cats.db");
        Statement statement = conn.createStatement();
        int a = statement.executeUpdate("CREATE TABLE if not exists types(id INTEGER PRIMARY KEY AUTOINCREMENT,type VARCHAR(100) NOT NULL)");
        System.out.println("Затронуто строк "+a);
    }
}
