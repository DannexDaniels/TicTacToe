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
                Snackbar.make(v,"Its not set yet",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.ib55:
                Snackbar.make(v,"Its not set yet",Snackbar.LENGTH_SHORT).show();
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
                            dialog.dismiss();
                            setPlayer1Name(v);
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
                        loadGame();
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
                        setCharacter(view);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putString("player2","Friend");
                        Snackbar.make(view,"name set to Player 1",Snackbar.LENGTH_SHORT).show();
                        setCharacter(view);
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

        builder.setTitle("Enter Player Name")
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
                            edit.putString("character","X");

                            Snackbar.make(view,"Character X is Set",Snackbar.LENGTH_SHORT).show();
                        }else {
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SelectGrid.this);
                            SharedPreferences.Editor edit = preferences.edit();
                            edit.putString("character","O");

                            Snackbar.make(view,"Character O is Set",Snackbar.LENGTH_SHORT).show();
                        }

                    }
                })
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loadGame();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
    }

    private void loadGame() {
        startActivity(new Intent(getApplicationContext(),Grid33.class));
    }
}
