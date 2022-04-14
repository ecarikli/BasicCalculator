package com.ekremcarikli.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9
                ,btnAc,btnDel,btnPlus,btnMinus,btnDivide,btnMulti,btnEqual,btnDot;

    private TextView textViewResult,textViewHistory;
    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;


    DecimalFormat myFormater = new DecimalFormat("######.######");

    String history, currentResult;

    boolean dot = true;

    boolean btnACControl = true;

    boolean btnEqualControl = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus =findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);

        btnAc = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);

        textViewResult = findViewById(R.id.textviewResult);
        textViewHistory = findViewById(R.id.textviewHistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });





        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = null;
                status = null;
                textViewResult.setText("");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                btnACControl = true;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btnACControl){
                    textViewResult.setText("0");
                }
                else{
                    number = number.substring(0,number.length() -1);
                    if (number.length() == 0){
                        btnDel.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot = false;
                    }
                    else{
                        dot = true;
                    }
                    textViewResult.setText(number);
                }



            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator){
                    if (status == "sum"){
                        plus();
                    }
                    else if (status == "subtraction"){
                        minus();
                    }

                    else if (status == "multiplacition"){
                        muliptly();
                    }
                    else if (status == "division"){
                        divide();
                    }
                    else{
                        firstNumber  = Double.parseDouble(textViewResult.getText().toString());
                    }
                }

                operator =false;
                btnEqualControl = true;


            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "+");

                if (operator == true){

                    if (status == "multiplacition"){
                        muliptly();
                    }
                    else if (status == "division"){
                        divide();
                    }
                    else if (status == "subtraction"){
                        minus();
                    }
                    else{
                        plus();
                    }
                }

                status = "sum";
                operator = false;
                number = null;
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "-");

                if (operator){
                    if (status == "multiplacition"){
                        muliptly();
                    }
                    else if (status == "division"){
                        divide();
                    }

                    else if(status == "sum"){
                        plus();
                    }

                    else{
                        minus();
                    }

                }

                status = "subtraction";
                operator = false;
                number = null;


            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "*");

                if (operator){

                    if (status == "sum") {
                        plus();
                    } else if (status == "division") {
                        divide();
                    }
                    else if (status == "subtraction"){
                        minus();
                    }
                    else{
                        muliptly();
                    }
                }

                status = "multiplacition";
                operator = false;
                number = null;

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "/");

                if (operator){
                    if (status == "multiplacition"){
                        muliptly();
                    }
                    else if (status == "sum"){
                        plus();
                    }
                    else if (status == "subtraction"){
                        minus();
                    }
                    else{
                        divide();
                    }
                }

                status = "division";
                operator = false;
                number = null;

            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dot){
                    if (number == null){
                        number = "0.";

                    }
                    else{
                        number = number + ".";
                    }
                }


                textViewResult.setText(number);
                dot = false;
            }
        });





    }

    public void numberClick(String view)
    {
        if (number==null){
            number = view;

        }
        else if (btnEqualControl){
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }

        else{
            number  = number+view;
        }

        textViewResult.setText(number);
        operator = true;
        btnACControl = false;
        btnDel.setClickable(true);
        btnEqualControl = false;
    }

    public void plus(){
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;

        textViewResult.setText(myFormater.format(firstNumber));
        dot = true;
    }

    public void minus(){
        if (firstNumber == 0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }

        textViewResult.setText(myFormater.format(firstNumber));
        dot = true;
    }

    public void muliptly(){
        if (firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewResult.setText(myFormater.format(firstNumber));
        dot = true;
    }

    public void divide(){
        if (firstNumber == 0){
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = (lastNumber / 1);

        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textViewResult.setText(myFormater.format(firstNumber));
        dot = true;
    }
}