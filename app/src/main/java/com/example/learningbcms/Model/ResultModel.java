package com.example.learningbcms.Model;

import com.example.learningbcms.views.ResultFragment;

public class ResultModel {

    private int correct ,wrong, notAnswered;

    public ResultModel(){}

    public int getWrong() {
        return wrong;
    }

    public int getCorrect() {
        return correct;
    }

    public int getNotAnswered() {
        return notAnswered;
    }
}