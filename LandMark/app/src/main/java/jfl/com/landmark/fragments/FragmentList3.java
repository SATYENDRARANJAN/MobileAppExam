package jfl.com.landmark.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import jfl.com.landmark.R;
import jfl.com.landmark.adapter.RecyclerViewAdapter;
import jfl.com.landmark.model.Question;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentList3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentList3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentList3 extends Fragment {


    private OnFragmentInteractionListener mListener;

    private Button btn_next;
    private RecyclerView recyclerView;
    public RecyclerViewAdapter recyclerViewAdapter;

    public FragmentList3() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentList3 newInstance(String param1, String param2) {
        FragmentList3 fragment = new FragmentList3();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        recyclerViewAdapter = new RecyclerViewAdapter(getContext());

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_next = getView().findViewById(R.id.btn_next);
        recyclerView = getView().findViewById(R.id.recycler_questions);
        List<Question> queList = new ArrayList<>();
        queList = getQuestionList();
        recyclerViewAdapter.setQuestions(queList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.loadFragment4();
            }
        });
    }

    private List<Question> getQuestionList() {
        List<Question> queList = new ArrayList<>();
        //for(int i =0;i<30;i++){
        int i = 1;
            Question question = new Question(String.valueOf(i++),"2","HYGIENE","WHAT IS THE HYGIENE ?",null);
            Question question2 = new Question(String.valueOf(i++),"2","HYGIENE","Cleans the cutlery in teh condiment holder at Regular intervals  ?",null);
            Question question3 = new Question(String.valueOf(i++),"2","HYGIENE","Cleans all equipment as per instructions after/every time ?",null);
            Question question4 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question5 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question6 = new Question(String.valueOf(i++),"0","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question7 = new Question(String.valueOf(i++),"1","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question8 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question9 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question10 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question11 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question12 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question13 = new Question(String.valueOf(++i),"0","CLEANLINESS","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question14 = new Question(String.valueOf(++i),"1","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question15 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question16 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question17 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question19 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);
            Question question20 = new Question(String.valueOf(i++),"2","HYGIENE","Keeps the POS AND TEH KEYBOARD DUST free?",null);


            queList.add(question);
            queList.add(question2);
            queList.add(question3);
            queList.add(question4);
            queList.add(question5);
            queList.add(question6);
            queList.add(question7);
            queList.add(question8);
            queList.add(question9);
            queList.add(question10);
            queList.add(question11);
            queList.add(question12);
            queList.add(question13);
            queList.add(question14);
            queList.add(question15);
            queList.add(question16);
            queList.add(question17);
            queList.add(question19);
            queList.add(question20);
        //}
        return queList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_list3, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void loadFragment4();
    }
}
