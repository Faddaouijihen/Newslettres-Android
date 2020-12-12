package com.example.newsletters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView emails;
    private static final  String[] emailList =new String[]{
            "faddaouijihen98@gmail.com","amraoui.amina@gmail.com","faddaouifaten20@gmail.com",
            "nada.ghazouani@gmail.com"
    };
    ListView Subscription;
    private static final String[] Subscriptions = new String[]{"Daily" ,"Weekly","Monthly"};
 Button ConfirmBtn;
 String  selectedFormList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emails=(AutoCompleteTextView)findViewById(R.id.emailList);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>( this,
                android.R.layout.simple_dropdown_item_1line, (List<String>) emails);
        emails.setAdapter(adapter);
        Subscription=(ListView)findViewById(R.id.subList);
        Subscription.setAdapter(new  ArrayAdapter<String>( this,
        R.layout.support_simple_spinner_dropdown_item,Subscriptions));
        Subscription.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view , int i, long l) {
              selectedFormList=(String)Subscription.getItemAtPosition(i);
            }
        });
        ConfirmBtn=(Button)findViewById(R.id.confirmBtn);
        ConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                    "Thank you"+emails.getText().toString()+"\n You choose a"+selectedFormList+"Subscription" ,
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
