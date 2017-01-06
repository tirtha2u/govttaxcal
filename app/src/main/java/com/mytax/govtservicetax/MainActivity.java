package com.mytax.govtservicetax;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mytax.govtservicetax.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayTaxActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        float billAmount = Float.parseFloat(message);
        float serviceTax = (float) (billAmount * 0.14);
        float krisiCess = (float) (billAmount * 0.05);
        float swatchBharatTax = (float) (billAmount * 0.05);

        float total = billAmount + serviceTax + krisiCess + swatchBharatTax ;
        String totalStr = total + "";

        intent.putExtra(EXTRA_MESSAGE, totalStr);
        startActivity(intent);
    }
}
