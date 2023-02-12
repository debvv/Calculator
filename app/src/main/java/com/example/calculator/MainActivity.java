package com.example.calculator;
import android.app.Activity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity implements OnClickListener {
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;
    EditText etN1,etNum2;
    EditText etNumm3;
    Button btnAdd, btnSub, btnMult, btnDiv;     // object declaration
    Button btnStepeni;
    TextView tvResult;
    TextView tvResult2;
    String oper = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etN1 = (EditText)findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);
        etNumm3 = (EditText)findViewById(R.id.etNum3);


        btnAdd = (Button)findViewById(R.id.btnAdd);
        //defined by the expression
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMult = (Button)findViewById(R.id.btnMult);
        btnDiv = (Button)findViewById(R.id.btnDiv);

        tvResult = (TextView)findViewById(R.id.tvResult);
        tvResult2 = (TextView)findViewById(R.id.tvResult2);
        btnAdd.setOnClickListener(this);
        //here, in the onCreate method, the expression is identified
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;
        float num3 = 0;
        // check if the fields are empty
        // obliges the ETN1 and etNum2 elements to contain some data
        // before starting the operation with a single click
        if
        (TextUtils.isEmpty(etN1.getText().toString())
                ||
                TextUtils.isEmpty(etNum2.getText().toString()
                ) ||TextUtils.isEmpty(etNumm3.getText().toString()  )) {
            return;
        }
        //this is the way to retrieve information from a
        //EditText, converting the retrieved value to String value,then converting it to float value.
        num1 = Float.parseFloat(etN1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());
        num3 = Float.parseFloat(etNumm3.getText().toString());
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;



            default:
                break;
        }
        // form the output line
        //it is an example of placing data in a TextView control element.
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
        tvResult2.setText("result^num3 "+ " " + " = "  + Math.pow(result,num3) ) ;
    }
}