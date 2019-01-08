package tictactoe;

import java.sql.*;
 
public class DatabaseManager {
    private final static String DBURL = "jdbc:mysql://mysql.agh.edu.pl/kriskogu";
	private final static String DBUSER = "kriskogu";
	private final static String DBPASS = "xAFojbdZdXQVyuZx";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";

    public static void save(PlayerDescription player) {
        Connection connection = null;
        try {
			Class.forName(DBDRIVER).newInstance();
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO scores VALUES (NULL, '" + player.name + "', " + player.score +");");
            statement.close();
            connection.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
}