package com.example.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * This program provides various helper methods to be integrated with XML in an
 * effort to create an app that keeps track of two teams scores. 
 */
public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     * Called in each method where score is incremented.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     * Called in each method where score is incremented.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds one point to team A's score
     */
    public void plusOneTeamA(View view){
        teamAScore += 1;
        displayForTeamA(teamAScore);
    }

    /**
     * Adds two points to team A's score
     */
    public void plusTwoTeamA(View view){
        teamAScore += 2;
        displayForTeamA(teamAScore);
    }

    /**
     * Adds three points to team A's score
     */
    public void plusThreeTeamA(View view){
        teamAScore += 3;
        displayForTeamA(teamAScore);
    }

    /**
     * Adds one point to team B's score
     */
    public void plusOneTeamB(View view){
        teamBScore += 1;
        displayForTeamB(teamBScore);
    }

    /**
     * Adds two points to team B's score
     */
    public void plusTwoTeamB(View view){
        teamBScore += 2;
        displayForTeamB(teamBScore);
    }

    /**
     * Adds three points to team B's score
     */
    public void plusThreeTeamB(View view){
        teamBScore += 3;
        displayForTeamB(teamBScore);
    }

    /**
     * When reset button is pressed, scores are reset and new scores are displayed.
     */
    public void resetScore(View view){
        teamBScore = 0;
        teamAScore = 0;
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
    }
}
