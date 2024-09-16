package com.example.lab02;

import static java.lang.Math.random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private final String REQUIRE = "Required!";
    EditText userName;
    EditText password;
    EditText confirmPassword;
    TextView signIn;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        signIn = findViewById(R.id.signIn);
        signUpButton = findViewById(R.id.signUpButton);

        signIn.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (userName.getText().toString().isEmpty()) {
            userName.setError(REQUIRE);
            return false;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError(REQUIRE);
            return false;
        }
        if (confirmPassword.getText().toString().isEmpty()) {
            confirmPassword.setError(REQUIRE);
            return false;
        }
        if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void signUp() {
        if (!checkInput()) {
            return;
        }
        Intent intent = new Intent(this, Ex3Activity.class);
        startActivity(intent);
        finish();
    }

    private void signIn() {
        Intent intent = new Intent(this, Ex3Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signUpButton) {
            signUp();
        } else if (view.getId() == R.id.signIn) {
            signIn();
        }
    }
}