package jfl.com.landmark.model;

import com.google.gson.annotations.SerializedName;

public class QuestionSDTO {
    @SerializedName("status")
    public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public QuestionData data ;
}
