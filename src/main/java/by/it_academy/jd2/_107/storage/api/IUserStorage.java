package by.it_academy.jd2._107.storage.api;

import by.it_academy.jd2._107.storage.entity.EntityUser;

import java.util.List;

public interface IUserStorage {

    void create(EntityUser user);

    List<EntityUser> getEntityUser();
}
