package techgravy.myapppportfolio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Button app1Button, app2Button, app3Button, app4Button, app5Button;
    @InjectView(R.id.textViewHeading)
    TextView textViewHeading;
    @InjectView(R.id.buttonApp1)
    Button buttonApp1;
    @InjectView(R.id.buttonApp2)
    Button buttonApp2;
    @InjectView(R.id.buttonApp3)
    Button buttonApp3;
    @InjectView(R.id.buttonApp4)
    Button buttonApp4;
    @InjectView(R.id.buttonApp5)
    Button buttonApp5;
    private String TAG = MainActivity.class.getSimpleName();
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_linkedin) {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            url = "https://in.linkedin.com/pub/adit-lal/1a/54/ba3";
            intent.setData(Uri.parse(url));

            PackageManager packageManager = MainActivity.this.getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Log.d(TAG, "No Intent available to handle action");
            }
            return true;
        } else if (id == R.id.action_github) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            url = "https://github.com/aldefy";
            intent.setData(Uri.parse(url));
            PackageManager packageManager = getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Log.d(TAG, "No Intent available to handle action");
            }
            return true;
        } else {
            return true;
        }
    }

    private void displayToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.buttonApp1)
    void app1Launch() {
        displayToast("This will launch the app : " + "Spotify Streamer");
    }

    @OnClick(R.id.buttonApp2)
    void app2Launch() {
        displayToast("This will launch the app : " + "Super Duo");
    }

    @OnClick(R.id.buttonApp3)
    void app3Launch() {
        displayToast("This will launch the app : " + "Build It Bigger");
    }

    @OnClick(R.id.buttonApp4)
    void app4Launch() {
        displayToast("This will launch the app : " + "XYZ Reader");
    }

    @OnClick(R.id.buttonApp5)
    void app5Launch() {
        displayToast("This will launch the app : " + "Capstone");
    }

}
