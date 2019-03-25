package com.cba533.cours5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        sendToSignUpOrLogin();

    }

    private void UpdateUI(){

    }

    private void sendToSignUpOrLogin(){
        Intent SignUpOrLogin = new Intent (this, SignUpOrLoginActivity.class);
        startActivity(SignUpOrLogin);
    }
}
