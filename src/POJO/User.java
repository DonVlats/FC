package POJO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final String Login;
    private final String Grand;

    public User(String login, String grand) {
        Login = login;
        Grand = grand;
    }

    public String getLogin() {
        return Login;
    }

    public StringProperty getSTLogin() {
        return new SimpleStringProperty(Login);
    }

    public StringProperty getSTGrand() {
        return new SimpleStringProperty(Grand);
    }

}
