package fr.univ_amu.iut.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
	// URL de connexion
	static final String CONNECT_URL = "jdbc:postgresql://tyke.db.elephantsql.com/plopplop";
	static final String LOGIN = "";
	static final String PASSWORD = "";

	// Objet Connection
	private Connection connection;
	private static ConnexionUnique instance;

	private ConnexionUnique()
	{
	}
	
	public Connection getConnection() {
		return connection;
	}

	public static ConnexionUnique getInstance() {
		if (instance == null) {
			try {
				instance = new ConnexionUnique();
				instance.connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				if (instance.connection.isClosed()) {
					instance.connection = DriverManager.getConnection(CONNECT_URL, LOGIN, PASSWORD);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
