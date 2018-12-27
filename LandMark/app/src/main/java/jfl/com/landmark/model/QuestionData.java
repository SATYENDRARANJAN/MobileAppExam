package jfl.com.landmark.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionData {


    @SerializedName("questions")
    public List<Question> questions;
}
