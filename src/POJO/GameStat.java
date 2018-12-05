package POJO;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameStat {
    private final int id;
    private final String name;
    private final String surname;
    private final int start;
    private final int substitutes;
    private final int goal;
    private final int assist;
    private final String opponent;
    public int getId() {

        return id;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getStart() {
        return start;
    }

    public int getSubstitutes() {
        return substitutes;
    }

    public int getGoal() {
        return goal;
    }

    public int getAssist() {
        return assist;
    }

    public String getOpponent() {
        return opponent;
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
    public StringProperty getSTOpponent() {
        return new SimpleStringProperty(opponent);
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
