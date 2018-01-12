package com.test.yosh.apptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ShowResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        Bundle bundle = getIntent().getExtras();

        // Recibiendo los datos enviados del formulario de ActivityMain
        if (bundle != null){
            String name = bundle.getString("name");
            String lastName = bundle.getString("lastName");
            String email = bundle.getString("email");
            String sex = bundle.getString("sex");
            boolean remember = bundle.getBoolean("remember");

            String fullName = name + " " + lastName;

            Log.i("Test", fullName + " email: " + email + " Sex: " + sex + " remember: " + remember);

            TextView message = findViewById(R.id.txtMessage);
            message.setText(fullName);
        }
    }
}
