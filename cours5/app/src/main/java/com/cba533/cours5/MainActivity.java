package com.cba533.cours5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cba533.cours5.notification.NotificationService;
import com.cba533.cours5.notification.model.MessageModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore database;
    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setListener();
        //sendToSignUpOrLogin();
        UpdateUI();
    }

    private void setListener(){
        findViewById(R.id.btn_send_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    private void sendMessage(){
        EditText editTextMessage = findViewById(R.id.editText_message_content);
        MessageModel messageModel = new MessageModel(editTextMessage.getText().toString(), mAuth.getCurrentUser().getEmail());
        database.collection("Notification").add(messageModel)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(getApplicationContext(),"Message sent", Toast.LENGTH_LONG).show();
                    }
                });
        }

    private void UpdateUI(){
        if(currentUser == null){
            startService();
            sendToSignUpOrLogin();

        }else{
            //startService();
        }
    }

    private void sendUserToLoginActivity() {
        Intent Login = new Intent (this, SignInActivity.class);
        startActivity(Login);
    }

    private void sendToSignUpOrLogin(){
        Intent SignUpOrLogin = new Intent (this, SignUpOrLoginActivity.class);
        startActivity(SignUpOrLogin);
    }

    private void startService(){
        Intent serviceIntent = new Intent(this, NotificationService.class);
        ContextCompat.startForegroundService(this, serviceIntent);
    }
}
