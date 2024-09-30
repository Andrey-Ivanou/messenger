package by.it_academy.jd2._107.dto;

import java.time.LocalDate;
import java.util.Objects;

public class UserDTO {

    private String login;

    private String password;

    private String fullName;

    private LocalDate dateOfBirth;

    public UserDTO(String login, String password, String fullName, LocalDate dateOfBirth) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(login, userDTO.login) && Objects.equals(password, userDTO.password) && Objects.equals(fullName, userDTO.fullName) && Objects.equals(dateOfBirth, userDTO.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fullName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
