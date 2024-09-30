package by.it_academy.jd2._107.service.api;

import by.it_academy.jd2._107.dto.UserDTO;
import by.it_academy.jd2._107.storage.entity.EntityUser;

import java.util.List;

public interface IUserRegistrationService {

    void create(UserDTO userDTO);
}
