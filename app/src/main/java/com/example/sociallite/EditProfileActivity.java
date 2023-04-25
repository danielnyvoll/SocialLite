package com.example.sociallite;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.model.User;
import com.example.service.FirebaseDBService;
import com.google.firebase.auth.FirebaseAuth;


public class EditProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    FirebaseDBService db = new FirebaseDBService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);


        String email = mAuth.getCurrentUser().getEmail();
        User currentUser = db.getUser(mAuth.getCurrentUser().getEmail());
        String firstname = currentUser.getFirstname();
        String lastname = currentUser.getLastname();

        EditText editFirstName = findViewById(R.id.editFirstName);
        EditText editLastName = findViewById(R.id.editLastName);

        editFirstName.setText(firstname);
        editLastName.setText(lastname);


        Button confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(view -> {
            if (TextUtils.isEmpty(editFirstName.getText().toString())) {
                editFirstName.setError("First Name cannot be empty");
                editFirstName.requestFocus();
            }
            if (TextUtils.isEmpty(editLastName.getText().toString())){
                editLastName.setError("Last Name cannot be empty");
                editLastName.requestFocus();
            }
            else {
                currentUser.setFirstname(editFirstName.getText().toString());
                currentUser.setLastname(editLastName.getText().toString());
                db.updateUser(currentUser);
                startActivity(new Intent(EditProfileActivity.this,MyProfileActivity.class));
            }
        });

        Button profileButton = findViewById(R.id.cancel);
        profileButton.setOnClickListener(view -> {
            startActivity(new Intent(EditProfileActivity.this,MyProfileActivity.class));;
        });



    }
}
