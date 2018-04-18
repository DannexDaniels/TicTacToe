package com.dannextech.apps.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SelectGrid extends AppCompatActivity implements View.OnClickListener{

    ImageView grid33, grid44, grid55;

    private static final String TAG = "SELECT GRID";

    String partner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_grid);

        grid33 = findViewById(R.id.ib33);
        grid44 = findViewById(R.id.ib44);
        grid55 = findViewById(R.id.ib55);

        grid33.setOnClickListener(this);
        grid44.setOnClickListener(this);
        grid55.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib33:
                setPlayers(v);

                break;
            case R.id.ib44:
                Snackbar.make(v,"Not Activated",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.ib55:
                Snackbar.make(v,"Not activated",Snackbar.LENGTH_SHORT).show();
                break;
            default:
                Log.e(TAG, "onClick: its not accounted for");
        }
    }

    private void setPlayers(final View v) {
        final String[] choice = {"Computer","Friend"};
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(SelectGrid.this, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(SelectGrid.this);
        }
        builder.setTitle("Who do you want to play with?")
                .setSingleChoiceItems(choice, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (choice[which].toString().equals("Computer")){
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("partner","Computer");
                            partner = "Computer";
                        }else {
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("partner","Friend");
                            dialog.dismiss();
                            setPlayer1Name(v);
                            setPlayer2Name(v);
                        }

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (partner=="Computer"){
                            setPlayer1Name(v);
                        }else{
                            setPlayer1Name(v);

                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
    }

    private void setPlayer2Name(final View view) {
        final EditText input = new EditText(SelectGrid.this);
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(SelectGrid.this, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(SelectGrid.this);
        }

        builder.setTitle("Enter Name of Player 2")
                .setView(input)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putString("player2",input.getText().toString());
                        loadGame(2);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putString("player2","Friend");
                    }
                })
                .show();
    }

    private void setPlayer1Name(final View view) {
        final EditText input = new EditText(SelectGrid.this);
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(SelectGrid.this, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(SelectGrid.this);
        }

        builder.setTitle("Enter Name for player 1")
                .setView(input)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putString("player1",input.getText().toString());
                        edit.putString("player2","Computer");
                        setCharacter(view);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putString("player1","You");
                        edit.putString("player2","Computer");
                        setCharacter(view);
                    }
                })
                .show();
    }

    private void setCharacter(final View view) {
        final String[] choice = {"Crosses 'X'","Circles 'O'"};
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(SelectGrid.this, android.R.style.Theme_Material_Dialog);
        } else {
            builder = new AlertDialog.Builder(SelectGrid.this);
        }
        builder.setTitle("Select Character")
                .setSingleChoiceItems(choice, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (choice[which].toString().equals("Crosses 'X'")){
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("character1","X");
                            edit.putString("character2","O");
                        }else {
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("character1","O");
                            edit.putString("character2","X");
                        }

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (partner=="Computer")
                            loadGame(1);
                        else
                            setPlayer2Name(view);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
    }

    private void loadGame(int x) {
        if (x==1)
            startActivity(new Intent(getApplicationContext(),Grid33.class));
        else
            startActivity(new Intent(getApplicationContext(),Grid33_2Players.class));
    }
}
