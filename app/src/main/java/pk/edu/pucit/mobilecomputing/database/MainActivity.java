package pk.edu.pucit.mobilecomputing.database;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import pk.edu.pucit.mobilecomputing.database.Database.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DBHelper DB_Helper;
    EditText et_name, et_amount,et_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB_Helper = new DBHelper(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_amount = (EditText) findViewById(R.id.et_amount);
        et_note = (EditText) findViewById(R.id.et_note);


    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btn_view:

                Cursor bb = DB_Helper.read(123);
                ArrayList<String> rowss = new ArrayList<>();
                while (bb.moveToNext())
                {
                    rowss.add("NAME: " + bb.getString(0)
                            + "\n" + "AMOUNT: " + bb.getString(1)
                            + "\n" + "DATE: " + bb.getString(2)
                            + "\n" + "MEMO NOTE: " + bb.getString(3)+"\n"

                    );
                }
                bb.close();
                Intent intent=new Intent(getApplicationContext(),records.class);
                intent.putStringArrayListExtra("name",rowss);
                startActivity(intent);
                break;

            case R.id.btn_save:
                long rid = DB_Helper.insert(et_name.getText().toString(), et_amount.getText().toString(),et_note.getText().toString());
                Toast.makeText(this, "Hisab added ",
                        Toast.LENGTH_LONG).show();

                break;
        }

    }
}

