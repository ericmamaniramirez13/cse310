package com.example.mathappmodule2;

import java.util.Random;

public class Question {
    public int first_number;
    public int second_number;
    public int answer;
    public int [] false_answers;
    public int answer_position;
    public int max_limit;
    public String question_Phrase;

    //Create random questions
    public Question(int max_limit){
        this.max_limit = max_limit;
        Random random_number = new Random();
        this.first_number = random_number.nextInt(max_limit);
        this.second_number = random_number.nextInt(max_limit);
        this.answer = this.first_number + this.second_number;
        this.question_Phrase = first_number + "+" + second_number + "=";

        this.answer_position = random_number.nextInt(4);
        this.false_answers = new int[] {0,1,2,3};
        //Options for our buttons
        this.false_answers[0] = answer + 1;
        this.false_answers[1] = answer + 10;
        this.false_answers[2] = answer - 5;
        this.false_answers[3] = answer - 2;

        this.false_answers = shuffleArray(this.false_answers);

        false_answers[answer_position] = answer;
    }

    public int [] shuffleArray(int[] array){
        int index, temp;
        Random random_number = new Random();

        for (int i = array.length -1; i>0;i--){
            index = random_number.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //Generate getter and setter
    public int getFirst_number() {
        return first_number;
    }

    public void setFirst_number(int first_number) {
        this.first_number = first_number;
    }

    public int getSecond_number() {
        return second_number;
    }

    public void setSecond_number(int second_number) {
        this.second_number = second_number;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getFalse_answers() {
        return false_answers;
    }

    public void setFalse_answers(int[] false_answers) {
        this.false_answers = false_answers;
    }

    public int getAnswer_position() {
        return answer_position;
    }

    public void setAnswer_position(int answer_position) {
        this.answer_position = answer_position;
    }

    public int getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }

    public String getQuestion_Phrase() {
        return question_Phrase;
    }

    public void setQuestion_Phrase(String question_Phrase) {
        this.question_Phrase = question_Phrase;
    }
}
