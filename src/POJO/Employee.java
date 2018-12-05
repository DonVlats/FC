package POJO;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
    private final int id;
    private final String name;
    private final String surname;
    private final String bday;
    private final String nationality;
    private final String dataSign;
    private final String dataEnd;
    private final int salary;
    private final int phone;
    private final String post;
    public Employee() {
        this.id = 0;
        this.name = "";
        this.surname = "";
        this.bday = "";
        this.dataSign = "";
        this.dataEnd = "";
        this.salary = 0;
        this.post = "0";
        this.nationality = "";
        this.phone = 0;
    }

    public Employee(int id, String name, String surname, String bday, String nationality, String dataSign, String dataEnd, int salary, int phone, String post) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bday = bday;
        this.nationality = nationality;
        this.dataSign = dataSign;
        this.dataEnd = dataEnd;
        this.salary = salary;
        this.phone = phone;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBday() {
        return bday;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDataSign() {
        return dataSign;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public int getSalary() {
        return salary;
    }

    public int getPhone() {
        return phone;
    }

    public String getPost() {
        return post;
    }

    public StringProperty getSTName() {
        return new SimpleStringProperty(name);
    }

    public StringProperty getSTSurname() {
        return new SimpleStringProperty(surname);
    }

    public StringProperty getSTBday() {
        return new SimpleStringProperty(bday);
    }

    public StringProperty getSTDataSign() {
        return new SimpleStringProperty(dataSign);
    }

    public StringProperty getSTDataEnd() {
        return new SimpleStringProperty(dataEnd);
    }

    public IntegerProperty getSTSalary() {
        return new SimpleIntegerProperty(salary);
    }

    public StringProperty getSTPost() {
        return new SimpleStringProperty(post);
    }

    public StringProperty getSTNationality() {
        return new SimpleStringProperty(nationality);
    }
}
