package jfl.com.landmark.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jfl.com.landmark.R;
import jfl.com.landmark.model.Question;

import static jfl.com.landmark.Constants.Constants.ITEM_FIRST;
import static jfl.com.landmark.Constants.Constants.ITEM_QUES;
import static jfl.com.landmark.Constants.Constants.ITEM_TITLE;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context mContext;
    List<Question> questions;
    public RecyclerViewAdapter(Context context) {
        mContext =context;
        questions = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ITEM_TITLE:
                viewHolder = getTitleViewHolder(parent, inflater);
                break;

            case ITEM_QUES:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case ITEM_FIRST:
                viewHolder = getFirstViewHolder(parent, inflater);

                break;
        }
        return viewHolder;
    }

    private RecyclerView.ViewHolder getFirstViewHolder(ViewGroup parent, LayoutInflater inflater) {
        FirstViewHolder fvh  = null;
        View view = inflater.inflate(R.layout.firstrow , parent,false);
        fvh= new FirstViewHolder(view);
        return fvh;
    }

    private TitleViewHolder getTitleViewHolder(ViewGroup parent, LayoutInflater inflater) {
        TitleViewHolder viewHolder = null ;
        View view  = inflater.inflate(R.layout.title_row,parent,false);
        viewHolder = new TitleViewHolder(view);
        return viewHolder;
    }


    private QuestionViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        QuestionViewHolder holder;
        View view = inflater.inflate(R.layout.question_row, parent, false);
        holder = new QuestionViewHolder(view);
        return holder;
    }

    public void setQuestions(List<Question> questions){
        this.questions = questions;
    }

    @Override
    public int getItemViewType(int position) {
        switch (Integer.parseInt(questions.get(position).type)) {
            case ITEM_TITLE:return 0;
            case ITEM_QUES:return 2;
            case ITEM_FIRST:return 1;
        }
        return ITEM_QUES;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Question question = questions.get(position);

        //Load image via glide in Profile_image
      
        switch (getItemViewType(position)) {
        /*    case ITEM_FIRST:
               // qvh.setIsRecyclable(false);
                addQuestionRow(questions, (QuestionViewHolder)viewHolder, position);
                break;*/
            case ITEM_QUES:
               // qvh.setIsRecyclable(false);
                addQuestionRow(questions,(QuestionViewHolder)viewHolder,position);
                break;
            case ITEM_TITLE:
                addTitleRow(questions,viewHolder,position);
                break;
        }
    }

    private void addTitleRow(List<Question> questions, RecyclerView.ViewHolder viewHolder, int position) {
        TitleViewHolder tvh = (TitleViewHolder) viewHolder;
        Question question = questions.get(position);
        if(!TextUtils.isEmpty(question.titleText)){
            tvh.textView.setText(question.titleText);
        }
    }

    private void addQuestionRow(List<Question> questions,QuestionViewHolder viewHolder,  int position) {
        QuestionViewHolder qvh = viewHolder;
        Question question = questions.get(position);
        if (!TextUtils.isEmpty(question.questionText))
            qvh.textView.setText(question.questionText);
    }
    private void addFirstRow(List<Question> questions,RecyclerView.ViewHolder viewHolder,  int position) {
        FirstViewHolder qvh = (FirstViewHolder)viewHolder;

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public  class QuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView textView ;
        private RadioGroup radioGroup;
        public QuestionViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.txt_ques);
            radioGroup = view.findViewById(R.id.radioGroupOptions);
        }
    }

    private class TitleViewHolder extends  RecyclerView.ViewHolder{
        private TextView textView;
        public TitleViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textTitle);
        }

    }

    public class FirstViewHolder extends  RecyclerView.ViewHolder{
        public FirstViewHolder(View view){
            super(view);
        }
    }
}
