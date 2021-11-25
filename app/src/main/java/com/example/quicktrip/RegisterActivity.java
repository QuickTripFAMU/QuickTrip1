package com.example.quicktrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "RegisterActivity";
    private EditText setUsername;
    private EditText setPassword;
    private EditText etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setUsername = findViewById(R.id.setUsername);
        setPassword = findViewById(R.id.setPassword);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Button Listeners
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user1 = setUsername.getText().toString();
                String password = setPassword.getText().toString();
                String password2 = etPassword.getText().toString();

                if (!password.equals(password2)) {
                    Toast.makeText(RegisterActivity.this,"passwords does not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                registerUser(user1, password);

            }
        });
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void registerUser(String username, String password) {
        ParseUser user = new ParseUser();
        // set Username and Password
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(RegisterActivity.this, "Invalid sign up", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (e != null) {
                            Toast.makeText(RegisterActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        goMainActivity();

                    }
                });
            }
        });

    }

}
