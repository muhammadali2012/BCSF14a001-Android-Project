package pk.edu.pucit.mobilecomputing.database.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Date;

/**
 * Created by abc on 1/18/18.
 *
 * @package pk.edu.pucit.mobilecomputing.database.Database
 * @project Database
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "Hisab";

    //COLUMN NAMES
    public static final String ID = "ID";
    public static final String NAME = "name";
    public static final String AMOUNT = "amount";
    public static final String DATE = "date";
    public static final String NOTE= "note";



    //COLUMN TYPES
    public static final String TYPE_TEXT = " TEXT ";
    public static final String TYPE_INT = " INT ";
    public static final String SEPERATOR = ", ";
    private static final String DATABASE_NAME = "test.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_query = "Create table " + TABLE_NAME + " ("
                + ID + TYPE_INT + " AUTO_INCREMENT PRIMARY KEY " + SEPERATOR
                + NAME + TYPE_TEXT + SEPERATOR
                + AMOUNT + TYPE_TEXT + SEPERATOR
                + NOTE + TYPE_TEXT + SEPERATOR
                + DATE + TYPE_TEXT + ");";
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_query = "drop database if exists " + DATABASE_NAME;
        db.execSQL(drop_query);
        onCreate(db);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public long insert(String name, String amount,String note) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(AMOUNT, amount);
        cv.put(NOTE, note);
        cv.put(DATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        long i = db.insert(TABLE_NAME, null, cv);
        Log.d("Database_helper", String.valueOf(i));
        //be sure to close database after work is done
        db.close();
        return i;
    }


    public Cursor read(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[]{"name","amount","date","note"}, null, null, null, null, null);

        return c;
    }






}
