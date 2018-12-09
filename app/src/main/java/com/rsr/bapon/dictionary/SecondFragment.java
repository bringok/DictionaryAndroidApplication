package com.rsr.bapon.dictionary;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class SecondFragment extends Fragment implements View.OnClickListener{

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    Intent i;

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);

        mScoreView = (TextView)v.findViewById(R.id.score);
        mQuestionView = (TextView)v.findViewById(R.id.question);
        mButtonChoice1 = (Button)v.findViewById(R.id.choice1);
        mButtonChoice2 = (Button)v.findViewById(R.id.choice2);
        mButtonChoice3 = (Button)v.findViewById(R.id.choice3);
        mButtonChoice4 = (Button)v.findViewById(R.id.quit);

        updateQuestion();

        mButtonChoice1.setOnClickListener(this);
        mButtonChoice2.setOnClickListener(this);
        mButtonChoice3.setOnClickListener(this);
        mButtonChoice4.setOnClickListener(this);

        return  v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.choice1:
                if(mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }

                else{
                    Toast.makeText(getActivity(),"Wrong!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;

            case R.id.choice2:
                if(mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }

                else{
                    Toast.makeText(getActivity(),"Wrong!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;

            case R.id.choice3:
                if(mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(getActivity(),"Correct!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }

                else{
                    Toast.makeText(getActivity(),"Wrong!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;

            case R.id.quit:
                updateScore(mScore);
                Toast.makeText(getActivity(),"Total Score : "+mScore, Toast.LENGTH_SHORT).show();

                i = new Intent(getActivity(),MainActivity.class);

                startActivity(i);

                break;


        }

    }


    public void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;

        if (mQuestionNumber > 20){

            Toast.makeText(getActivity(),"Total Score : "+mScore, Toast.LENGTH_SHORT).show();

            i = new Intent(getActivity(),MainActivity.class);

            startActivity(i);

        }
    }


    private void updateScore(int point) {

        mScoreView.setText("" + mScore);
    }
}
