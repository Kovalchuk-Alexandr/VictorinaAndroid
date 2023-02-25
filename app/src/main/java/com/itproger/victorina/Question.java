package com.itproger.victorina;

public class Question {

    private boolean isCorrect;
    private int question;

    public Question(boolean isCorrect, int question) {
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
}
