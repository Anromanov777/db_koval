package db;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Statement statement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\JAVA\\dbe\\My_cats.db");
        statement = conn.createStatement();
        int a = statement.executeUpdate("CREATE TABLE if not exists cats(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20) NOT NULL,type_id INTEGER NOT NULL REFERENCES types(id),age INTEGER NOT NULL,weight DOUBLE)");
        delete_type(7);
        update_type(9, "Чеширский кот");

        for (int i = 0; i < 5000; i++) {
            Random random = new Random();
            String name = names[random.nextInt(names.length)];
            String type_id = types[random.nextInt(types.length)];
            int age = random.nextInt(23);
            double weight = Math.round(random.nextDouble(20)*100)/100.0 ;
            insert_cat(name, type_id, age, weight);
        }
    }

    private static void insert_cat(String name, String type, int age, Double weight) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM types WHERE type = '" + type + "'");
        if (resultSet.next()) {
            String s = "INSERT INTO cats (name,type_id,age,weight) VALUES ('" + name + "'," + resultSet.getInt(1) + "," + age + "," + weight + ")";
            statement.executeUpdate(s);
        } else {
            String s = "INSERT INTO types(type) VALUES ('" + type + "')";
            statement.executeUpdate(s);
            s = "SELECT id FROM types WHERE type = '" + type + "';";
            ResultSet resultSet1 = statement.executeQuery(s);
            s = "INSERT INTO cats (name,type_id,age,weight) VALUES ('" + name + "'," + resultSet1.getInt(1) + "," + age + "," + weight + ")";
            statement.executeUpdate(s);
        }
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

    private static String get_type(int id) throws SQLException {
        String s = "SELECT type FROM types WHERE id=" + id;
        ResultSet a = statement.executeQuery(s);
        return a.getString(1);
    }

    private static void get_type_where(String where) throws SQLException {
        String s = "SELECT type FROM types WHERE " + where + ";";
        ResultSet a = statement.executeQuery(s);
        while (a.next()) {
            System.out.println(a.getString("type"));
        }
    }

    private static void get_all_types() throws SQLException {
        String s = "SELECT type FROM types;";
        ResultSet a = statement.executeQuery(s);
        while (a.next()) {
            System.out.println(a.getRow() + " " + a.getString("type"));
        }
    }

    static String[] names = {"Гарфилд",
            "Том",
            "Гудвин",
            "Рокки",
            "Ленивец",
            "Пушок",
            "Спорти",
            "Бегемот",
            "Пират",
            "Гудини",
            "Зорро",
            "Саймон",
            "Альбус",
            "Базилио",
            "Леопольд",
            "Нарцисс",
            "Атос",
            "Каспер",
            "Валлито",
            "Оксфорд",
            "Бисквит",
            "Соня",
            "Клеопатра",
            "Цунами",
            "Забияка",
            "Матильда",
            "Кнопка",
            "Масяня",
            "Царапка",
            "Серсея",
            "Ворсинка",
            "Амели",
            "Наоми",
            "Маркиза",
            "Изольда",
            "Вальс",
            "Несквик",
            "Златан",
            "Баскет",
            "Изюм",
            "Цукат",
            "Мокко",
            "Месси",
            "Кокос",
            "Адидас",
            "Бейлиз",
            "Тайгер",
            "Зефир",
            "Мохи",
            "Валенсия",
            "Баунти",
            "Свити",
            "Текила",
            "Ириска",
            "Карамель",
            "Виски",
            "Кукуруза",
            "Гренка",
            "Фасолька",
            "Льдинка",
            "Китана",
            "Офелия",
            "Дайкири",
            "Брусника",
            "Аватар",
            "Космос",
            "Призрак",
            "Изумруд",
            "Плинтус",
            "Яндекс",
            "Крисмас",
            "Метеор",
            "Оптимус",
            "Смайлик",
            "Цельсий",
            "Краска",
            "Дейзи",
            "Пенка",
            "Веста",
            "Астра",
            "Эйприл",
            "Среда",
            "Бусинка",
            "Гайка",
            "Елка",
            "Золушка",
            "Мята",
            "Радость",
            "Сиам",
            "Оскар",
            "Феликс",
            "Гарри",
            "Байрон",
            "Чарли",
            "Симба",
            "Тао",
            "Абу",
            "Ватсон",
            "Енисей",
            "Измир",
            "Кайзер",
            "Васаби",
            "Байкал",
            "Багира",
            "Айрис",
            "Диана",
            "Мими",
            "Сакура",
            "Индия",
            "Тиффани",
            "Скарлетт",
            "Пикси",
            "Лиззи",
            "Алиса",
            "Лило",
            "Ямайка",
            "Пэрис",
            "Мальта",
            "Аляска"
    };

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
