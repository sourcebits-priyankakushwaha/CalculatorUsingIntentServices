package com.example.calculatorintentservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	String temp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Pass string values(intent) to the service class

		EditText num1 = (EditText) findViewById(R.id.op1);
		EditText num2 = (EditText) findViewById(R.id.op2);

		String a = num1.getText().toString();
		String b = num2.getText().toString();

		Intent intent = new Intent(this, CalcutaleService.class);
		OnClickListener onClick = new OnClickListener() {
			public void onClick(View view) {
				if (view.getId() == R.id.Btn1_id) {

					temp = "Addition";
				}
				if (view.getId() == R.id.Btn2_id) {
					temp = "Substraction";

				}
				if (view.getId() == R.id.Btn3_id) {

					temp = "Multiplication";
				}
				if (view.getId() == R.id.Btn4_id) {

					temp = "Division";
				}
			}
		};
		intent.putExtra("a", a);
		intent.putExtra("b", b);
		intent.putExtra("temp", temp);
		startService(intent);
	}

	public void onReceiveResult(int resultCode, Bundle resultData) {

		String[] results = resultData.getStringArray("result");

		/* Update text view with result */
	TextView textview = (TextView) findViewById(R.id.display_result);
	
	for(int i=0; i<5 ;i++)
	{
	textview.setText(results[i]);
	}

	}
}
