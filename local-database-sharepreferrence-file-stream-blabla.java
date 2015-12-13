// ********************************************** play mp3 from local
MediaPlayer song = MediaPlayer.create(MainActivity.this, R.raw.FileName); 
song.start();

Stop: 
onPause(); 
song.pause();







// ********************************************** save and read file txt
// save
FileOutputStream fos = openFileOutput("yourFile.txt", Context.MODE_PRIVATE); 
fos.write(YourContentHere.getBytes());
fos.close();
//read
FileInputStream fis = openFileInput("yourFile.txt"); 
BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(fis))); 
String line = ""; 
while( (line = br.readLine()) != null ){ 
YourStringValue.append(line); 
YourStringValue.append("\n"); 
}











// ********************************************** sharedpreferences
//read
SharedPreferances sp = getPreferences(Context.MODE_PRIVATE);
int n = sp.getInt("Count", 0);
// write
SharedPreferances.Editor editor = sp.edit();
editor.putInt("Count", n);
editor.commit();








// **********************************************SQLite Database
//create Database class
public class Database extends SQLiteOpenHelper {
    public Database(Context context){
        super(context, "demo.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        QueryData("CREATE TABLE yourTableName (ID INTEGER PRIMARY KEY,
            NAME VARCHAR(100) NOT NULL)");
    }

    public Cursor GetData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}

// use Database class above
Database db = new Database(context);

@Override{
    protected void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(your main layout id);

        db.QueryData("DELETE FROM yourTableName");

        String s = "";
        Cursor result = db.GetData("SELECT * FROM yourTableName");
        while (result.moveToNext() ){
            s += result.getString(1);
        }
    }
}


