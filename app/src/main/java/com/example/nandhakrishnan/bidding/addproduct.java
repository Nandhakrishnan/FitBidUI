package com.example.nandhakrishnan.bidding;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class addproduct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproduct);

        Button addButton = (Button) findViewById(R.id.btadd);
        TextView newprodname = (TextView) findViewById(R.id.npname);
        TextView newproddesc = (TextView) findViewById(R.id.npdescription);
        TextView newprodbid = (TextView) findViewById(R.id.nbid);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addproduct, menu);
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

    public void ClickNewAdd(View view)
    {

    }
    public void clickBack(View view)
    {
        Intent mIntent;
        mIntent = new Intent(
                addproduct.this,
                listpage.class);
        startActivity(mIntent);
    }
}
