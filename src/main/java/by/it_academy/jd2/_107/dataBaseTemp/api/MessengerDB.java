/*package by.it_academy.jd2._107.dataBaseTemp.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessengerDB implements IMessengerDB{

    private static final MessengerDB instance = new MessengerDB();

    private List<SaveUserDTO> listUser;

    private Map<String, String> loginPass = new HashMap<>();

    private Map<String, String> fullNameBirth = new HashMap<>();

    private MessengerDB() {

    }

    public static MessengerDB getInstance() {
        return instance;
    }

    @Override
    public void create(SaveUserDTO userDTO) {
        listUser = new ArrayList<>();
        listUser.add(userDTO);
    }

    public List<SaveUserDTO> getListUser() {
        return listUser;
    }

    public Map<String, String> getLoginPass() {
        return loginPass;
    }

    public Map<String, String> getFullNameBirth() {
        return fullNameBirth;
    }
}*/
