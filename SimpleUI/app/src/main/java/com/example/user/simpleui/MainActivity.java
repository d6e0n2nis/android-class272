package com.example.user.simpleui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    RadioGroup radioGroup;
    ListView listView;
    Spinner spinner;
    String drink = "Black Tea";

    List<Order> data = new ArrayList<>();

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        listView= (ListView) findViewById(R.id.listView);
        spinner = (Spinner)findViewById(R.id.spinner);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.blacktearadioButton)
                {
                    drink="Black Tea";
                }
                else if (checkedId == R.id.greentearadioButton2)
                {
                    drink = "Green Tea";
                }
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order order = (Order)parent.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this, order.note, Toast.LENGTH_LONG).show();
            }
        });


        setupListView();
        setupSpinner();
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    private void setupListView()
    {
       // String[] data = new String[]{"1","2","3","4","5","6","7","8"};

//       List<Map<String, String>> mapList = new ArrayList<>();
//
//        for(Order order : data)
//        {
//            Map<String, String> item = new HashMap<>();
//
//            item.put("note",order.note);
//            item.put("storeInfo",order.storeInfo);
//            item.put("drink",drink);
//
//            mapList.add(item);
//        }

//        String[] from = {"note","storeInfo", "drink"};
//        int[] to = {R.id.textView2,R.id.textView4,R.id.textView3};
//
//        SimpleAdapter = new SimpleAdapter(this,mapList,R.layout.listview_order_item,from,to);
        OrderAdapter adapter = new OrderAdapter(this, data);
        listView.setAdapter(adapter);
    }
    private void setupSpinner()
    {
     String[] storeInfo = getResources().getStringArray(R.array.storeInfo);
     ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item) ;
        spinner.setAdapter(adapter);
    }

    public void click(View view) {
        String text = editText.getText().toString();
        String result = text + "Order" + drink;
        textView.setText(result);

        editText.setText("");

        Order order = new Order();


        order.note = text;
        order.drink = drink;
        order.storeInfo = (String)spinner.getSelectedItem();


        data.add(order);
        setupListView();
    }

    @Override
    public void onStart() {
        super.onStart();


        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://com.example.user.simpleui/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.user.simpleui/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
