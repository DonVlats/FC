package POJO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private String Login;
    private String Grand;

    public User(String login, String grand) {
        Login = login;
        Grand = grand;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setGrand(String grand) {
        Grand = grand;
    }

    public String getLogin() {
        return Login;
    }

    public String getGrand() {
        return Grand;
    }
    public StringProperty getSTLogin() {
        return new SimpleStringProperty(Login);
    }

    public StringProperty getSTGrand() {
        return new SimpleStringProperty(Grand);
    }

    public User() {
        Login = "";
        Grand = "";
    }
}
