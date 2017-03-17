package dagorik.mariachi.com.iot_android;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.certificatic.cui.client.impl.DoorImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOpen;
    private TextView tvGarage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpen = (Button) findViewById(R.id.btn_open);
        tvGarage = (TextView) findViewById(R.id.tv_estado_garage);

        btnOpen.setOnClickListener(this);
    }

//    public void actionButtonOpen(View view) {
//        new OpenDoor().execute("Android App");
//    }

    public void actionButtonClose(View view) {
        new CloseDoor().execute("Android App");
        Toast.makeText(this, "Se está cerrando el garage.", Toast.LENGTH_SHORT).show();
        tvGarage.setText("Garage cerrado.");
        tvGarage.setTextColor(Color.RED);
    }

    public void actionButtonAlarm(View view) {
        new AlarmDoor().execute("Android App");
        Toast.makeText(this, "Se encendió la alarma...", Toast.LENGTH_SHORT).show();
        tvGarage.setText("Alarma encendida.");
        tvGarage.setTextColor(Color.BLUE);
    }

    @Override
    public void onClick(View v) {
        new OpenDoor().execute("Android App");
        Toast.makeText(this, "Se está abriendo el garage.", Toast.LENGTH_SHORT).show();
        tvGarage.setText("Garage abierto.");
        tvGarage.setTextColor(Color.GREEN);

    }

    class OpenDoor extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            String string = strings[0];

            DoorImpl door = new DoorImpl();
            return door.open(string);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.i("MainActivity", "Open Door PostExecute Response: " + aBoolean);
        }
    }

    class CloseDoor extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            String string = strings[0];
            DoorImpl door = new DoorImpl();
            return door.close(string);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.i("MainActivity", "Close Door on PostExecute Response: " + aBoolean);
        }
    }

    class AlarmDoor extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            String string = strings[0];
            DoorImpl door = new DoorImpl();
            return door.alarm(string);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.i("MainActivity", "Alarm Door on PostExecute Response: " + aBoolean);
        }
    }
}

