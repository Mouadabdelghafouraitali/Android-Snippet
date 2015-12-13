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












// Edittext with round-Corner
<?xml version="1.0" encoding="utf-8"?>
<!--  res/drawable/rounded_edittext.xml -->
<shape xmlns:android="http://schemas.android.com/apk/res/android"
android:shape="rectangle" android:padding="10dp">
 <solid android:color="#FFFFFF"/>
    <corners
     android:bottomRightRadius="15dp"
     android:bottomLeftRadius="15dp"
  android:topLeftRadius="15dp"
  android:topRightRadius="15dp"/>
</shape>








// Edittext with round-Corner
<?xml version="1.0" encoding="utf-8"?>
<!--  res/drawable/edittext_rounded_corners.xml -->
<selector xmlns:android="http://schemas.android.com/apk/res/android">

<item android:state_pressed="true" android:state_focused="true">
    <shape>
        <solid android:color="#FF8000"/>
        <stroke
            android:width="2.3dp"
            android:color="#FF8000" />
         <corners
            android:radius="15dp" />
    </shape>
</item>

<item android:state_pressed="true" android:state_focused="false">
    <shape>
        <solid android:color="#FF8000"/>
        <stroke
            android:width="2.3dp"
            android:color="#FF8000" />      
        <corners
            android:radius="15dp" />       
    </shape>
</item>

<item android:state_pressed="false" android:state_focused="true">
    <shape>
        <solid android:color="#FFFFFF"/>
        <stroke
            android:width="2.3dp"
            android:color="#FF8000" />  
        <corners
            android:radius="15dp" />                          
    </shape>
</item>

<item android:state_pressed="false" android:state_focused="false">
    <shape>
        <gradient 
            android:startColor="#F2F2F2"
            android:centerColor="#FFFFFF"
            android:endColor="#FFFFFF"
            android:angle="270"
        />
        <stroke
            android:width="0.7dp"                
            android:color="#BDBDBD" /> 
        <corners
            android:radius="15dp" />            
    </shape>
</item>

<item android:state_enabled="true">
    <shape>
        <padding 
                android:left="4dp"
                android:top="4dp"
                android:right="4dp"
                android:bottom="4dp"
            />
    </shape>
</item>

</selector>
