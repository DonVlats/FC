package POJO;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameStat {
    private int id;
    private String name;
    private String surname;
    private int start;
    private int substitutes;
    private int goal;
    private int assist;
    private String opponent;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(int substitutes) {
        this.substitutes = substitutes;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public GameStat() {
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public GameStat(int id, String name, String surname, int start, int substitutes, int goal, int assist, String opponent) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.start = start;
        this.substitutes = substitutes;
        this.goal = goal;
        this.assist = assist;
        this.opponent = opponent;
    }

    public StringProperty getSTname() {
        return new SimpleStringProperty(name);
    }

    public StringProperty getSTsurname() {
        return new SimpleStringProperty(surname);
    }


    public IntegerProperty getSTassist() {
        return new SimpleIntegerProperty(assist);
    }

    public IntegerProperty getSTgoal() {
        return new SimpleIntegerProperty(goal);
    }

    public StringProperty getSTstart() {
        if(start == 1)
            return new SimpleStringProperty("Так");
        return new SimpleStringProperty("НІ");

    }
    public StringProperty getSTsubstitutes() {
        if(substitutes == 1)
            return new SimpleStringProperty("Так");
        return new SimpleStringProperty("НІ");

    }
}
