/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 123
 */
public class Player {
    private final int id;
    private final String name;
    private final String surname;
    private final String bday;
    private final String nationality;
    private final String dataSign;
    private final String dataEnd;
    private final int salary;
    private final int phone;
    private final int price;
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

    public int getPrice() {
        return price;
    }

    public SimpleIntegerProperty getSTid() {
        return new SimpleIntegerProperty(id);
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

    public IntegerProperty getSTPrice() {
        return new SimpleIntegerProperty(price);
    }

    public StringProperty getSTNationality() {
        return new SimpleStringProperty(nationality);
    }



    public Player(int id, String name, String surname,String Nationality, int phone, String bday, String dataSign, String dataEnd, int salary, int price) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bday = bday;
        this.dataSign = dataSign;
        this.dataEnd = dataEnd;
        this.salary = salary;
        this.price = price;
        this.nationality = Nationality;
        this.phone = phone;
    }


    public int getPhone() {
        return phone;
    }
    public IntegerProperty getStPhone() {
        return new SimpleIntegerProperty(phone);
    }

    public Player() {
        this.id = 0;
        this.name = "";
        this.surname = "";
        this.bday = "";
        this.dataSign = "";
        this.dataEnd = "";
        this.salary = 0;
        this.price = 0;
        this.nationality = "";
        this.phone = 0;
    }
}


    
   

