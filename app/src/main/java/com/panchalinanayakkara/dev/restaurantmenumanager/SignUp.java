package com.panchalinanayakkara.dev.restaurantmenumanager;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    EditText username, name, password;
    private User user;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText)findViewById(R.id.edtUsername);
        name = (EditText)findViewById(R.id.edtName);
        password = (EditText)findViewById(R.id.edtPassword);

        user = new User();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("User");

    }

    public void btnSignUp_Click(View view)
    {
        user.setName(name.getText().toString());
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());

        ref.child(user.getUsername()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignUp.this, "User Created Successfully", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(SignUp.this, "Failed To Create User", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
