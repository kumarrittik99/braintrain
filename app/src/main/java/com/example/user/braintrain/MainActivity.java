package com.example.user.braintrain;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    int i=0,a,b,incorrectAnswer=0,score=0,countOfQuestions=0,n;
    int generatedInt;
    TextView conclusion;
    TextView timeCounter;
    TextView scoreCounter;
    Random randomNumber = new Random();
    TextView questionView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    ArrayList<String> symbol = new ArrayList<String>();
    String optionID,A,B,trueScore,trueCountofQuestions,N;
    TextView finalScoreCard;
    Button tryAgain;
    LinearLayout welcomeLayout;
    RelativeLayout mainLayout;
    RelativeLayout lastLayout;
    int max1,min1,max2,min2,max3,min3,max4,min4;



    //code to give comments
    public void resultAnnounce(int c, int s)
    {
        if(c>=30);
        {
            if(s>24)
            {
                Toast.makeText(getApplicationContext(),"Excellent Performance!!! :-)",Toast.LENGTH_LONG).show();
            }
            else if(s>19)
            {
                Toast.makeText(getApplicationContext(),"Very Good!!! :-)",Toast.LENGTH_LONG).show();
            }
            else if(s>14)
            {
                Toast.makeText(getApplicationContext(),"Good!!!  :-)",Toast.LENGTH_LONG).show();
            }
            else if(s>9)
            {
                Toast.makeText(getApplicationContext(),"Can do better :-)",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Poor!!! Work Hard!!! ",Toast.LENGTH_LONG).show();
            }
        }
        if(c<30&&c>20)
        {
            if(s>19)
            {
                Toast.makeText(getApplicationContext(),"Very Good!!! :-)",Toast.LENGTH_LONG).show();
            }
            else if(s>14)
            {
                Toast.makeText(getApplicationContext(),"Good!!!  :-)",Toast.LENGTH_LONG).show();
            }
            else if(s>9)
            {
                Toast.makeText(getApplicationContext(),"Can do better :-)",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Poor!!! Work Hard!!! ",Toast.LENGTH_LONG).show();
            }
        }
        else if(c<21&&c>15)
        {
            if(s>14)
            {
                Toast.makeText(getApplicationContext(),"Good!!!  :-)",Toast.LENGTH_LONG).show();
            }
            else if(s>9)
            {
                Toast.makeText(getApplicationContext(),"Can do better :-)",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Poor!!! Work Hard!!! ",Toast.LENGTH_LONG).show();
            }
        }
        else if(c<16&&c>9)
        {
            if(s>9)
            {
                Toast.makeText(getApplicationContext(),"Can do better :-)",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Poor!!! Work Hard!!! ",Toast.LENGTH_LONG).show();
            }

        }
        else if(c<11&&c>5)
        {
            if(score>4)
            {
                Toast.makeText(getApplicationContext(),"Poor!!! Work Hard!!! ",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Not good at all !!! ",Toast.LENGTH_LONG).show();
            }
        }
        else if(c<6)
        {
            Toast.makeText(getApplicationContext(),"Need to increase your speed !!! ",Toast.LENGTH_LONG).show();
        }
    }
    //Code to find factorial

    int factorial (int num)
    {
        if(num==0)
        {
            return 1;
        }
        else
        {
            num=num*factorial(num-1);
        }
        return num;
    }

    //Code for playing the game again


    public void playAgain(View view)
    {
        tryAgain = (Button)findViewById(R.id.tryAgain);
        lastLayout.setVisibility(view.INVISIBLE);
        welcomeLayout.setVisibility(view.VISIBLE);
        score=0;
        countOfQuestions=0;
        trueScore = Integer.toString(score);
        trueCountofQuestions=Integer.toString(countOfQuestions);
        if(score<=9)
        {
            trueScore = "0"+Integer.toString(score);
        }
        if(countOfQuestions<=9)
        {
            trueCountofQuestions="0"+Integer.toString(countOfQuestions);
        }
        scoreCounter.setText(trueScore+"/"+trueCountofQuestions);
    }




    //Code for generating new Question



    public void generateNewQuestion() {
        a = randomNumber.nextInt(21);
        b = randomNumber.nextInt(21);
        generatedInt = randomNumber.nextInt(4);
        if(generatedInt==1)
        {
            while (a < b)
            {
                a = randomNumber.nextInt(21);
                b = randomNumber.nextInt(21);

            }
        }
        n = randomNumber.nextInt(11);
        max1=(a+b+10);
        min1=(a+b-10);
        max2=(a-b+10);
        min2=(a-b-10);
        max3=((a*b)+10);
        min3=((a*b)-10);
        max4=(factorial(n)+10);
        min4=(factorial(n)-10);
        A = Integer.toString(a);
        B = Integer.toString(b);
        N = Integer.toString(n);

        if(generatedInt<3)
        {
            questionView.setText(A + symbol.get(generatedInt) + B + " = ?");
        }
        else
        {

            questionView.setText(N + symbol.get(generatedInt)+ " = ?");
        }

        for (i = 0; i < 4; i++)
        {
            if (i == generatedInt)
            {
                if (generatedInt == 0)
                {
                    answers.add(a + b);
                }
                else if (generatedInt == 1)
                {
                    answers.add(a - b);
                }
                else if (generatedInt == 2) {
                    answers.add(a * b);
                }
                else
                {
                    answers.add(factorial(n));
                }
            }
            else
            {
                if (generatedInt == 0)
                {
                    incorrectAnswer = randomNumber.nextInt(max1-min1)+min1;
                    while (incorrectAnswer == (a + b))
                    {
                        incorrectAnswer = randomNumber.nextInt(max1-min1)+min1;
                    }
                    answers.add(incorrectAnswer);
                }
                else if (generatedInt == 1)
                {
                    incorrectAnswer = randomNumber.nextInt(max2-min2)+min2;
                    while (incorrectAnswer == (a - b))
                    {
                        incorrectAnswer = randomNumber.nextInt(max2-min2)+min2;
                    }
                    answers.add(incorrectAnswer);
                }
                else if (generatedInt == 2)
                {
                    incorrectAnswer = randomNumber.nextInt(max3-min3)+min3;
                    while (incorrectAnswer == (a * b))
                    {
                        incorrectAnswer = randomNumber.nextInt(max3-min3)+min3;
                    }
                    answers.add(incorrectAnswer);
                }
                else
                {
                    incorrectAnswer = randomNumber.nextInt(max4-min4)+min4;
                    while (incorrectAnswer == (factorial(n)))
                    {
                        incorrectAnswer = randomNumber.nextInt(max4-min4)+min4;
                    }
                    answers.add(incorrectAnswer);
                }

            }
        }
        option1.setText(Integer.toString(answers.get(0)));
        option2.setText(Integer.toString(answers.get(1)));
        option3.setText(Integer.toString(answers.get(2)));
        option4.setText(Integer.toString(answers.get(3)));

        answers.clear();


    }

    //Code for choosing the option and generating new question after option is choosen


    public void onClickOption(View view)
    {
        conclusion = (TextView) findViewById(R.id.conclusion);
        optionID = view.getTag().toString();
        if(optionID==Integer.toString(generatedInt))
        {
            conclusion.setText("Correct!");
            score++;
            countOfQuestions++;
        }
        else
        {
            conclusion.setText("Wrong!");
            countOfQuestions++;
        }
        trueScore = Integer.toString(score);
        trueCountofQuestions=Integer.toString(countOfQuestions);
        if(score<=9)
        {
            trueScore = "0"+Integer.toString(score);
        }
        if(countOfQuestions<=9)
        {
            trueCountofQuestions="0"+Integer.toString(countOfQuestions);
        }
        scoreCounter.setText(trueScore+"/"+trueCountofQuestions);
        generateNewQuestion();
    }



       //Code for starting the game


       public void startTraining(View view)
    {
        welcomeLayout= (LinearLayout) findViewById(R.id.welcomeLayout);
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        lastLayout = (RelativeLayout) findViewById(R.id.lastLayout);
        timeCounter = (TextView)findViewById(R.id.timeCounter);
        welcomeLayout.setVisibility(View.INVISIBLE);
        mainLayout.setVisibility(View.VISIBLE);
        CountDownTimer counter = new CountDownTimer(60000+1000,1000)
        {
            @Override
            public void onTick(long l)
            {
                int seconds = (int)l/1000;
                String second = Integer.toString(seconds);
                timeCounter.setText(second+"s");
            }

            @Override
            public void onFinish()
            {
                mainLayout.setVisibility(View.INVISIBLE);
                lastLayout.setVisibility(View.VISIBLE);
                finalScoreCard = (TextView)findViewById(R.id.finalScoreCard);
                finalScoreCard.setText(Integer.toString(score)+"/"+Integer.toString(countOfQuestions));
                resultAnnounce(countOfQuestions,score);

            }
        }.start();

    }



    //code for onCreate method


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        questionView = (TextView) findViewById(R.id.questionView);
        conclusion = (TextView) findViewById(R.id.conclusion);
        scoreCounter= (TextView)findViewById(R.id.scoreCounter);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);
        option1.setTag(0);
        option2.setTag(1);
        option3.setTag(2);
        option4.setTag(3);
        symbol.add("+");
        symbol.add("-");
        symbol.add("*");
        symbol.add("!");
        generateNewQuestion();
    }
}
