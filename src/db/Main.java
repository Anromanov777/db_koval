package db;

import java.sql.*;

public class Main {
    static Statement statement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\JAVA\\dbe\\My_cats.db");
        statement = conn.createStatement();
        //int a = statement.executeUpdate("CREATE TABLE if not exists types(id INTEGER PRIMARY KEY AUTOINCREMENT,type VARCHAR(100) NOT NULL)");
        int a = statement.executeUpdate("CREATE TABLE if not exists cats(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20) NOT NULL,type_id INTEGER NOT NULL REFERENCES types(id),age INTEGER NOT NULL,weight DOUBLE)");
        delete_type(7);
        update_type(9,"Чеширский кот");
        //System.out.println(get_type(15));
        get_type_where("type LIKE '%п'");
        get_all_types();
    }

    private static int insert_type(String type) throws SQLException {
        String s = "INSERT INTO types (type) VALUES('" + type + "')";
        int a = statement.executeUpdate(s);
        return a;
    }

    private static void update_type(int id, String new_type) throws SQLException {
        String s = "UPDATE types SET type='" + new_type + "' WHERE id=" + id + ";";
        statement.executeUpdate(s);
    }

    private static void delete_type(int id) throws SQLException {
        String s = "DELETE FROM types WHERE id =" + id + ";";
        statement.executeUpdate(s);
    }

    private  static String get_type(int id) throws SQLException {
        String s ="SELECT type FROM types WHERE id="+id;
        ResultSet a= statement.executeQuery(s);
        return a.getString(1);
    }

    private  static void get_type_where(String where) throws SQLException {
        String s ="SELECT type FROM types WHERE "+where+";";
        ResultSet a= statement.executeQuery(s);
        while (a.next()){
            System.out.println(a.getString("type"));
        }
    }

    private  static void get_all_types() throws SQLException {
        String s ="SELECT type FROM types;";
        ResultSet a= statement.executeQuery(s);
        while (a.next()){
            System.out.println(a.getRow()+" "+a.getString("type"));
        }
    }

    static String[] types = new String[]{"Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку́н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };
}
