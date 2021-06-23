import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

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
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        }



    }

    private static void exerciseTwo() throws SQLException {
        //02. Get Villains’ Names
        PreparedStatement preparedStatement = connection.prepareStatement("select v.name, count(distinct mv.minion_id) as c from villains v " +
                "join minions_villains mv on v.id = mv.villain_id " +
                "group by v.name " +
                "having c > ? " +
                "order by c desc;");

        preparedStatement.setInt(1, 15);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static void exerciseThree() throws SQLException {
        //03. Get Minion Names
        PreparedStatement preparedStatement = connection.prepareStatement("select v.name, count(distinct mv.minion_id) as c from villains v " +
                "join minions_villains mv on v.id = mv.villain_id " +
                "group by v.name " +
                "having c > ? " +
                "order by c desc;");

        preparedStatement.setInt(1, 15);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString(1), resultSet.getInt(2));
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
