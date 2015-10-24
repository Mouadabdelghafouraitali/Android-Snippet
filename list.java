// ********************************************** Set image from local
img.setImageResource(id)






//********************************************** Set background
screen = (RelativeLayout) findViewById(screen id)
screen.setBackgroundResource(drawable id)







//********************************************** Download image from internet
URL url = new URL(link text);
Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
img.setImageBitmap(bmp);







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










// ********************************************** open new activity via intent
Intent intent = new Intent(context, second.class);
startActivity(intent);










// ********************************************** passing data between two intent
//send
Intent intent = new Intent(context, second.class);
intent.putExtra("name", stringValueHere);
startActivity(intent);
//get
Bundle bundle = new getIntent().getExtras();
if(bundle != null){
	stringValueHere = bundle.getString("name");
}








// // **********************************************  read text / html from internet
private class GetXML extends AsyncTask <String, Void, String>{
	@Override
	protected String doInBackground(String ...urls){
		String xml = null;
		xml = getXmlFromUrl("http://....");
		return xml;
	}
	protected void onPostExecute(String xml){
		XMLDOMParser parser = new XMLDOMParser();
		Document doc = parser.getDocument(xml);
		NodeList nodeList = doc.getElementsByTagName("tag name");

		String result = "";
		for(int i=0; i<nodeList.getLength(); i++){
			Element e = (Element) nodeList.item(i);
			result += parser.getValue(e, "name");
		}
		Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
	}
}









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









// ********************************************** Custom adapter
public class ListAdapter extends ArrayAdapter<YourArray> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<YourArray> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.YourCustomXmlLayout, null);
        }

        YourArray p = getItem(position);

        if (p != null) {
            TextView tv = (TextView) v.findViewById(R.id.YourTextviewId);
        }
        return v;
    }
}
ListAdapter customAdapter = new ListAdapter(this, R.layout.YourCustomXmlLayout, YourArray);









// ********************************************** Toast basic
Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
//
Toast toast = Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_SHORT);
toast.setGravity(Gravity.TOP, 0, 0); 
toast.show();
// add view to Toast
LayoutInflater inflater = getLayoutInflater();
View layout = inflater.inflate(R.layout.YourLayout, (ViewGroup)findViewById(R.id.YourLayoutId));
Toast t = new Toast(MainActivity.this);
t.setView(layout);
t.show(); 










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

// from internet
public void PlayMp3FromInternet(String url){
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }













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













// ********************************************** XMLDOMPARSER
// step 1: create class
public class XMLDOMParser {
    public Document getDocument(String xml)
    { 
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = factory.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            is.setEncoding("UTF-8");
            document = db.parse(is);
        }catch(ParserConfigurationException e)
        {
            Log.e("Error: ", e.getMessage(), e);
            return null;
        }
        catch (SAXException e) {
            Log.e("Error: ", e.getMessage(), e);
            return null;
        }
        catch(IOException e){
            Log.e("Error: ", e.getMessage(), e);
            return null;
        }
        return document;
    }
    public String getValue(Element item, String name)
    {
        NodeList nodes = item.getElementsByTagName(name);
        return this.getTextNodeValue(nodes.item(0));
    }
    private final String getTextNodeValue(Node elem) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}

// step 2: MainActivity
//      2.1: create method getXmlFromUrl(String urlString)
private String getXmlFromUrl(String urlString) {
        String xml = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(urlString);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

//	    2.2: create Async
private class GetXMLTask extends AsyncTask <String, Void, String> {
	@Override
	protected String doInBackground(String ...urls){
		String xml = null;
		xml = getXmlFromUrl("your url here");
		return xml;
	}
	protected void onPostExecute(String xml){
		XMLDOMParser parser = new XMLDOMParser();
		Document doc = parser.getDocument(xml);
		NodeList nodeList = doc.getElementsByTagName("your tag name");

		String result = "";
		for(int i=0; i<nodeList.getLength(); i++){
			Element e = (Element) nodeList.item(i);
			result += parser.getValue(e, "name");
		}
		// Use "result"
	}
}
//	    2.3: onCreate:
runOnUiThread(new Runnable(){
	@Override
	public void run(){
		new GetXMLTask().execute("http url...");
	}
})














// ********************************************** open your camera
Intent camaraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(camaraIntent, CAMERA_REQUEST);
// return your Bitmap
protected void onActivityResult(int requestCode, int resultCode, Intent data){
	if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
		Bitmap photo = (Bitmap) data.getExtras().get("data");
		img = (ImageView) findViewById(yourImageId);
		img.setImageBitmap(photo);
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












// ********************************************** send a request to web server
// use async!
private String makePostRequest() {
    HttpClient httpClient = new DefaultHttpClient();
    
    // URL of request reciever
    HttpPost httpPost = new HttpPost("http:... reciever");
    
    // params
    List nameValuePair = new ArrayList(2);
    nameValuePair.add(new BasicNameValuePair("number1", "111"));
    nameValuePair.add(new BasicNameValuePair("number2", "222"));
    
    //Encoding POST data
    try {
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

    String result = "";
    try {
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity);
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return result;
}










// ********************************************** read content from an URL from internet
private static String readFromURL(String theUrl)
{
    StringBuilder content = new StringBuilder();

    // many of these calls can throw exceptions, so i've just
    // wrapped them all in one try/catch statement.
    try
    {
        // create a url object
        URL url = new URL(theUrl);

        // create a urlconnection object
        URLConnection urlConnection = url.openConnection();

        // wrap the urlconnection in a bufferedreader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;

        // read from the urlconnection via the bufferedreader
        while ((line = bufferedReader.readLine()) != null)
        {
            content.append(line + "\n");
        }
        bufferedReader.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    return content.toString();
}










// ********************************************** imageView to byte array
public byte[] ImageView_To_Byte(){
        //Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.chomuc);
        BitmapDrawable drawable = (BitmapDrawable) imgvHinhSP.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
}


// byte array to imageView
Bitmap bitmap = BitmapFactory.decodeByteArray(BYTE[], 0, BYTE[].length);
imgv.setImageBitmap(bitmap);











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













// ********************************************** CHECK IF INTERNET IS AVAILABLE
private boolean haveInternet(){
	NetworkInfo info = ((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
	if (info==null || !info.isConnected()) {
		return false;
	}
	if (info.isRoaming()) {
	// here is the roaming option you can change it if you want to disable internet while roaming, just return false
		return true;
	}
	return true;
}











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











//********************************************************************************************
// COMBINE MULTIPLE BITMAP INTO ONE
// Example:
// Bitmap bm1=BitmapFactory.decodeResource(getResources(),.drawable.ic_launcher);
// ArrayList<Bitmap> a=new ArrayList<Bitmap>();
// a.add(bm1);
// a.add(bm1);
// a.add(bm1);
// combineImageIntoOne(a);

// Cobine Multi Image Into One
private Bitmap combineImageIntoOne(ArrayList<Bitmap> bitmap) {
	int w = 0, h = 0;
	for (int i = 0; i < bitmap.size(); i++) {
	if (i < bitmap.size() - 1) {
	w = bitmap.get(i).getWidth() > bitmap.get(i + 1).getWidth() ? bitmap.get(i).getWidth() : bitmap.get(i + 1).getWidth();
	}
	h += bitmap.get(i).getHeight();
}

Bitmap temp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(temp);
int top = 0;
for (int i = 0; i < bitmap.size(); i++) {
Log.d("HTML", "Combine: "+i+"/"+bitmap.size()+1);

top = (i == 0 ? 0 : top+bitmap.get(i).getHeight());
canvas.drawBitmap(bitmap.get(i), 0f, top, null);
}
return temp;
}
