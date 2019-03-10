package com.example.lab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView txtvwAge;
    ImageView vimage;
    EditText edtName,edtYear;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       txtvwAge=(TextView) findViewById(R.id.txtvwAge);
       edtName = (EditText) findViewById(R.id.edtTxtName);
       edtYear = (EditText) findViewById(R.id.edtYear);
       vimage = (ImageView) findViewById(R.id.imgProfile);

       Intent intent = getIntent();
       if(intent.hasExtra("bp")){
       Bitmap image = (Bitmap)intent.getExtras().get("bp");
        vimage.setImageBitmap(image);}
        else{}
    }

    public void fnGreet(View v){

        String strName = edtName.getText().toString();
        String strYear = edtYear.getText().toString();
        int year = Integer.parseInt(strYear);
        int age = 2019-year;
        txtvwAge.setText("Hello and welcome "+strName+"Your age is"+age);

    }



    public void fnThreadActivity(View view) {

        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMsg = ((EditText) findViewById(R.id.edtTxtName)).getText().toString();
        intent.putExtra("varStr1",strMsg);
        startActivity(intent);
    }

}
