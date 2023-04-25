package com.example.sociallite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Challenge;
import com.example.service.ChallengeAdapter;

import java.util.ArrayList;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Challenge> challenges = new ArrayList<>();
        //challenges.add(new Challenge("Walk 30km", "Lisa"));
        //challenges.add(new Challenge("Save 50k", "Thomas"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChallengeAdapter(getApplicationContext(),challenges));

        Button profileButton = findViewById(R.id.MyProfile);
        profileButton.setOnClickListener(view -> {
            startActivity(new Intent(OverviewActivity.this,MyProfileActivity.class));
        });

        Button joinButton = findViewById(R.id.Join);
        joinButton.setOnClickListener(view -> {
            startActivity(new Intent(OverviewActivity.this, JoinChallengeActivity.class)); //skal egt være joinActivity
        });

        Button createButton = findViewById(R.id.Create);
        createButton.setOnClickListener(view -> {
            startActivity(new Intent(OverviewActivity.this, CreateChallengeActivity.class));
        });

    }

}
