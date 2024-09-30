package by.it_academy.jd2._107.storage.factory;

import by.it_academy.jd2._107.storage.ConnectionManager;
import by.it_academy.jd2._107.storage.UserStorage;
import by.it_academy.jd2._107.storage.api.IConnectionManager;
import by.it_academy.jd2._107.storage.api.IUserStorage;

public class StorageFactory {

    private final static IConnectionManager connectionManager = new ConnectionManager();

    private final static IUserStorage userStorage = new UserStorage(connectionManager);

    public IUserStorage getUserStorage(){
        return userStorage;
    }
}
