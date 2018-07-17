package com.example.sk.fifa;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apptimize.Apptimize;
import com.apptimize.ApptimizeTest;


public class MainActivity extends AppCompatActivity {

    TextView message;
    Button click;
    TextView message1;
    Button click1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Apptimize.setup(this, "BFEmDf53pRF8rhZa4UQvWMcdBdugggQ");

        message = (TextView)findViewById(R.id.tvMessage);
        click = (Button)findViewById(R.id.btnClick);

        message1 = (TextView)findViewById(R.id.tvMessage1);
        click1 = (Button)findViewById(R.id.btnClick1);


        Apptimize.runTest("EXPERIMENT1", new ApptimizeTest() {
            @Override
            public void baseline() {
                // Variant: original
                click1.setVisibility(View.INVISIBLE);
                click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        message.setVisibility(View.VISIBLE);
                        message1.setVisibility(View.INVISIBLE);
                    }
                }
                );

            }

            @SuppressWarnings("unused")
            public void variation1() {
                // Variant: Variant B

                click.setVisibility(View.INVISIBLE);
                click1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        message.setVisibility(View.INVISIBLE);
                        message1.setVisibility(View.VISIBLE);
                    }
                });

            }
        });



    }









}
