package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstnum;
    String operations;

    TextView  solutionTv;
    MaterialButton btnOn, btnOff, btnDlt;
    MaterialButton btnDivide, btnMultiply, btnplus, btnminus, btnequals;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    MaterialButton btnAC, btnDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solutionTv = findViewById(R.id.solution_tv);

        btnOn = findViewById(R.id.button_on);
        btnOff = findViewById(R.id.button_off);
        btnDlt = findViewById(R.id.button_dlt);
        btnDivide = findViewById(R.id.button_divide);
        btnMultiply = findViewById(R.id.button_x);
        btnplus = findViewById(R.id.button_plus);
        btnminus = findViewById(R.id.button_minus);
        btnequals = findViewById(R.id.button_equals);
        btnAC = findViewById(R.id.button_ac);
        btnDot = findViewById(R.id.button_dot);

        btn0 = findViewById(R.id.button_zero);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);


        btnAC.setOnClickListener(view ->{
            firstnum=0;
            solutionTv.setText("0");
        });

        btnOff.setOnClickListener(view -> solutionTv.setVisibility(view.GONE));

        btnOn.setOnClickListener(view -> {
            solutionTv.setVisibility(view.VISIBLE);
            solutionTv.setText("0");
        });
        ArrayList<MaterialButton> nums = new ArrayList<>();
        nums.add(btn0);
        nums.add(btn1);
        nums.add(btn2);
        nums.add(btn3);
        nums.add(btn4);
        nums.add(btn5);
        nums.add(btn6);
        nums.add(btn7);
        nums.add(btn8);
        nums.add(btn9);

        for (MaterialButton b :nums) {
            b.setOnClickListener(view -> {
                if (!solutionTv.getText().toString().equals("0")) {
                    solutionTv.setText(solutionTv.getText().toString() + b.getText().toString());
                } else {
                    solutionTv.setText(b.getText().toString());
                }
            });
        }
            ArrayList<MaterialButton> operss = new ArrayList<>();
            operss.add(btnDivide);
            operss.add(btnMultiply);
            operss.add(btnplus);
            operss.add(btnminus);

            for (MaterialButton b : operss) {
                b.setOnClickListener(view -> {
                    firstnum = Double.parseDouble(solutionTv.getText().toString());
                    operations = b.getText().toString();
                    solutionTv.setText("0");
                });
            }
            btnDlt.setOnClickListener(view->{
                String num = solutionTv.getText().toString();
                if(num.length()>1){
                    solutionTv.setText((num.substring(0,num.length()-1)));
                }
                else if(num.length()==1 && !num.equals("0")){
                    solutionTv.setText("0");
                }
            });
                    btnDot.setOnClickListener(view ->{
                        if (!solutionTv.getText().toString().contains(".")){
                            solutionTv.setText(solutionTv.getText().toString()+" ");
                        }
            });

                    btnequals.setOnClickListener(view ->{
                        double secondNum = Double.parseDouble(solutionTv.getText().toString());
                        double result;
                        switch (operations){
                            case "/":
                                result=firstnum/secondNum;
                                break;

                                case "+":
                                    result = firstnum + secondNum;
                                    break;

                                    case "-":
                                        result=firstnum-secondNum;
                                        break;

                                        case "X":
                                            result = firstnum * secondNum;
                                            break;
                            default:
                                result=firstnum+secondNum;
                        }
                        solutionTv.setText(String.valueOf(result));
                        firstnum=result;
                    });
        }

    }
