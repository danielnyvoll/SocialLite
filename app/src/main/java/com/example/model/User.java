package com.example.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class User {
    public String firstname;
    public String lastname;
    private String email;
    public ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<String> createdChallenges;
    private ArrayList<String> joinedChallenges;


    public User(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.createdChallenges = new ArrayList<>();
        this.joinedChallenges = new ArrayList<>();
        allUsers.add(this);
    }
    public User(){}
    public User getUser(String email){
        for (User x : allUsers){
            if(email.equals(x.getEmail())){
                return x;
            }
        }
        return null;
    }
    public HashMap<String,User> getAllUsers(){return getAllUsers();}
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getCreatedChallenges() {
        return createdChallenges;
    }

    public void setCreatedChallenges(ArrayList<String> createdChallenges) {
        this.createdChallenges = createdChallenges;
    }

    public ArrayList<String> getJoinedChallenges() {
        return joinedChallenges;
    }

    public void setJoinedChallenges(ArrayList<String> joinedChallenges) {
        this.joinedChallenges = joinedChallenges;
    }

    public void addJoined(String challengeId){
        joinedChallenges.add(challengeId);
    }

    public void removeJoined(String challengeId) {
        joinedChallenges.remove(challengeId);
    }

    public void addCreated(String challengeId){
        joinedChallenges.add(challengeId);
    }

    public void removeCreated(String challengeId) {
        joinedChallenges.remove(challengeId);
    }


}
