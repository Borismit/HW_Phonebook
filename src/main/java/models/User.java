package models;

public class User {
    String name;
    String lastName;
    String phone;
    String emale;
    String password;
    String addres;
    String description;

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User withEmale(String emale) {
        this.emale = emale;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User setAddres(String addres) {
        this.addres = addres;
        return this;
    }

    public User setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmale() {
        return emale;
    }

    public String getPassword() {
        return password;
    }

    public String getAddres() {
        return addres;
    }

    public String getDescription() {
        return description;
    }
}
