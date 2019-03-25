package com.cba533.cours5;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        setListener();
    }

    private void setListener(){
        findViewById(R.id.btn_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });
    }

    private void signUpUser(){
        EditText userEmail = findViewById(R.id.editText_signUpEmail);
        EditText password = findViewById(R.id.editText_signUpPassword);
        EditText passwordConfirm = findViewById(R.id.editText_signUpPasswordConfirm);
        /*if(password.getText().toString() != passwordConfirm.getText().toString()){
            Toast.makeText(this,"Passwords not matching", Toast.LENGTH_SHORT).show();
            return;
        }*/
        Toast.makeText(getApplicationContext(),userEmail.getText().toString() + " -- " + password.getText().toString(), Toast.LENGTH_SHORT).show();
        auth.createUserWithEmailAndPassword(userEmail.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendUserToMainActivity();
                }else{
                    Toast.makeText(getApplicationContext(),"Failed to signup", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendUserToMainActivity(){
        Intent sendToSignUpOrLogin = new Intent(this, MainActivity.class);
        startActivity(sendToSignUpOrLogin);
    }
}
