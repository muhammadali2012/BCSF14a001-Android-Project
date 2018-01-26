package pk.edu.pucit.mobilecomputing.database.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import pk.edu.pucit.mobilecomputing.database.Globals;

/**
 * Created by abc on 1/16/18.
 *
 * @package pk.edu.pucit.mobilecomputing.database.Database
 * @project Database
 */

// For more information check this tutorial https://www.youtube.com/watch?v=aQAIMY-HzL8
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TABLE_NAME = "Hisab";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "name";
    private static final String COL_3 = "amount";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "Create table " + TABLE_NAME + " ( "
                + COL_1 + " INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + COL_2 + " TEXT, " + COL_3 + " TEXT);";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);
    }


    public boolean add_data(String name, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        // to add params in query
        ContentValues cv = new ContentValues();
        cv.put(COL_1, name);
        cv.put(COL_2, amount);
        Log.d(Globals.LOG_TAG, "Trying to Insert Records");
        //returns -1 when insertion failed
        if (db.insert(TABLE_NAME, null, cv) != -1)
            return true;
        return false;
    }

}
