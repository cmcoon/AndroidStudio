package com.example.securityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This basic security demonstrates passage of information between intents/activities
 * specifically in this case a user must enter the correct password to "unlock" the
 * app. The user can then lock and restart this process if desired.
 */
public class MainActivity extends AppCompatActivity {

    private final int CONFIG_REQUEST = 123; // Key between intents
    private boolean correctPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Run method to listen for button press which will start activity
        buttonListenerMethod();
    }

    // Could also handle in XML, will do that for second activity, makes cleaner code
    public void buttonListenerMethod(){
        Button button = (Button) findViewById(R.id.unlockButton);

        //Action listener for when button is pressed
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccessControlActivity();
            }
        });
    }

    // When button is pressed we start the next activity
    public void openAccessControlActivity(){
        Intent intent = new Intent(this, AccessControlActivity.class);
        startActivityForResult(intent, CONFIG_REQUEST);
    }

    // Gets booelean value returned from other method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CONFIG_REQUEST){
            if(resultCode == RESULT_OK){
                correctPassword = data.getExtras().getBoolean("correctPass");
                System.out.println(correctPassword);

                // If the correct password was entered we unlock the app
                if (correctPassword) {
                    TextView textView = findViewById(R.id.welcomeMessage);
                    textView.setText("The App is Unlocked");

                    Button button = (Button) findViewById(R.id.unlockButton);
                    button.setText("Lock");

                    //If button is pressed again, we restart entire app
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TextView textView = findViewById(R.id.welcomeMessage);
                            textView.setText("Welcome to the App! The App is LOCKED!");

                            // Need to reset correctPassword boolean value
                            correctPassword = false;

                            Button button = (Button) findViewById(R.id.unlockButton);
                            button.setText("Unlock");

                            // Start password entry activity again
                            buttonListenerMethod();
                        }
                    });
                }
            }
        }
    }
}
