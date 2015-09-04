package pixzar.nujoyw.myrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    //Explicit
    private TextView userTextView;
    private Spinner deskSpinner;
    private ListView foodListView;

    private String userString,deskString,foodString,itemString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //bindWidget
        bindWidget();

        //ShowUser
        showUser();

        //CreateDeskSpinner
        createdeskSpinner();

    }//main Method

    private void createdeskSpinner() {
        final String[] strDeskArray = {"1","2","3","4","5"};
        //เอา array เข้า spinner ผ่าน adapter มาตรฐาน
        ArrayAdapter<String> deskAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strDeskArray);
        deskSpinner.setAdapter(deskAdapter);

        deskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deskString = strDeskArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                deskString = strDeskArray[0];
            }
        });

    }

    private void showUser() {
        userString = getIntent().getStringExtra("User");
        userTextView.setText(userString);
    }

    private void bindWidget() {
        userTextView = (TextView) findViewById(R.id.txtUser);
        deskSpinner = (Spinner) findViewById(R.id.spinner);
        foodListView = (ListView) findViewById(R.id.listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
