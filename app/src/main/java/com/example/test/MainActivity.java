package com.example.test;//package com.example.test;


import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.example.test.BuildConfig;
import com.example.test.R;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the actual Java version
        String javaVersion = System.getProperty("java.version");


        // Get the app version
        String appVersion = BuildConfig.VERSION_NAME;


        // Get the Android version
        String androidVersion = android.os.Build.VERSION.RELEASE;


        // Get the phone model name
        String phoneModel = android.os.Build.MODEL;


        // Get the SHA-256 fingerprint of the key
        String sha256Fingerprint = getSHA256Fingerprint();

        String serial = ( "SERIAL: " + Build.SERIAL);
        String model = ("MODEL: " + Build.MODEL);
        String id = (" ID: " + Build.ID);
        String man = ("Manufacture: " + Build.MANUFACTURER);
        String brand = ("brand: " + Build.BRAND);
        String type = ("type: " + Build.TYPE);
        String user = ("user: " + Build.USER);
        String base = ("BASE: " + Build.VERSION_CODES.BASE);
        String INCR = ("INCREMENTAL " + Build.VERSION.INCREMENTAL);
        String sdl = ("SDK  " + Build.VERSION.SDK);
        String board = ("BOARD: " + Build.BOARD);
        String Brand = ("BRAND " + Build.BRAND);
        String host = ("HOST " + Build.HOST);

        TextView cpuModelText = findViewById(R.id.cpuModel_textview);
        cpuModelText.setText(serial+"\n"+model+"\n"+id+"\n"+man+"\n"+brand+"\n"+type+"\n"+user+"\n"+base+"\n"+sdl+"\n"+INCR+"\n"+board+"\n"+Brand+"\n"+host);

        // Display the versions on the screen
        TextView javaVersionText = findViewById(R.id.java_version_textview);
        javaVersionText.setText(String.format("Java Version: %s", javaVersion));

        TextView appVersionText = findViewById(R.id.app_version_textview);
        appVersionText.setText(String.format("App Version: %s", appVersion));

        TextView androidVersionText = findViewById(R.id.android_version_textview);
        androidVersionText.setText(String.format("Android Version: %s", androidVersion));

        TextView phoneModelText = findViewById(R.id.phone_model_textview);
        phoneModelText.setText(String.format("Phone Model: %s", phoneModel));

        TextView sha256FingerprintText = findViewById(R.id.fingerprint_textview);
        sha256FingerprintText.setText(String.format("SHA-256 Fingerprint: %s", sha256Fingerprint));



    }

    private String getSHA256Fingerprint() {
        try {
            // Generate SHA-256 fingerprint of the key
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(Base64.decode(BuildConfig.APPLICATION_ID, Base64.DEFAULT));
            byte[] digest = messageDigest.digest();
            StringBuilder fingerprint = new StringBuilder();
            for (byte b : digest) {
                fingerprint.append(String.format("%02x", b));
            }
            return fingerprint.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
