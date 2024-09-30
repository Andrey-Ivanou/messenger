package by.it_academy.jd2._107.service;

/*import by.it_academy.jd2._107.dataBaseTemp.api.MessengerDB;*/
import by.it_academy.jd2._107.dto.UserDTO;
import by.it_academy.jd2._107.exceptions.DuplicateEntityException;
import by.it_academy.jd2._107.service.api.IUserRegistrationService;
import by.it_academy.jd2._107.storage.api.IUserStorage;
import by.it_academy.jd2._107.storage.entity.EntityUser;

import java.time.LocalDateTime;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

public class UserRegistrationService implements IUserRegistrationService {

    private final static String ROLE_USER = "USER";

    /*private static final MessengerService instance = new MessengerService(getInstance().userStorage);*/

    /*private static final IMessengerDB messengerDB = MessengerDB.getInstance();*/

    private final IUserStorage userStorage;

    /*public MessengerService() {
    }*/

    public UserRegistrationService(IUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public void create(UserDTO userDTO) throws DuplicateFormatFlagsException {

        if (userDTO.getFullName() == null || userDTO.getFullName().isBlank()) {
            throw new IllegalArgumentException("Вы не ввели полное имя");
        }

        if (userDTO.getLogin() == null || userDTO.getLogin().isBlank()) {
            throw new IllegalArgumentException("Вы не ввели логин");
        }

        if (userDTO.getPassword() == null || userDTO.getPassword().isBlank()) {
            throw new IllegalArgumentException("Вы не ввели пароль");
        }

        if (userDTO.getDateOfBirth() == null) {
            throw new IllegalArgumentException("Вы не ввели дату рождения");
        }

        List<EntityUser> entityUsers = userStorage.getEntityUser();
        int count = 0;
        while (entityUsers.size() > count) {
            for (EntityUser user : entityUsers) {
                if (userDTO.getLogin().equals(user.getLogin())) {
                    try {
                        throw new DuplicateEntityException("Такой Login уже существует!");
                    } catch (DuplicateEntityException e) {
                        throw new IllegalArgumentException("Такой Login уже существует!",e);
                    }
                }
                count++;
            }
        /*for (EntityUser user : entityUsers)
            if (!userDTO.getLogin().equals(user.getLogin())) {

                EntityUser entityUser = new EntityUser();
                entityUser.setLogin(userDTO.getLogin());
                entityUser.setPassword(userDTO.getPassword());
                entityUser.setFullName(userDTO.getFullName());
                entityUser.setDateOfBirth(userDTO.getDateOfBirth());
                entityUser.setCreateAt(LocalDateTime.now());
                entityUser.setUserOrAdmin(ROLE_USER);
                userStorage.create(entityUser);
            } else {
                try {
                    throw new DuplicateEntityException("Warning: Такой Login уже существует!");
                } catch (DuplicateEntityException e) {
                    throw new RuntimeException(e);
                }
            }*/
        /*if (userDTO.getFullName() == null && userDTO.getLogin() == null && userDTO.getPassword() == null
                && userDTO.getDateOfBirth() == null) {
            throw new IllegalArgumentException("<fieldset><p><span style= 'color: red;'>Вы не прошли регистрацию</span></p></fieldset>");
        }*/ /*else {*/
            EntityUser entityUser = new EntityUser();
            entityUser.setLogin(userDTO.getLogin());
            entityUser.setPassword(userDTO.getPassword());
            entityUser.setFullName(userDTO.getFullName());
            entityUser.setDateOfBirth(userDTO.getDateOfBirth());
            entityUser.setCreateAt(LocalDateTime.now());
            entityUser.setUserOrAdmin(ROLE_USER);
            userStorage.create(entityUser);
       /* }*/
        }
    }





    /*LogInToTheApp logInToTheApp = new LogInToTheApp();
    Map<String, String> logPass = logInToTheApp.getLogPass();

    String login = logPass.keySet().iterator().next();*/


    /*List<SaveUserDTO> user = MessengerDB.getInstance().getListUser();*/
    /*SaveUserDTO saveUserDTO = user.forEach(userDTO -> userDTO.getLogin().equalsIgnoreCase(login));*/



    /*public static Object getUser(List<SaveUserDTO> user, String login) {
        for (SaveUserDTO s : user){
            if(s.getLogin().equalsIgnoreCase(login)){
                return s;
            }
        }
        return null;
    }*/

   /* public static MessengerService getInstance() {
        return instance;
    }*/
}
