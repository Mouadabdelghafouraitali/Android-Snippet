

// ********************************************** Touch to get x,y position on the screen
img = (ImageView) findViewById(image id);
img.setOnTouchListener(new View.OnTouchListener(){
	@Override
	public boolean onTouch(View v, MotionEvent event){
		float x = event.getX();
		float y = event.getY();
		String message = String.format("x=%.2f ; y=%.2f", x, y);
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		return false;
	}
});



// ********************************************** Animation
TranslateAnimation animation = new TranslateAnimation(0, 50, 0, 100);
animation.setDuration(6000);
animation.setFillAfter(false);

animation.setAnimationListener(new AnimationListener(){
	@Override
	public void onAnimationStart(Animation animation){

	}
	@Override
	public void onAnimationRepeat(Animation animation){

	}
	@Override
	public void onAnimationEnd(Animation animation){

	}
});
btnTimer.startAnimation(animation);





// **********************************************  Timer
new CountDownTimer(5000, 100){
	public void onTick(long millisUntilFinished){
		txt.setText("remain:" + millisUntilFinished / 100);
	}
	public void onFinish(){
		txt.setText("done!");
	}
}.start();













// ********************************************** show alert dialog
public void showAlertDialog(){ 
	AlertDialog.Builder builder = new Builder(context); 
	builder.setTitle("title"); 
	builder.setMessage("message"); 
	builder.setPositiveButton("OK", new OnClickListener() { 
		@Override 
		public void onClick(DialogInterface dialog, int which) { 
		// TODO Auto-generated method stub 
	} 
	}); 
	builder.create().show();
}





// ********************************************** listview and adapter
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, YourArrayHere); 
listView.setAdapter(adapter);





// ********************************************** set event for item on the listview
listView.setOnItemClickListener(new OnItemClickListener() {
	@Override 
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) { 
		// TODO Auto-generated method stub 
	Toast.makeText(getApplicationContext(), YourArrayHere[position], Toast.LENGTH_SHORT).show(); 
	} 
});










// **********************************************  parse value
Integer.parseInt("1987")
String.valueOf(10)





// ********************************************** play mp3 from internet and local
// from local
MediaPlayer song = MediaPlayer.create(MainActivity.this, R.raw.FileName); 
song.start();

Stop: 
onPause(); 
song.pause();







// ********************************************** checkbox
chk = (CheckBox) findViewById(id);
chk.setOnClickListener(new View.OnClickListener(){
	@Override
	public void onClick(View v){
		if(chk.isChecked() ){

		}
		else{

		}
	}
});






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





// ********************************************** check if 2 view is touch together
public boolean CheckCollision(View v1, View v2){
	Rect r1 = new Rect(v1.getLeft(), v1.getTop(), v1.getRight(), v1.getBottom());
	Rect r2 = new Rect(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getBottom());
	return r1.intersect(r2);
}






// ********************************************** get scren size of your device
Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay(); 
int width = display.getWidth(); 
int height = display.getHeight(); 
int ori = display.getOrientation();





// **********************************************Webview: Using url from internet or local - remember Internet permission in android manifest
wb = (WebView) findViewById(YourWebiewId);
wv.loadUrl("your url here");






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






// ********************************************** Async Task
@Override{
	protected void onCreate(Bundle savedInstancedState){
		super.onCreate(savedInstancedState);
		setContentView(your main layout id);
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				new YourAsync().execute("your url or any string here");
			}
		});

	}
}

class YourAsync extends AsyncTask <String, Integer, String> {
	protected String doInBackground(String ... args) {
		String html = "";
		// connect data source
		return html;
	}
	protected void onProgressUpdate(Integer ...a) {

	}
	protected void onPostExecute(String result) {

	}
}












// ********************************************** TEXT TO SPEED
TextToSpeech t1;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if(status != TextToSpeech.ERROR) {
                t1.setLanguage(Locale.ENGLISH);
                t1.speak("I've been lonely with you", TextToSpeech.QUEUE_FLUSH, null)
            }
        }
    });
}












// ********************************************** config parse connect
 // Add class MyApplication
public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "xxx", "yyy");
    }
}
// in android Manifest
android:name="MyApplication"









// ********************************************** scan for wireless networks
public class WifiTester extends Activity {
TextView mainText;
WifiManager mainWifi;
WifiReceiver receiverWifi;
List<ScanResult> wifiList;
StringBuilder sb = new StringBuilder();
 
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	mainText = (TextView) findViewById(R.id.mainText);
	mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	receiverWifi = new WifiReceiver();
	registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	mainWifi.startScan();
	mainText.setText("\\nStarting Scan...\\n");
}
 
public boolean onCreateOptionsMenu(Menu menu) {
	menu.add(0, 0, 0, "Refresh");
	return super.onCreateOptionsMenu(menu);
}
 
public boolean onMenuItemSelected(int featureId, MenuItem item) {
	mainWifi.startScan();
	mainText.setText("Starting Scan");
	return super.onMenuItemSelected(featureId, item);
}
 
protected void onPause() {
	unregisterReceiver(receiverWifi);
	super.onPause();
}
 
protected void onResume() {
	registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	super.onResume();
}
 
class WifiReceiver extends BroadcastReceiver {
	public void onReceive(Context c, Intent intent) {
		sb = new StringBuilder();
		wifiList = mainWifi.getScanResults();
		for(int i = 0; i < wifiList.size(); i++){
			sb.append(new Integer(i+1).toString() + ".");
			sb.append((wifiList.get(i)).toString());
			sb.append("\\n");
		}
		mainText.setText(sb);
		}
	}
}





// ********************************************** PROMPT USER INPUT WITH AN ALERTDIALOG
AlertDialog.Builder alert = new AlertDialog.Builder(this);
alert.setTitle("Title");
alert.setMessage("Message");
 
// Set an EditText view to get user input
final EditText input = new EditText(this);
alert.setView(input);
 
alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int whichButton) {
String value = input.getText();
// Do something with value!
}
});
 
alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int whichButton) {
// Canceled.
}
});
 
alert.show();


















// ********************************************** HANDLE TOUCH EVENTS (ONTOUCHEVENT)
public boolean onTouchEvent(MotionEvent event) {
	int eventaction = event.getAction();
 
	switch (eventaction) {
	case MotionEvent.ACTION_DOWN:
	// finger touches the screen
			break;
 
	case MotionEvent.ACTION_MOVE:
	// finger moves on the screen
			break;
 
	case MotionEvent.ACTION_UP:
	// finger leaves the screen
			break;
	}
 
// tell the system that we handled the event and no further processing is required
return true;
}








// ********************************************** DISABLE (INITIAL) SCREEN LOCK
KeyguardManager keyguardManager = (KeyguardManager)getSystemService(Activity.KEYGUARD_SERVICE);
KeyguardLock lock = keyguardManager.newKeyguardLock(KEYGUARD_SERVICE);
lock.disableKeyguard();
// in android manifest:
<uses-permission android:name="android.permission.DISABLE_KEYGUARD"></uses-permission>








// ********************************************** DOUBLE BACK PRESS TO EXIT
private static long back_pressed;
	@Override
	public void onBackPressed(){
		if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
		else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
	back_pressed = System.currentTimeMillis();
}

