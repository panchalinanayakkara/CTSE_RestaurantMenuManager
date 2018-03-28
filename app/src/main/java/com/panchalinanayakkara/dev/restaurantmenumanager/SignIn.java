package com.panchalinanayakkara.dev.restaurantmenumanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText username, password;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = (EditText)findViewById(R.id.edtUsername);
        password = (EditText)findViewById(R.id.edtPassword);

        ref = FirebaseDatabase.getInstance().getReference().child("User");
    }

        String pw;

        public void btnSignIn_Click(View view)
        {
            String userName = username.getText().toString();
            pw = password.getText().toString();

            if(ref.child(userName) != null) {
                ref.child(userName).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        if (pw.equals(user.getPassword())) {
                            Toast.makeText(SignIn.this, "Login Successful!", Toast.LENGTH_LONG).show();
                            Intent start = new Intent(SignIn.this, Home.class);
                            Common.currentUser = user;
                            startActivity(start);
                            finish();
                        } else {
                            Toast.makeText(SignIn.this, "Enter Correct Password!", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            else
            {
                Toast.makeText(SignIn.this, "User Doesn't Exist", Toast.LENGTH_LONG).show();
            }
        }
}
