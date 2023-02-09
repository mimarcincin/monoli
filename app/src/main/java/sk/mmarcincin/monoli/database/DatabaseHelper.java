package sk.mmarcincin.monoli.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "monolidb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement = "CREATE TABLE PRAYERS (ID INTEGER PRIMARY KEY AUTOINCREMENT, 'NAME' TEXT, 'TEXT' TEXT, 'CATEGORY' INTEGER, 'ORDER' INTEGER, 'FAVORITE' BOOLEAN NOT NULL CHECK ('FAVORITE' IN (0, 1)), 'CUSTOM' BOOLEAN NOT NULL CHECK ('CUSTOM' IN (0, 1)), 'CREATEDAT' INTEGER)";
    db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
