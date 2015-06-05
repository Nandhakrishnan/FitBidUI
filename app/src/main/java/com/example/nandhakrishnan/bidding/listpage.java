package com.example.nandhakrishnan.bidding;

/**
 * Created by nandha.krishnan on 05/06/15.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class listpage extends Activity {
    ListView pListView ;
    ListView ppriceView ;
    ListView pbidView ;
    public Map<Integer,ArrayList<String>> mp = new HashMap<Integer,ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpage);

        // Get ListView object from xml
        pListView = (ListView) findViewById(R.id.plist);


        // Defined Array values to show in ListView
       /* String[] listvalues = new String[] { "Tshirt",
                "Iphone",
                "calculator",
                "TV",
                "Laptop",
                "Iphone",
                "calculator",
                "TV",
                "Laptop",
                "Iphone",
                "calculator",
                "TV",
                "Laptop"
        };*/


        for (int i=0;i<12;i++ )
        {

            ArrayList<String> rr=new ArrayList<String>();
            rr.add("Product"+i);
            rr.add("Description"+i);
            rr.add("Seller"+i);
            rr.add("ImageURL"+i);
            rr.add("Currentbid"+i);

            mp.put(i,rr);
        }

        String[] listvalues;
        listvalues = new String[mp.size()];
        for(int i=0;i<mp.size();i++)
        {
            listvalues[i]=mp.get(i).get(0);
        }

        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listvalues);


        // Assign adapter to ListView
        pListView.setAdapter(listadapter);


     



        // ListView Item Click Listener
        pListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch( position )
                {
                    case 1:  EditText ert1= (EditText) findViewById(R.id.pname);
                        ert1.setText(mp.get(position).get(0));



                        EditText ert2= (EditText) findViewById(R.id.pdescription);
                        ert2.setText(mp.get(position).get(1));

                        EditText ert3= (EditText) findViewById(R.id.sname);
                        ert3.setText(mp.get(position).get(2));

                        EditText ert4= (EditText) findViewById(R.id.pimage);
                        ert4.setText(mp.get(position).get(3));

                        EditText ert5= (EditText) findViewById(R.id.cbid);
                        ert5.setText(mp.get(position).get(4));

                        Toast.makeText(getApplicationContext(),R.id.pname,Toast.LENGTH_LONG).show();



                       Intent mIntent;
                    mIntent = new Intent(
                            listpage.this,
                            productpage.class);
                    startActivity(mIntent);
                        break;



                  /*  case 1:  Intent newActivity = new Intent(this, youtube.class);
                        startActivity(newActivity);
                        break;
                    case 2:  Intent newActivity = new Intent(this, olympiakos.class);
                        startActivity(newActivity);
                        break;
                    case 3:  Intent newActivity = new Intent(this, karaiskaki.class);
                        startActivity(newActivity);
                        break;
                    case 4:  Intent newActivity = new Intent(this, reservetickets.class);
                        startActivity(newActivity);
                        break;*/
                }
            }



                // ListView Clicked item index


                // ListView Clicked item value
                //String  itemValue    = (String) pListView.getItemAtPosition(position);


                // Show Alert
               /* Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();*/


        });
    }

}