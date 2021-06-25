import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB = "minions_db";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    public static void main(String[] args) throws SQLException, IOException {

        connection = getConnection();

        boolean again = true;

        while (again) {
            again = false;

            System.out.println("Enter Exercise number:");
            int exerciseNumber = Integer.parseInt(reader.readLine());

            switch (exerciseNumber) {
                case 2: exerciseTwo(); //02. Get Villains’ Names
                    break;
                case 3: exerciseThree(); //03. Get Minion Names
                    break;
                case 4: exerciseFour(); //04. Add Minion
                    break;
                case 5: exerciseFive(); //05. Change Town Names Casing
                    break;
                case 6: exerciseSix(); //06. Remove Villain
                    break;
                case 7: exerciseSeven(); //07. Print All Minion Names
                    break;
                case 8: //TODO // exerciseEight(); //08. Increase Minions Age
                    break;
                case 9: exerciseNine(); //09. Increase Age Stored Procedure
                    break;
                default:
                    System.out.println("Incorrect exercise number!");
                    again = true;
            }
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

    public static void exerciseFour() throws IOException {
        //04. Add Minion
        System.out.println("Enter minion info:");
        String[] tokens = reader.readLine().split("\\s+");
        String minionName = tokens[1];
        int minionAge = Integer.parseInt(tokens[2]);
        String minionTown = tokens[3];

        System.out.println("Enter villain info:");
        String villainName = reader.readLine().split("\\s+")[1];


        StringBuilder sb = new StringBuilder();

        try (
                PreparedStatement townStatement = connection.prepareStatement("SELECT t.id FROM towns AS t WHERE t.name = ?");
                PreparedStatement addTownStatement = connection.prepareStatement("INSERT INTO towns (`name`, `country`) VALUES (?, 'Unknown')");
                PreparedStatement villainStatement = connection.prepareStatement("SELECT * FROM villains AS v WHERE v.name = ?");
                PreparedStatement addVillainStatement = connection.prepareStatement("INSERT INTO villains (`name`, `evilness_factor`) VALUES (?, 'evil')");
                PreparedStatement addMinionStatement = connection.prepareStatement("INSERT INTO minions (`name`, `age`, `town_id`) VALUES (?, ?, ?)");
                PreparedStatement getNewMinionIdStatement = connection.prepareStatement("SELECT m.id FROM minions AS m WHERE m.name = ?");
                PreparedStatement addMinionToVillainStatement = connection.prepareStatement("INSERT INTO minions_villains (`minion_id`, `villain_id`) VALUES (?, ?)")) {

            connection.setAutoCommit(false);

            try {
                townStatement.setString(1, minionTown);

                ResultSet towns = townStatement.executeQuery();

                if (!towns.next()) {
                    addTownStatement.setString(1, minionTown);
                    addTownStatement.executeUpdate();

                    sb.append(String.format("Town %s was added to the database.%n", minionTown));
                }

                towns = townStatement.executeQuery();
                towns.next();
                int townID = towns.getInt("id");

                villainStatement.setString(1, villainName);

                ResultSet villain = villainStatement.executeQuery();
                if (!villain.isBeforeFirst()) {
                    addVillainStatement.setString(1, villainName);
                    addVillainStatement.executeUpdate();

                    sb.append(String.format("Villain %s was added to the database.%n", villainName));
                }

                villain = villainStatement.executeQuery();
                villain.next();
                int villainID = villain.getInt("id");

                //add minion
                addMinionStatement.setString(1, minionName);
                addMinionStatement.setInt(2, minionAge);
                addMinionStatement.setInt(3, townID);
                addMinionStatement.executeUpdate();

                //get minion ID
                getNewMinionIdStatement.setString(1, minionName);
                ResultSet minions = getNewMinionIdStatement.executeQuery();
                minions.next();
                int minionID = minions.getInt("id");

                //add record in villains_minions table
                addMinionToVillainStatement.setInt(1, minionID);
                addMinionToVillainStatement.setInt(2, villainID);
                addMinionToVillainStatement.executeUpdate();

                sb.append(String.format("Successfully added %s to be minion of %s", minionName, villainName));

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString().trim());
    }

    private static void exerciseFive() throws SQLException, IOException {
        //05. Change Town Names Casing
        System.out.println("Enter country name:");
        String countryName = reader.readLine();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?");

        preparedStatement.setString(1, countryName);

        int affectedRow = preparedStatement.executeUpdate();

        if (affectedRow == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.printf("%d town names were affected.%n", affectedRow);

        PreparedStatement preparedStatementTowns = connection.prepareStatement("SELECT  name FROM towns WHERE country = ?");
        preparedStatementTowns.setString(1, countryName);
        ResultSet resultSet = preparedStatementTowns.executeQuery();

        //TODO fix output format
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }


    }

    private static void exerciseSix() throws IOException {
        //06. Remove Villain
        System.out.println("Enter id of villain to be removed");
        int villainId = Integer.parseInt(reader.readLine());


    }

    private static void exerciseSeven() throws SQLException {
        //07. Print All Minion Names
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM minions");

        ResultSet resultSet = preparedStatement.executeQuery();

        //TODO try using ArrayDeque
        List<String> minionNames = new ArrayList<>();
        while (resultSet.next()) {
            minionNames.add(resultSet.getString("name"));
        }

        int start = 0;
        int end = minionNames.size() - 1;

        for (int i = 0; i < minionNames.size(); i++) {
            System.out.println(i % 2 == 0
                    ? minionNames.get(start++)
                    : minionNames.get(end--));
        }
    }

    private static void exerciseNine() throws SQLException, IOException {
        //09. Increase Age Stored Procedure
        System.out.println("Enter minion id");
        int minionID = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, minionID);

        int affectedRows = callableStatement.executeUpdate();

        PreparedStatement getUpdatedMinionNameAge = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        getUpdatedMinionNameAge.setInt(1,minionID);
        ResultSet resultSet = getUpdatedMinionNameAge.executeQuery();

        resultSet.next();
        System.out.printf("%s %d", resultSet.getString(1), resultSet.getInt(2));
    }

    private static Set<String> getMinionsByVillainId(int villainId) throws SQLException {
        Set<String> result = new LinkedHashSet<>();
        return null;

    }

    private static String findNameById(String tableName, int id) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = %d", tableName, id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return String.format("No villain with ID %d exists in the database.", id);
        } else {
        //resultSet.next();
            return String.format("Villain: " + resultSet.getString(1));
        }

    }

    private static Connection getConnection() throws IOException, SQLException {
        //TODO set username
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
