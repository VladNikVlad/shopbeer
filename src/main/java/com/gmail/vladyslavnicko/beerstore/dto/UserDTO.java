package com.gmail.vladyslavnicko.beerstore.dto;

public class UserDTO {
    private long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String matchingPassword;
    private String email;
    private int numberPhone;

    public UserDTO() {
    }

    public UserDTO(String name, String password, String matchingPassword, String email) {
        this.name = name;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public UserDTO(long id, String name, String surname, String login,
                   String password, String matchingPassword, String email, int numberPhone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone=" + numberPhone +
                '}';
    }
}
