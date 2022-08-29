package com.example.base2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText memail,mpassword;
    Button mloginbutton;

    FirebaseAuth fauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        memail =findViewById(R.id.email);
        mpassword=findViewById(R.id.password);
        mloginbutton=findViewById(R.id.loginbtn);
        fauth=FirebaseAuth.getInstance();
        mloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    mpassword.setError("password is required");
                    return;
                }
                if(password.length()<8)
                {
                    mpassword.setError("password should be >=8 char ");
                    return;
                }
                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "log in sussesful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "error"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}