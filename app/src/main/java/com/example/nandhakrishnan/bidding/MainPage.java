package com.example.nandhakrishnan.bidding;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainPage extends Activity {
    EditText ed;
    EditText pd;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        loginButton= (Button) findViewById(R.id.btlogin);
        ed= (EditText) findViewById(R.id.user_name);
        pd= (EditText) findViewById(R.id.passwd);

        OnClickListener oclBtnOk = new OnClickListener() {



                @Override
                public void onClick(View v) {

                    if (validationSuccess()) {


                        Intent mIntent;
                        mIntent = new Intent(
                                MainPage.this,
                                listpage.class);
                        startActivity(mIntent);
                    }
                    else {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainPage.this);
                        builder1.setMessage("Invalid Username/Password");
                        builder1.setCancelable(false);
                        builder1.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();
                    }
                }


            private Boolean validationSuccess(){
                if(ed.getText().toString().equalsIgnoreCase("root") && pd.getText().toString().equals("root") )
                    return true;
                return false;
                }
    };
        loginButton.setOnClickListener(oclBtnOk);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
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
}
