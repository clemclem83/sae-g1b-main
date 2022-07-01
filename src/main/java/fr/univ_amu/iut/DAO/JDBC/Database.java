package fr.univ_amu.iut.DAO.JDBC;


import fr.univ_amu.iut.connexion.ConnexionUnique;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Database {

    private static Database self = null;
    public final Connection db;
    private ScheduledExecutorService scheduledCommit;
    private boolean _autocommit = false;

    private Database() {
        StringBuilder dsn = new StringBuilder();

        db = ConnexionUnique.getInstance().getConnection();

        scheduledCommit = Executors.newSingleThreadScheduledExecutor();
        scheduledCommit.scheduleAtFixedRate(
                () -> {
                    if (!self._autocommit) {
                        try {
                            synchronized (self.db) {
                                self.db.commit();
                            }
                        } catch (SQLException ex) {
                        }
                    }
                },
                60,
                60, TimeUnit.SECONDS
        );

    }

    public static void setAutocommit(boolean state) {
        self._autocommit = state;
        try {
            synchronized (self.db) {
                if (state) {
                    self.db.commit();
                }
                self.db.setAutoCommit(state);
            }
        } catch (SQLException ex) {
            System.exit(1);
        }
    }

    public static ResultSet query(String query) {
        try {
            ResultSet RS;
            synchronized (self.db) {
                RS = self.db.createStatement().executeQuery(query);
            }
            return RS;
        } catch (SQLException e) {
            return null;
        }
    }

    public static PreparedStatement prepare(String query) {
        try {
            return self.db.prepareStatement(query);
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * Prépare une requête d'insertion (retourne l'id généré)
     *
     * @param query
     * @return
     */
    public static PreparedStatement prepareInsert(String query) {
        try {
            return self.db.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            return null;
        }
    }

    public static void connect() {
        if (self == null) {
            self = new Database();
            setAutocommit(false);
        }
    }

    public static void close() {
        try {
            self.scheduledCommit.shutdown();
            self.scheduledCommit = null;
            self.db.close();
        } catch (SQLException ex) {
        }
    }
}