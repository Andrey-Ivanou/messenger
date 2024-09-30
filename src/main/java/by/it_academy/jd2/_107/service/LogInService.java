package by.it_academy.jd2._107.service;

import by.it_academy.jd2._107.dto.UserDTO;
import by.it_academy.jd2._107.service.api.ILogInService;
import by.it_academy.jd2._107.service.api.IUserRegistrationService;
import by.it_academy.jd2._107.storage.api.IUserStorage;
import by.it_academy.jd2._107.storage.entity.EntityUser;

import java.io.IOException;
import java.util.List;

public class LogInService implements ILogInService {

    private final IUserStorage userStorage;

    public LogInService(IUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public void getLogIn(String log, String pas) {
        int count = 0;

        if(log == null || log.isBlank()) {
            throw new IllegalArgumentException("Логин не введен");
        }

        if (pas == null || pas.isBlank()) {
            throw new IllegalArgumentException("Пароль не введен");
        }

        List<EntityUser> entityUserList = userStorage.getEntityUser();
        while (entityUserList.size() > count){
            for(EntityUser entityUser : entityUserList){
                if(log.equals(entityUser.getLogin()) || log.isBlank()){
                    count = 0;
                    while (entityUserList.size() > count) {
                        for (EntityUser entityUser1 : entityUserList) {
                            if (pas.equals(entityUser1.getPassword()) || log.isBlank()) {
                                return;
                            }
                            count++;
                        }
                    }
                    return;
                }
                count++;
            }
           /* System.out.println("Вы вошли в messenger");*/
            /*throw new IllegalArgumentException("Неверный логин");*/
        }
        try {
            System.out.println("Вы вошли в messenger");
        } catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }

        /*if(log.equals(entityUser.getLogin()) || log.isBlank()) {
            throw new IllegalArgumentException("Неверный логин");
        } else if (!pas.equals(entityUser.getPassword()) || pas.isBlank()) {
            throw new IllegalArgumentException("Неверный пароль");
        } else {
            System.out.println("Вы вошли в messenger");
        }*/
    }
}
