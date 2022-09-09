package com.example.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Button reset;
    Dialog dialog;
    ArrayList<Integer> player1=new ArrayList<>();
    ArrayList<Integer> player2=new ArrayList<>();
    boolean turn=false;
    String winner="None, Match Draw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("tjos aihdfasdf");
        t1=findViewById(R.id.imageview1);
        t2=findViewById(R.id.imageview2);
        t3=findViewById(R.id.imageview3);
        t4=findViewById(R.id.imageview4);
        t5=findViewById(R.id.imageview5);
        t6=findViewById(R.id.imageview6);
        t7=findViewById(R.id.imageview7);
        t8=findViewById(R.id.imageview8);
        t9=findViewById(R.id.imageview9);
        reset=findViewById(R.id.reset);
        dialog=new Dialog(MainActivity.this);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              t1.setText((turn)?"O":"X");
//              turn=!turn;
              System.out.println(turn);
              t1.setClickable(false);
              checkresult(turn,1);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText((turn)?"O":"X");
                System.out.println(turn);
                t2.setClickable(false);

                checkresult(turn,2);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t3.setText((turn)?"O":"X");
                System.out.println(turn);
                t3.setClickable(false);
                checkresult(turn,3);

            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t4.setText((turn)?"O":"X");
                System.out.println(turn);
                t4.setClickable(false);
                checkresult(turn,4);

            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t5.setText((turn)?"O":"X");
                System.out.println(turn);
                t5.setClickable(false);
                checkresult(turn,5);

            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t6.setText((turn)?"O":"X");
                System.out.println(turn);
                t6.setClickable(false);
                checkresult(turn,6);

            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t7.setText((turn)?"O":"X");
                System.out.println(turn);
                t7.setClickable(false);
                checkresult(turn,7);

            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t8.setText((turn)?"O":"X");
                System.out.println(turn);
                t8.setClickable(false);
                checkresult(turn,8);

            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t9.setText((turn)?"O":"X");
                System.out.println(turn);
                t9.setClickable(false);
                checkresult(turn,9);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              resetdata();
            }
        });
    }

    private void openDialog(String messagearg,String argtitle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(messagearg);
        builder.setTitle(argtitle);
        builder.setCancelable(false);
        builder.setPositiveButton("Done", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
            resetdata();

        });
        builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    private void resetdata() {
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
        t5.setText(null);
        t6.setText(null);
        t7.setText(null);
        t8.setText(null);
        t9.setText(null);
        t1.setClickable(true);
        t2.setClickable(true);
        t3.setClickable(true);
        t4.setClickable(true);
        t5.setClickable(true);
        t6.setClickable(true);
        t7.setClickable(true);
        t8.setClickable(true);
        t9.setClickable(true);
        player1.clear();
        player2.clear();
        winner="None, Match Draw";
        turn=false;
    }


    private boolean checkresult( boolean win,int i1) {
        ArrayList<Integer> player;
         winner=win?"Player O":"Player X";
        if (win){
            player1.add(i1);
            player=player1;
        }else{player2.add(i1);
        player=player2;}



        if (      (player.contains(1)&&player.contains(2)&&player.contains(3))
                ||(player.contains(4)&&player.contains(5)&&player.contains(6))
                ||(player.contains(7)&&player.contains(8)&&player.contains(9))
                ||(player.contains(3)&&player.contains(5)&&player.contains(7))
                ||(player.contains(1)&&player.contains(5)&&player.contains(9))
                ||(player.contains(1)&&player.contains(4)&&player.contains(7))
                ||(player.contains(2)&&player.contains(5)&&player.contains(8))
                ||(player.contains(3)&&player.contains(6)&&player.contains(9))
        ){
            System.out.println("Winner is"+winner);
            openDialog("Winner is"+winner,"Winner");
            return true;
        }else if (player.size()==5){
            openDialog("The Match is draw","DRAW");

        }

        turn=!turn;
        return false;
    }
}