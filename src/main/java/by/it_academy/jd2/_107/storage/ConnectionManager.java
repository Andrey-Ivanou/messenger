package by.it_academy.jd2._107.storage;

import by.it_academy.jd2._107.storage.api.IConnectionManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager implements IConnectionManager {

    public static DataSource dataSource;

    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();

        try {
            cpds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Нет коннекта с базай данных " + e);
        }

        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/messenger");
        cpds.setUser("postgres");
        cpds.setPassword("508an375");

        dataSource = cpds;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
