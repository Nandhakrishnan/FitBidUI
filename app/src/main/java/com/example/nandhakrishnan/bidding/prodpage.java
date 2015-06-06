package com.example.nandhakrishnan.bidding;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class prodpage extends Activity {
    TextView _tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

        setContentView(R.layout.prodpage);

        Bundle extras = getIntent().getExtras();


        TextView ert1= (TextView) findViewById(R.id.pname);
        ert1.setText(extras.getString("prodname"));


        TextView ert2= (TextView) findViewById(R.id.pdescription);
        ert2.setText(extras.getString("proddescription"));

        TextView ert3= (TextView) findViewById(R.id.sname);
        ert3.setText(extras.getString("sellername"));

        // EditText ert4= (EditText) findViewById(R.id.pimage);
        //ert4.setText(mp.get(position).get(3));

        TextView ert5= (TextView) findViewById(R.id.cbid);
        ert5.setText(extras.getString("curbid"));

        _tv = (TextView) findViewById( R.id.timer );
        new CountDownTimer(300000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                _tv.setText(""+String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                _tv.setText("Time Exceeded");
            }
        }.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prodpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void clickprodBack(View view)
    {
        Intent mIntent;
        mIntent = new Intent(
                prodpage.this,
                listpage.class);
        startActivity(mIntent);
    }
}
