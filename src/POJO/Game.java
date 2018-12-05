package POJO;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {
    private int id;
    private String opponent;
    private String competition;
    private String data;
    private int score;
    private int scoreOpponent;
    private int home;
    public Game() {
    }

    public Game(int id, String opponent, String competition, String data, int score, int scoreOpponent, int home) {
        this.id = id;
        this.opponent = opponent;
        this.competition = competition;
        this.data = data;
        this.score = score;
        this.scoreOpponent = scoreOpponent;
        this.home = home;
    }

    public int getId() {
        return id;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getCompetition() {
        return competition;
    }

    public String getData() {
        return data;
    }

    public int getScore() {
        return score;
    }

    public int getScoreOpponent() {
        return scoreOpponent;
    }

    public int getHome() {
        return home;
    }


    public StringProperty getSTopponent() {
        return new SimpleStringProperty(opponent);
    }

    public StringProperty getSTcompetition() {
        return new SimpleStringProperty(competition);
    }

    public StringProperty getSTdata() {
        return new SimpleStringProperty(data);
    }

    public IntegerProperty getSTscore() {
        return new SimpleIntegerProperty(score);
    }

    public IntegerProperty getSTscoreOpponent() {
        return new SimpleIntegerProperty(scoreOpponent);
    }

    public StringProperty getSThome() {
        if(home == 1)
        return new SimpleStringProperty("Так");
        return new SimpleStringProperty("НІ");

    }



}
