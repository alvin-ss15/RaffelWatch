package com.example.raffelwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();

        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                boolean isWatered = false;
                double temp = tempGen();
                double humid = humidGen(isWatered);
                double pH = phGen();
                double illumi = illumiGen();

                Log.d("Debug", "Temp: "+ temp + ", Humid: " + humid + ", pH: " + pH + ", Illumi: " + illumi);
                final handler.postDelayed(this,5000); // Execution Period: 5 mins

            }
        };
        handler.postDelayed(runnableCode,5000); // Execution Period: 5 mins

        Toast.makeText(MainActivity.this, "Firebase connection Success", Toast.LENGTH_LONG).show();
    }

    // Temperature Sensor Value Generator
    public double tempGen() {
        Random temp = new Random();
        double val = temp.nextGaussian();
        val = val * 3 + 20; // (SD: 3, Mean: 20)
        val = Double.parseDouble(new DecimalFormat("##.##").format(val));

        return val;

    }

    // Humidity Sensor Value Generator
    public double humidGen(boolean isWatered) {
        isWatered = false;
        Random humid = new Random();
        double val = humid.nextGaussian();
        // Before Watering
        if(isWatered == false) {
            val = val * 4 + 17.5; // (SD:4, Mean: 17.5)
            val = Double.parseDouble(new DecimalFormat("##.##").format(val));
        }
        // After Watering
        else {
            val = val * 6 + 30; // (SD:6, Mean: 30)
            val = Double.parseDouble(new DecimalFormat("##.##").format(val));
        }
        return val;
    }

    // pH Sensor Value Generator
    public double phGen() {
        Random ph = new Random();
        double val = ph.nextGaussian();
        val = val * 0.5 + 6.5; // (SD: 0.5, Mean: 6.5)
        val = Double.parseDouble(new DecimalFormat("##.##").format(val));

        return val;
    }

    // Illuminance Sensor Value Generator
    public double illumiGen() {

        LocalTime time = LocalTime.now(ZoneId.of("Europe/Paris"));

        Random illumi = new Random();
        double val = illumi.nextGaussian();

        int currentHour = time.getHour();

        if (currentHour >= 7 && currentHour < 17) {
            val = val * 90 + 535; // (SD: 90, Mean: 535)
        } else {
            val = val * 100 + 1200; // (SD: 100, Mean: 1200)
        }

        val = Double.parseDouble(new DecimalFormat("##.##").format(val));

        return val;
    }

    public void sendData() {

//        String dataFieldText = dataField.getText().
    }
}