package com.example.raffelwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timerSensor = new Timer();

        TimerTask taskProcessSensor = new TimerTask() {
            public void run() {
                boolean isWatered = false;
                double temp = tempGen();
                double humid = humidGen(isWatered);
                double pH = phGen();
                double lumin = luminGen();

                Date now = new Date();
                String current;
                TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
                current = now.toString();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Plants");

                Plants plants = new Plants(current, temp, humid, pH, lumin);
                reference.push().setValue(plants);

                Log.d("Debug", "Timestamp: " + current + ", Temp: "+ temp + ", Humid: " + humid + ", pH: " + pH + ", Lumin: " + lumin);
            }
        };
        timerSensor.schedule(taskProcessSensor, 0, 600000); // Get value every 10 minutes


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

    // Luminance Sensor Value Generator
    public double luminGen() {

        LocalTime time = LocalTime.now(ZoneId.of("Europe/Berlin"));

        Random lumin = new Random();
        double val = lumin.nextGaussian();

        int currentHour = time.getHour();

        if (currentHour >= 7 && currentHour < 17) {
            val = val * 90 + 535; // (SD: 90, Mean: 535)
        } else {
            val = val * 100 + 1200; // (SD: 100, Mean: 1200)
        }

        val = Double.parseDouble(new DecimalFormat("##.##").format(val));

        return val;
    }

    public boolean streakCount() {
        boolean isWatered
        if (isWatered = )
        return val;
    }
    public int toWater(boolean isWatered){
        isWatered = true;
        if
        int val = 10
    }



}