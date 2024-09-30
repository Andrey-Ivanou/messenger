package by.it_academy.jd2._107.storage;

import by.it_academy.jd2._107.storage.api.IConnectionManager;
import by.it_academy.jd2._107.storage.api.IUserStorage;
import by.it_academy.jd2._107.storage.entity.EntityUser;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserStorage implements IUserStorage {

    private final static String INSERT_QUERY = "INSERT INTO app.entity_user(\n" +
            "\tid, password, full_name, date_of_birht, create_at, role)\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?);";

    private final static String SELECT_QUERY = "SELECT id, password, full_name, date_of_birht, create_at, role\n" +
            "\tFROM app.entity_user;";

    private final IConnectionManager connectionManager;

    public UserStorage(IConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(EntityUser user) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);) {

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setObject(4, user.getDateOfBirth());
            statement.setObject(5, user.getCreateAt());
            statement.setObject(6, user.getUserOrAdmin());
            statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Запись в базу данных не произошла ",e);
        }

    }

    @Override
    public List<EntityUser> getEntityUser() {
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_QUERY);){

            List<EntityUser> entityUserList = new ArrayList<>();
            while (resultSet.next()){
                entityUserList.add(new EntityUser(
                        resultSet.getString("id"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("date_of_birht").toLocalDate(),
                        resultSet.getTimestamp("create_at").toLocalDateTime(),
                        resultSet.getString("role")));
            }
            return entityUserList;
        } catch (SQLException e) {
            throw new RuntimeException("Чтение из базы данных не произошло ",e);
        }
    }
}
