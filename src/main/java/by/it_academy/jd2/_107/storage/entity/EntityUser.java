package by.it_academy.jd2._107.storage.entity;

import by.it_academy.jd2._107.dto.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class EntityUser {

    private String login;

    private String password;

    private String fullName;

    private LocalDate dateOfBirth;

    private LocalDateTime createAt;

    private Role role;

    public EntityUser() {
    }

    public EntityUser(String login, String password, String fullName, LocalDate dateOfBirth, LocalDateTime createAt, String role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.createAt = createAt;
        this.role = Role.valueOf(role);
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = Role.valueOf(String.valueOf(role));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityUser that = (EntityUser) o;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(createAt, that.createAt) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fullName, dateOfBirth, createAt, role);
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", createAt=" + createAt +
                ", role=" + role +
                '}';
    }
}
