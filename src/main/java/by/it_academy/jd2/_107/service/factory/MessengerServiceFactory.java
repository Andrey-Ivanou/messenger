package by.it_academy.jd2._107.service.factory;

import by.it_academy.jd2._107.service.api.IUserRegistrationService;
import by.it_academy.jd2._107.service.UserRegistrationService;
import by.it_academy.jd2._107.storage.ConnectionManager;
import by.it_academy.jd2._107.storage.UserStorage;
import by.it_academy.jd2._107.storage.api.IConnectionManager;
import by.it_academy.jd2._107.storage.api.IUserStorage;

public class MessengerServiceFactory {

    private final static IConnectionManager connectionManager = new ConnectionManager();

    private final static IUserStorage userStorage = new UserStorage(connectionManager);

    private static final IUserRegistrationService instance = new UserRegistrationService(userStorage);

    public static IUserRegistrationService getInstance(){
        return instance;
    }
}
