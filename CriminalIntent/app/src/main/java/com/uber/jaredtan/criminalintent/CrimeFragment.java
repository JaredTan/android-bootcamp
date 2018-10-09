package com.uber.jaredtan.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

import static android.widget.CompoundButton.*;

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mEditTextField;
    private Button mButton;
    private CheckBox mCheckbox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getActivity().getIntent()
                .getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
        Log.d("@@@@ id 2",  crimeId.toString());
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
        Log.d("@@@@ title 3",  mCrime.getTitle());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        mEditTextField = v.findViewById(R.id.crime_title);
        mEditTextField.setText(mCrime.getTitle());
        mEditTextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
//                blank
            }
        });
        mButton = v.findViewById(R.id.crime_date);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.setText(mCrime.getDate().toString());
                mButton.setEnabled(false);
            }
        });

        mCheckbox = v.findViewById(R.id.crime_solved);
        mCheckbox.setChecked(mCrime.isSolved());
        mCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });
        return v;
    }


}
