package com.test.yosh.apptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtLastName;
    private EditText txtEmail;
    private CheckBox cbRemember;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get elements
        Button btnSend = findViewById(R.id.btnSend);
        RadioGroup rgSex = findViewById(R.id.rgSex);

        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmail = findViewById(R.id.txtEmail);
        cbRemember = findViewById(R.id.cbRemember);

        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbFemale:
                        sex = "Female";
                        break;
                    case R.id.rbMale:
                        sex = "Male";
                        break;
                    case R.id.rbOther:
                        sex = "Other";
                        break;
                }
            }
        });

        // Set onClickListener to btnSend
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String lastName = txtLastName.getText().toString();
                String email = txtEmail.getText().toString();
                boolean remember = cbRemember.isChecked();

                if (validateForm(name, lastName, email, sex)){
                    String message = name + " " + lastName;

                    Toast.makeText(getApplicationContext(), "Name: " + message, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "eMail: " + email, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Sex: " + sex, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Remember: " + remember, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.strERROR), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateForm(String name, String lastName, String email, String sex){
        boolean status = false;

        if (!name.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !sex.isEmpty()) {
            return true;
        }
        return status;
    }
}
