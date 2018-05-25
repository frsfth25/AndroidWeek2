package com.asus.gl.androidweek2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bsh.Interpreter;

public class MainActivity extends AppCompatActivity
{
    private TextView t_res;
    private String operation_text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t_res = findViewById(R.id.txt_res);
        t_res.setText(operation_text);
    }

    public void btnClick(View v)
    {
        Button b = (Button)v;
        String val = b.getText().toString();
        operation_text +=  val;
        t_res.setText(operation_text);
    }

    public void btnEqual(View view)
    {
        Interpreter interpreter = new Interpreter();
        try
        {
            interpreter.eval("result = "+ operation_text);
            t_res.setText(interpreter.get("result").toString());
            operation_text="";
        }
        catch (Exception e)
        {
            t_res.setText("Syntax error!");
            operation_text="";
        }
    }
}
