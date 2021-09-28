package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.StringJoiner;

/**
 * https://job4j.ru/profile/exercise/55/task-view/345
 * Изучение работы с JDBC. Подключение JDBC и чтение файла app.properties
 * в качестве настроечного файла. Работа с DDL-
 * создание, обновление, удаление таблиц/ баз данных.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 28.09.2021
 */
public class StatementDemo {
    /**
     * Метод устававливает соединение с базой данныз
     *
     * @return DriverManager, в случае успешного соединения, или null
     * в случае не установки соединения
     * @throws Exception случае ошибки в соединении
     */
    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "1234";
        return DriverManager.getConnection(url, login, password);
    }

    /**
     * Создаем соединение и demo таблицу
     *
     * @param args не используеются в данной задаче
     * @throws Exception кидать случае когда что то пошло не по плану
     */
    public static void main(String[] args) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name text"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            }
        }
    }

    /**
     * Метод выводит в консоль структуру таблицы.
     *
     * @param connection соединение к базе данных
     * @param tableName  имя таблицы
     * @return структура таблицы
     * @throws Exception кидать когда все плохо
     */
    public static String getTableScheme(Connection connection, String tableName)
            throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i),
                        metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }
}
