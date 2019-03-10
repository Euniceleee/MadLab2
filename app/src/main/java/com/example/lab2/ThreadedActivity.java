package com.example.lab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv1;
    Bitmap bp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

        iv = (ImageView) findViewById(R.id.imgVwProfile);
        Intent intent = getIntent();
        String strMsg = intent.getStringExtra("varStr1");
        tv1 = (TextView) findViewById(R.id.txtVwHello);
        tv1.setText("Welcome to new activity wahai "+strMsg);
    }

    public void fnPImage(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("bp",bp);
        startActivity(intent);
    }

    public void fnTakePic (View vw)
    {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText(tv1.getText().toString()+"..This is your picture..");
                    }
                });
            }
        };

        Thread thr = new Thread(run);
        thr.start();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
    }
}
