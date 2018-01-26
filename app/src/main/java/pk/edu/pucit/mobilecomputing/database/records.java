package pk.edu.pucit.mobilecomputing.database;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class records extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        Intent i = getIntent();

       ArrayList stockList = i.getStringArrayListExtra("name");

        //String[] stockArr = new String[stockList.size()];
        //stockArr = stockList.toArray(stockArr);
        //String[] arr = stockList.toArray(new String[stockList.size()]);


        //RecyclerView r= (RecyclerView) findViewById(R.id.programlist);
        //RecyclerView r=(RecyclerView)findViewById(android.R.id.list);
        //r.setLayoutManager(new LinearLayoutManager(this));
        //String [] stockList={"asdasd","adasdas","adasdasd","adasdasd","adasdasd"};
        //r.setAdapter(new adapter(stockList));

        TextView tv=(TextView)findViewById(R.id.textdata);
        String  s=" ";
        for(int lop=0;lop<stockList.size();lop++)
         {
            s = tv.getText().toString();
            s = s + "\n" + stockList.get(lop).toString() + " ";
            tv.setText(s);
         }


        }

    }

