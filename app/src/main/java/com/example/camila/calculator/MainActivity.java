package com.example.camila.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Stack<Double> numbers =new Stack<Double>();
    private TextView text;
    private TextView lastStepText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Este comando oculta la barra de notificaciones
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.result);
        lastStepText = (TextView) findViewById(R.id.lastStep);

        //Cero
        findViewById(R.id.button_cero).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(0.0);
            }
        });

        //Uno
        findViewById(R.id.button_one).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(1.0);
            }
        });

        //Dos
        findViewById(R.id.button_two).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(2.0);
            }
        });

        //Tres
        findViewById(R.id.button_three).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(3.0);
            }
        });

        //Cuatro
        findViewById(R.id.button_four).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(4.0);
            }
        });

        findViewById(R.id.button_five).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(5.0);
            }
        });

        findViewById(R.id.button_six).setOnClickListener(new View.OnClickListener() { public void onClick(View v) {
                setTextNumbers(6.0);
        }});

        findViewById(R.id.button_seven).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(7.0);
            }
        });

        findViewById(R.id.button_eight).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextNumbers(8.0);
            }
        });


        findViewById(R.id.button_nine).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setTextNumbers(9.0);
            }
        });

    }

    public void setTextNumbers(double n){

        if(numbers.size()==0){
            numbers.push(n);
            text.setText(numbers.get(0)+"");
        }
        else if(numbers.size()==1){
            numbers.push(n);
            text.setText(numbers.get(0)+" "+numbers.get(1));

        }else text.setText("Error");
    }

    public void calculations(String operation){
        double a;
        double b;

        if(numbers.size()==1 && !(operation=="+") && !(operation=="-") && !(operation=="*") && !(operation=="/") && !(operation=="pY")){
            a= numbers.pop();
            if(operation=="tan"){
                numbers.push(Math.tan(Math.toDegrees(a)));
                lastStepText.setText(String.format("%.4f",a)+" "+"TAN"+" = "+numbers.peek());
            }
            if(operation=="sin"){
                numbers.push(Math.sin(Math.toDegrees(a)));
                lastStepText.setText(String.format("%.4f",a)+" "+"SIN"+" = "+numbers.peek());
            }
            if(operation=="cos"){
                numbers.push(Math.cos(Math.toDegrees(a)));
                lastStepText.setText(String.format("%.4f",a)+" "+"COS"+" = "+numbers.peek());
            }
            if(operation=="changeOfSign"){
                numbers.push(a*(-1));
            }
            if(operation=="potency2"){
                numbers.push((Math.pow(a,2)));
                lastStepText.setText(String.format("%.4f",a)+" "+"2 ^"+" = "+numbers.peek());
            }
            if(operation=="inverse"){
                numbers.push((1/a));
                lastStepText.setText("1"+String.format("%.4f",a)+"/"+" = "+numbers.peek());
            }

            text.setText(""+ String.format("%.4f", numbers.peek()));
        }
        else if(numbers.size()==2 && !(operation=="tan")&& !(operation=="sin")&& !(operation=="cos")&& !(operation=="changeOfSing")&& !(operation=="potency2")&& !(operation=="inverse")){
            a= numbers.pop();
            b= numbers.pop();

            if(operation=="+"){
                numbers.push((b+a));
                lastStepText.setText(String.format("%.4f",b)+" "+String.format("%.4f",a)+" "+"+"+" = "+numbers.peek());
            }
            if(operation=="-"){
                numbers.push((b-a));
                lastStepText.setText(String.format("%.4f",b)+" "+String.format("%.4f",a)+" "+"-"+" = "+numbers.peek());
            }
            if(operation=="*"){
                numbers.push((b*a));
                lastStepText.setText(String.format("%.4f",b)+" "+String.format("%.4f",a)+" "+"*"+" = "+numbers.peek());
            }
            if(operation=="/"){
                numbers.push((b/a));
                lastStepText.setText(String.format("%.4f",b)+" "+String.format("%.4f",a)+" "+"/"+" = "+numbers.peek());
            }
            if(operation=="pY"){
                numbers.push((Math.pow(b,a)));
                lastStepText.setText(String.format("%.4f",b)+" "+String.format("%.4f",a)+" "+"^"+" = "+numbers.peek());
            }

            text.setText(""+ String.format("%.4f", numbers.peek()));
        }
        else{
            text.setText("Error");
        }
        //Muestra el resultado de la operacion
    }
    public void sum(View view) { calculations("+");}

    public void division(View view) { calculations("/");}

    public void multiplication(View view) { calculations("*");}

    public void substract(View view) { calculations("-");}

    public void potencyY(View view) { calculations("pY");}

    public void tan(View view) { calculations("tan");}

    public void cos(View view) { calculations("cos");}

    public void sin(View view) { calculations("sin");}

    public void changeOfSign(View view) {calculations("changeOfSign");}

    public void potency2(View view) {calculations("potency2");}

    public void inverse(View view) { calculations("inverse");}

    public void clear(View view) {
        numbers.clear();
        lastStepText.setText("");
        text.setText("0");
    }

    public void submit(View view) {

    }

}


