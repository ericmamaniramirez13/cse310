package com.example.mathappmodule2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Question> questions;
    public int number_correct;
    public int number_incorrect;
    public int total_questions;
    public int total_score;
    public Question current_question;

    public Game(){
        number_correct = 0;
        number_incorrect = 0;
        total_questions = 0;
        total_score = 0;
        current_question = new Question(10);
        questions = new ArrayList<Question>();
    }
    public void new_question(){
        current_question = new Question(total_questions*2+5);
        total_questions++;
        questions.add(current_question);
    }

    public boolean check_answer(int submitted_answer){
        boolean correct;
        if (current_question.getAnswer() == submitted_answer){
            number_correct++;
            correct = true;
        }
        else{
            number_incorrect++;
            correct = false;
        }
        total_score = number_correct*10-number_incorrect*20;
        return correct;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumber_correct() {
        return number_correct;
    }

    public void setNumber_correct(int number_correct) {
        this.number_correct = number_correct;
    }

    public int getNumber_incorrect() {
        return number_incorrect;
    }

    public void setNumber_incorrect(int number_incorrect) {
        this.number_incorrect = number_incorrect;
    }

    public int getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(int total_questions) {
        this.total_questions = total_questions;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public Question getCurrent_question() {
        return current_question;
    }

    public void setCurrent_question(Question current_question) {
        this.current_question = current_question;
    }
}
