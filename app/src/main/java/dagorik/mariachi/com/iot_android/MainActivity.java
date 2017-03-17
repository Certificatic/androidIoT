package dagorik.mariachi.com.iot_android;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.certificatic.cui.client.impl.DoorImpl;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actionButtonOpen(View view) {
        new OpenDoor().execute("Android App");
    }

    public void actionButtonClose(View view) {
        new CloseDoor().execute("Android App");
    }

    public void actionButtonAlarm(View view) {
        new AlarmDoor().execute("Android App");
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

