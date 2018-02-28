package com.asus.gl.androidweek2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String MUL = "*";
    private static  int count = 0;
    private TextView t_res;
    private TextView t_sym;
    private EditText edt_first, edt_second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t_res = findViewById(R.id.txt_res);
        t_sym = findViewById(R.id.txt_sym);

        edt_first= findViewById(R.id.edt_firstNum);
        edt_second = findViewById(R.id.edt_secondNum);

    }

    public void btnClick(View v){
        int  id  = v.getId();
        double res =0.0;
        switch (id){
            case R.id.btn_eql:
                String sym = t_sym.getText().toString();
                double firstVal = Double.parseDouble(edt_first.getText().toString());
                double secondVal =  Double.parseDouble(edt_second.getText().toString());

                if(sym.equals("SYM"))
                    Toast.makeText(this, "You have to specify op.", Toast.LENGTH_LONG).show();
                else if(sym.equals(MUL)){
                    res = firstVal*secondVal;
                }
                break;
            case R.id.btn_div:
                t_sym.setText("/");
                break;
            case R.id.btn_mul:
                t_sym.setText(MUL);
                break;
            case R.id.btn_sub:
                t_sym.setText("-");
                break;
            case R.id. btn_sum:
                t_sym.setText("+");
                break;
        }

        t_res.setText(res + "");
    }
}
