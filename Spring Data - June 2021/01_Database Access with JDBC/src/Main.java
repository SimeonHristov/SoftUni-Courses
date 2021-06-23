import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class Main {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB = "minions_db";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    public static void main(String[] args) throws SQLException, IOException {

        connection = getConnection();

        System.out.println("Enter Exercise number:");
        int exerciseNumber = Integer.parseInt(reader.readLine());

        switch (exerciseNumber) {
            case 2: exerciseTwo(); //02. Get Villains’ Names
            case 3: exerciseThree(); //03. Get Minion Names
            case 4: // exerciseFour(); //04. Add Minion
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        }



    }

    private static void exerciseTwo() throws SQLException {
        //02. Get Villains’ Names
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS c FROM villains v " +
                "JOIN minions_villains mv ON v.id = mv.villain_id " +
                "GROUP BY v.name " +
                "HAVING c > ? " +
                "ORDER BY c desc;");

        preparedStatement.setInt(1, 15);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static void exerciseThree() throws SQLException, IOException {
        //03. Get Minion Names
        System.out.println("Enter villain_ID:");
        int villainId = Integer.parseInt(reader.readLine());

        String name = findNameById("villains", villainId);

        System.out.println(name);

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT m.name, m.age FROM minions m " +
                        "JOIN minions_villains mv on m.id = mv.minion_id " +
                        "WHERE  mv.villain_id = ?;");

        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();
        int counter = 0;


        while (resultSet.next()) {
            System.out.printf("%d. %s %d %n", ++counter, resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static Set<String> getMinionsByVillainId(int villainId) throws SQLException {
        Set <String> result = new LinkedHashSet<>();
        return  null;

    }

    private static String findNameById(String tableName, int id) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = %d", tableName, id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next() ) {
            return String.format("No villain with ID %d exists in the database.", id);
        } else {
            resultSet.next();
            return String.format("Villain: " + resultSet.getString(1));
        }

    }

    private static Connection getConnection() throws IOException, SQLException {
        //TODO set(hardcode) username
        System.out.println("Enter username:");
        //String user = reader.readLine();

        String user = reader.readLine().equals("") ? "root" : reader.readLine();
        //TODO set password
        System.out.println("Enter password:");
        String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        //Connection connection = DriverManager.getConnection(CONNECTION_STRING + DB, properties);
        return DriverManager.getConnection(CONNECTION_STRING + DB, properties);
    }
}
