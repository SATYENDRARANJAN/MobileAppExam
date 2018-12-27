package jfl.com.landmark.fragments;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.Calendar;

import jfl.com.landmark.R;

/**
 * A simple {@link Fragment2} subclass.
 */
public class Fragment2 extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    private Button btn_next;
    private TextInputEditText et_emp_name;
    private TextInputLayout inputLayout_emp_name;
    private TextInputEditText et_date;
    private Spinner spinner_designation ;
    private Spinner spinner_outlet;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_next = getView().findViewById(R.id.btn_next);
        et_emp_name = getView().findViewById(R.id.et_empName);
        inputLayout_emp_name = getView().findViewById(R.id.textInputpEmpName);
        et_date = getView().findViewById(R.id.et_date);
        spinner_designation = getView().findViewById(R.id.spinner_designation);
        spinner_outlet = getView().findViewById(R.id.spinner_outlet);
        setUpDesignationChooser();
        setUpOutLetChooser();
        btn_next.setOnClickListener(this);
        et_date.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener)context;
    }

    private void setUpOutLetChooser() {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, s);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_outlet.setAdapter(adp);
        spinner_outlet.setSelection(0);

        spinner_outlet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_outlet.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                if(TextUtils.isEmpty(et_emp_name.getText().toString())){
                    inputLayout_emp_name.setError("This is required!");
                    inputLayout_emp_name.setBoxBackgroundColor(getResources().getColor(R.color.colorAccent));
                    return;
                }
                mListener.loadFragment3();
                break;

            case R.id.et_date :
                openDatePicker();
                break;
        }

    }

    String[] s = { "India ", "Arica", "India ", "Arica", "India ", "Arica",
            "India ", "Arica", "India ", "Arica" };
    private void setUpDesignationChooser() {

        ArrayAdapter<String> adp = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, s);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_designation.setAdapter(adp);
        spinner_designation.setSelection(0);

        spinner_designation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_designation.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




//        final Spinner spinnerDialog = new Spinner(getActivity(),Spinner.MODE_DROPDOWN);
//        spinnerDialog.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        spinnerDialog.setAdapter(adp);
//
//        spinnerDialog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                spinner_designation.setSelection(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//        });
//
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
//        builder1.setView(spinnerDialog);
//        builder1.create().show();



    }

    private void openDatePicker() {

        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {
                    et_date.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                }};
            DatePickerDialog dpDialog=new DatePickerDialog(getActivity(), listener, yy, mm, dd);
            dpDialog.show();

    }

    public interface OnFragmentInteractionListener{
        void loadFragment3();
    }

}
