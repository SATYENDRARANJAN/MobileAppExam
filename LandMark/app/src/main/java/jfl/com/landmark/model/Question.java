package jfl.com.landmark.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {

    @SerializedName("id")
    public String id;

    public Question(String id, String type, String titleText, String questionText, List<String> answers) {
        this.id = id;
        this.type = type;
        this.titleText = titleText;
        this.questionText = questionText;
        this.answers = answers;
    }

    @SerializedName("type")
    public String type;

    @SerializedName("titleText")
    public String titleText;

    @SerializedName("questionText")
    public String questionText;

    @SerializedName("answerOptions")
    public List<String> answers;


}
