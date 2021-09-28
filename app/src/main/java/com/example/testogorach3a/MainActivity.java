package com.example.testogorach3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private CheckBox[] checkBoxes = new CheckBox[3];

    //tablica z pytaniami

    private Question[] allQuestion = new Question[]{
            new Question(R.string.q1,
                    new int[]{R.string.a1_a, R.string.a1_b, R.string.a1_c},
                    new boolean[]{false, true, true}),
            new Question(R.string.q2,
                    new int[]{R.string.a2_a, R.string.a2_b, R.string.a2_c},
                    new boolean[]{false, true, true}),
            new Question(R.string.q3,
                    new int[]{R.string.a3_a, R.string.a3_b, R.string.a3_c},
                    new boolean[]{false, true, true})
    };
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //odnajdujemy odpowednie miejsca
        questionTextView =(TextView) findViewById(R.id.textquestion);
        checkBoxes = new CheckBox[]{findViewById(R.id.checkBox),
                                    findViewById(R.id.checkBox2),
                                    findViewById(R.id.checkBox3)}    ;
        questionView(0);
    }


    //funkcja ktora laduje tresc konkretnego pytania
    public void questionView(int currentIndex){
        questionTextView.setText(allQuestion[currentIndex].getTextQuestionId());
        int i=0;
        for (CheckBox check:checkBoxes){

            check.setText((allQuestion[currentIndex].getAnswer(i)));
            check.setChecked(false);
            i++;
        }




    }

    public void nextquestion(View view) {
        currentIndex++;
        if (currentIndex==allQuestion.length)
            currentIndex=0;
        //todo na zakonczenie dodać nową aktywnosc z podsumowaniem
        questionView(currentIndex);

    }
}