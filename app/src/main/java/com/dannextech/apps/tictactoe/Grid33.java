package com.dannextech.apps.tictactoe;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Grid33 extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = "TicTacToe Logs";

    Button cellr1c1,cellr1c2,cellr1c3,cellr2c1,cellr2c2,cellr2c3,cellr3c1,cellr3c2,cellr3c3,btnreset, btnViewScore;
    TextView tvPlayer;

    Boolean r1c1 = false,r1c2 = false,r1c3 = false,r2c1 = false,r2c2 = false,r2c3 = false,r3c1 = false,r3c2 = false,r3c3 = false;
    Boolean p2r1c1 = false,p2r1c2 = false,p2r1c3 = false,p2r2c1 = false,p2r2c2 = false,p2r2c3 = false,p2r3c1 = false,p2r3c2 = false,p2r3c3 = false;
    Boolean thereIsAWinner = false;
    String selectChar = null;
    String player1,player2;
    int playCount = 0,player1wins=0,player2wins=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid33);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Grid33.this);
        selectChar = preferences.getString("character","X");
        player1 = preferences.getString("player1","player1");
        player2 = preferences.getString("player2","Computer");

        cellr1c1 = findViewById(R.id.btnr1c1);
        cellr1c2 = findViewById(R.id.btnr1c2);
        cellr1c3 = findViewById(R.id.btnr1c3);

        cellr2c1 = findViewById(R.id.btnr2c1);
        cellr2c2 = findViewById(R.id.btnr2c2);
        cellr2c3 = findViewById(R.id.btnr2c3);

        cellr3c1 = findViewById(R.id.btnr3c1);
        cellr3c2 = findViewById(R.id.btnr3c2);
        cellr3c3 = findViewById(R.id.btnr3c3);

        btnreset = findViewById(R.id.btnReset);
        btnViewScore = findViewById(R.id.btnViewScore);

        tvPlayer = findViewById(R.id.tvPlayer);

        Log.e(TAG, "onCreate: is called");
        tvPlayer.setText(player1);

        cellr1c1.setOnClickListener(this);
        cellr1c2.setOnClickListener(this);
        cellr1c3.setOnClickListener(this);

        cellr2c1.setOnClickListener(this);
        cellr2c2.setOnClickListener(this);
        cellr2c3.setOnClickListener(this);

        cellr3c1.setOnClickListener(this);
        cellr3c2.setOnClickListener(this);
        cellr3c3.setOnClickListener(this);

        btnViewScore.setOnClickListener(this);
        btnreset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "onClick: is called");
        switch (v.getId()){
            case R.id.btnr1c1:
                cellr1c1.setText(selectChar);
                cellr1c1.setEnabled(false);
                playCount++;
                r1c1 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr1c2:
                cellr1c2.setText(selectChar);
                cellr1c2.setEnabled(false);
                playCount++;
                r1c2 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr1c3:
                cellr1c3.setText(selectChar);
                cellr1c3.setEnabled(false);
                playCount++;
                r1c3 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr2c1:
                cellr2c1.setText(selectChar);
                cellr2c1.setEnabled(false);
                playCount++;
                r2c1 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr2c2:
                cellr2c2.setText(selectChar);
                cellr2c2.setEnabled(false);
                playCount++;
                r2c2 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr2c3:
                cellr2c3.setText(selectChar);
                cellr2c3.setEnabled(false);
                playCount++;
                r2c3 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr3c1:
                cellr3c1.setText(selectChar);
                cellr3c1.setEnabled(false);
                playCount++;
                r3c1 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr3c2:
                cellr3c2.setText(selectChar);
                cellr3c2.setEnabled(false);
                playCount++;
                r3c2 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnr3c3:
                cellr3c3.setText(selectChar);
                cellr3c3.setEnabled(false);
                playCount++;
                r3c3 = true;
                checkWinner();

                if (player2=="Computer"){
                    if (playCount<5 && !thereIsAWinner){
                        if (selectChar =="X")
                            computerPlay("O");
                        else
                            computerPlay("X");
                        break;
                    }else{
                        Snackbar.make(v,"Grid is full",Snackbar.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnReset:
                resetBoard(v);
                break;
            case R.id.btnViewScore:
                showScore(v);
                break;
            default:
                Snackbar.make(v,"function not set",Snackbar.LENGTH_SHORT).show();
        }
        Log.e(TAG, "onClick: playcount is "+playCount);
    }

    private void showScore(final View view) {
        Log.e(TAG, "showScore: is called");
        final String[] choice = {"Crosses 'X'","Circles 'O'"};
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(Grid33.this, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(Grid33.this);
        }
        builder.setTitle("Select Character")
                .setMessage(player1+" has "+player1wins+" wins\n"+player2+"has"+player2wins+" wins")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void resetBoard(View v) {
        thereIsAWinner = false;
        cellr1c1.setText("");
        cellr1c2.setText("");
        cellr1c3.setText("");

        cellr1c1.setEnabled(true);
        cellr1c2.setEnabled(true);
        cellr1c3.setEnabled(true);

        r1c1 = false;
        r1c2 = false;
        r1c3 = false;

        p2r1c1 = false;
        p2r1c2 = false;
        p2r1c3 = false;

        cellr2c1.setText("");
        cellr2c2.setText("");
        cellr2c3.setText("");

        cellr2c1.setEnabled(true);
        cellr2c2.setEnabled(true);
        cellr2c3.setEnabled(true);

        r2c1 = false;
        r2c2 = false;
        r2c3 = false;

        p2r2c1 = false;
        p2r2c2 = false;
        p2r2c3 = false;

        cellr3c1.setText("");
        cellr3c2.setText("");
        cellr3c3.setText("");

        cellr3c1.setEnabled(true);
        cellr3c2.setEnabled(true);
        cellr3c3.setEnabled(true);

        r3c1 = false;
        r3c2 = false;
        r3c3 = false;

        p2r3c1 = false;
        p2r3c2 = false;
        p2r3c3 = false;


        Snackbar.make(v,"Grid Cleared",Snackbar.LENGTH_SHORT).show();
        btnViewScore.setEnabled(true);
        playCount = 0;
    }

    private void computerPlay(String type){
        //generate a random number from 0 - 10
        Random r = new Random();
        int cell = r.nextInt(10-1)+1;

        switch (cell){
            case 1:
                if (cellr1c1.getText().toString().equals("O")||cellr1c1.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr1c1.setText(""+type);
                    cellr1c1.setEnabled(false);
                    p2r1c1 = true;
                    checkWinner();
                }
                break;
            case 2:
                if (cellr1c2.getText().toString().equals("O")||cellr1c2.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr1c2.setText(""+type);
                    cellr1c2.setEnabled(false);
                    p2r1c2 = true;
                    checkWinner();
                }
                break;
            case 3:
                if (cellr1c3.getText().toString().equals("O")||cellr1c3.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr1c3.setText(""+type);
                    cellr1c3.setEnabled(false);
                    p2r1c3 = true;
                    checkWinner();
                }
                break;
            case 4:
                if (cellr2c1.getText().toString().equals("O")||cellr2c1.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr2c1.setText(""+type);
                    cellr2c1.setEnabled(false);
                    p2r2c1 = true;
                    checkWinner();
                }
                break;
            case 5:
                if (cellr2c2.getText().toString().equals("O")||cellr2c2.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr2c2.setText(""+type);
                    cellr2c2.setEnabled(false);
                    p2r2c2 = true;
                    checkWinner();
                }
                break;
            case 6:
                if (cellr2c3.getText().toString().equals("O")||cellr2c3.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr2c3.setText(""+type);
                    cellr2c3.setEnabled(false);
                    p2r2c3 = true;
                    checkWinner();
                }
                break;
            case 7:
                if (cellr3c1.getText().toString().equals("O")||cellr3c1.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr3c1.setText(""+type);
                    cellr3c1.setEnabled(false);
                    p2r3c1 = true;
                    checkWinner();
                }
                break;
            case 8:
                if (cellr3c2.getText().toString().equals("O")||cellr3c2.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr3c2.setText(""+type);
                    cellr3c2.setEnabled(false);
                    p2r3c2 = true;
                    checkWinner();
                }
                break;
            case 9:
                if (cellr3c3.getText().toString().equals("O")||cellr3c3.getText().toString().equals("X")){
                    computerPlay(type);
                }else{
                    cellr3c3.setText(""+type);
                    cellr3c3.setEnabled(false);
                    p2r3c3 = true;
                    checkWinner();
                }
                break;
            default:
                Log.e(TAG, "computerPlay: selected cell doesn't exist" );
        }

        Log.e(TAG, "computerPlay: Selected cell is "+cell);
    }

    private void checkWinner(){
        Log.e(TAG, "checkWinner: r1c1="+r1c1+"\nr1c2"+r1c2+"\nr1c3"+r1c3+"\nr2c1"+r2c1+"\nr2c2"+r2c2+"\nr2c3"+r2c3+"\nr3c1"+r3c1+"\nr3c2"+r3c2+"\nr3c3"+r3c3);

        if (r1c1 && r1c2 && r1c3){
            showWinner(1);
        }else if (r2c1 && r2c2 && r2c3){
            showWinner(1);
        }else if (r3c1 && r3c2 && r3c3){
            showWinner(1);
        }else if (r1c1 && r2c1 && r3c1){
            showWinner(1);
        }else if (r1c2 && r2c2 && r3c2){
            showWinner(1);
        }else if (r1c3 && r2c3 && r3c3){
            showWinner(1);
        }else if (r1c1 && r2c2 && r3c3){
            showWinner(1);
        }else if (r1c3 && r2c2 && r3c1){
            showWinner(1);
        }else if(p2r1c1 && p2r1c2 && p2r1c3){
            showWinner(2);
        }else if (p2r2c1 && p2r2c2 && p2r2c3){
            showWinner(2);
        }else if (p2r3c1 && p2r3c2 && p2r3c3){
            showWinner(2);
        }else if (p2r1c1 && p2r2c1 && p2r3c1){
            showWinner(2);
        }else if (p2r1c2 && p2r2c2 && p2r3c2){
            showWinner(2);
        }else if (p2r1c3 && p2r2c3 && p2r3c3){
            showWinner(2);
        }else if (p2r1c1 && p2r2c2 && p2r3c3){
            showWinner(2);
        }else if (p2r1c3 && p2r2c2 && p2r3c1){
            showWinner(2);
        }
    }

    private void showWinner(int player){
        thereIsAWinner = true;
        String winner;

        if (player==1){
            winner = player1;
            player1wins++;
        }else {
            winner = player2;
            player2wins++;
        }
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(Grid33.this, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(Grid33.this);
        }

        builder.setTitle("Winner")
                .setMessage("Congratulations "+winner+", You have won")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetBoard(findViewById(android.R.id.content));
                    }
                })
                .show();
    }


}
