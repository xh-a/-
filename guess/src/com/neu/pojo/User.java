package com.neu.pojo;

public class User {
    private String name;
    private int score;


    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
