package db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;

import model.Alarm;
import model.Note;


public class DatabaseController {
    private static final String TAG = "NotesTable";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mynote.db";




    public static final String TABLE_NOTES = "notes";

    public static final String KEY_NID = "nid";
    public static final String KEY_DATE = "date";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";







    public static final String TABLE_ALARMS = "alarms";

    public static final String KEY_AID = "aid";
    public static final String KEY_OLD_DATE = "old_date";
    public static final String KEY_ALARM_DATE = "alarm_date";
    public static final String KEY_TITLE_ALARM = "alarm_title";
    public static final String KEY_CONTENT_ALARM = "alarm_content";
    public static final String KEY_ALARM_IS_ON = "alarm_is_on";






    private String[] allNoteColumn = {
            KEY_NID,
            KEY_DATE,
            KEY_TITLE,
            KEY_CONTENT};

    private String[] allAlarmColumn = {
            KEY_AID,
            KEY_OLD_DATE,
            KEY_ALARM_DATE,
            KEY_TITLE_ALARM,
            KEY_CONTENT_ALARM,
            KEY_ALARM_IS_ON};





    public static final String CREATE_NOTE_TABLES = "CREATE TABLE " + TABLE_NOTES + "( "
            + KEY_NID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + KEY_DATE + " DATETIME, "
            + KEY_TITLE + " TEXT, "
            + KEY_CONTENT + " TEXT);";

    public static final String CREATE_ALARM_TABLES = "CREATE TABLE " + TABLE_ALARMS + "( "
            + KEY_AID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + KEY_OLD_DATE + " DATETIME, "
            + KEY_ALARM_DATE + " DATETIME, "
            + KEY_TITLE_ALARM + " TEXT, "
            + KEY_CONTENT_ALARM + " TEXT, "
            + KEY_ALARM_IS_ON + " INTEGER);";




    private Context context;
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;


    public DatabaseController(Context context) {
        this.context = context;
    }

    public DatabaseController open() throws android.database.SQLException {
        dbHelper = new MySQLiteHelper(this.context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() { dbHelper.close(); }


    // ADD VALUE TO TABLE
    public Note addNote(String title, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_DATE, "" + Calendar.getInstance().getTimeInMillis());
        contentValues.put(KEY_TITLE, title);
        contentValues.put(KEY_CONTENT, content);
        long id = (int) database.insert(TABLE_NOTES, null, contentValues);

        Cursor c = database.query(TABLE_NOTES,
                allNoteColumn, KEY_NID + " = " + id, null, null, null, null);
        c.moveToFirst();
        Note note = cursorToNote(c);
        c.close();
        return note;
    }

    public Alarm addAlarm(long oldDate, String title, String content, long alarmDate, int isAlarmOn) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_OLD_DATE, oldDate);
        contentValues.put(KEY_ALARM_DATE, alarmDate);
        contentValues.put(KEY_TITLE_ALARM, title);
        contentValues.put(KEY_CONTENT_ALARM, content);
        contentValues.put(KEY_ALARM_IS_ON, isAlarmOn);
        long id = (int) database.insert(TABLE_ALARMS, null, contentValues);

        Cursor c = database.query(TABLE_ALARMS,
                allAlarmColumn, KEY_AID + " = " + id, null, null, null, null);
        c.moveToFirst();
        Alarm alarm = cursorToAlarm(c);
        c.close();
        return alarm;
    }








    // GET TABLE
    public ArrayList<Note> getAllNotes() {
        ArrayList<Note> res = new ArrayList<Note>();

        Cursor cursor = database.query(TABLE_NOTES, allNoteColumn, null, null, null, null, null);
        for(cursor.moveToLast(); !cursor.isBeforeFirst(); cursor.moveToPrevious()) {
            Log.v(TAG, "FAILED HERE");
            Note note = cursorToNote(cursor);
            res.add(note);
        }
        cursor.close();
        return res;
    }

    public ArrayList<Alarm> getAllAlarm() {
        ArrayList<Alarm> res = new ArrayList<Alarm>();

        Cursor cursor = database.query(TABLE_ALARMS, allAlarmColumn, null, null, null, null, null);
        for(cursor.moveToLast(); !cursor.isBeforeFirst(); cursor.moveToPrevious()) {
            Log.v(TAG, "FAILED TO GET ALL ALARM");
            Alarm alarm = cursorToAlarm(cursor);
            res.add(alarm);
        }
        cursor.close();
        return res;
    }

    private Note cursorToNote(Cursor cursor) {
        Note note = new Note(
                cursor.getLong(0),
                cursor.getLong(1),
                cursor.getString(2),
                cursor.getString(3));
        return note;
    }

    private Alarm cursorToAlarm(Cursor cursor) {
        Alarm alarm = new Alarm(
                cursor.getLong(0),
                cursor.getLong(1),
                cursor.getLong(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5)
        );
        return alarm;
    }


    // DELETE
    public long deleteNote(long id) {
        return database.delete(TABLE_NOTES, KEY_NID + " = " + id, null);
    }

    public long deleteAlarm(long id) {
        return database.delete(TABLE_ALARMS, KEY_AID + " = " + id, null);
    }




    // UPDATE TABLE
    public long updateNote(long id, String title, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TITLE, title);
        contentValues.put(KEY_CONTENT, content);
        contentValues.put(KEY_DATE, "" + Calendar.getInstance().getTimeInMillis());

        return database.update(TABLE_NOTES, contentValues, KEY_NID + " = " + id, null);
    }

    public long updateAlarm(long id, long oldDate, long alarmDate, String title, String content, int isAlarmOn) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_OLD_DATE, oldDate);
        contentValues.put(KEY_ALARM_DATE, alarmDate);
        contentValues.put(KEY_TITLE_ALARM, title);
        contentValues.put(KEY_CONTENT_ALARM, content);
        contentValues.put(KEY_ALARM_IS_ON, isAlarmOn);

        return database.update(TABLE_ALARMS, contentValues, KEY_AID + " = " + id, null);
    }











    private static class MySQLiteHelper extends SQLiteOpenHelper{

        MySQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_NOTE_TABLES);
            db.execSQL(CREATE_ALARM_TABLES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "onUpgrade: old version " + oldVersion + "--- new version: " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALARMS);
            onCreate(db);
        }
    }
}