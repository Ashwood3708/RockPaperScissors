package com.example.abdul.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rock,paper,scissor;
    TextView txtscore2;
    ImageView tvPlayer,tvCpu;
    int human = 0, cpu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = (Button) findViewById(R.id.btnRock);
        paper = (Button) findViewById(R.id.btnPaper);
        scissor = (Button) findViewById(R.id.btnScissors);

        tvCpu =(ImageView) findViewById(R.id.IVcpu);
        tvPlayer= (ImageView) findViewById(R.id.IVhuman);

        txtscore2 = (TextView)findViewById(R.id.t);
        txtscore2.setText(" Player: " + human+ "     Cpu :" + cpu );
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPlayer.setImageResource(R.drawable.r);
                String m = playTurn("rock");
                Toast.makeText(MainActivity.this,m,Toast.LENGTH_SHORT).show();
                txtscore2.setText(" Player: " + human+ "     Cpu :" + cpu );

            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPlayer.setImageResource(R.drawable.p);
                String m = playTurn("paper");
                Toast.makeText(MainActivity.this,m,Toast.LENGTH_SHORT).show();
                txtscore2.setText(" Player: " + human+ "     Cpu :" + cpu );
            }
        });
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPlayer.setImageResource(R.drawable.s);
                String m = playTurn("scissors");
                Toast.makeText(MainActivity.this, m, Toast.LENGTH_SHORT).show();
                txtscore2.setText(" Player: " + human+ "     Cpu :" + cpu );
            }
        });

    }

    public String playTurn(String playerC){

        String compstring = "";
        Random r = new Random();

        int cpuC = r.nextInt(3)+1;
        if(cpuC == 1){
            compstring = "rock";
        } else if(cpuC == 2){
            compstring = "paper";
        } else if (cpuC == 3){
            compstring = "scissors";
        }

        if(compstring.equals("rock")){
            tvCpu.setImageResource(R.drawable.r);
        }else if(compstring.equals("paper")){
            tvCpu.setImageResource(R.drawable.p);
        } else if (compstring.equals("scissors")){
            tvCpu.setImageResource(R.drawable.s);
        }


        if(playerC==compstring){
            return"draw game";
        } else if(playerC.equals("rock") &&  compstring.equals("scissors")){
            this.human++;
            return "rock beats scissors you win";

        }else if(playerC.equals("paper") &&  compstring.equals("rock")){
            this.human++;
            return "paper beats rock you win";

        }else if(playerC.equals("scissors") &&  compstring.equals("paper")){
            this.human++;
            return"scissors beats paper you win";

        }else if(compstring.equals("rock") &&  playerC.equals("scissors")){
            this.cpu++;
            return "rock beats scissors you lose";

        } else if(compstring.equals("paper") &&  playerC.equals("rock")){
            this.cpu++;
            return "paper beats rock you lose";

        } else if(compstring.equals("scissors") &&  playerC.equals("paper")){
            this.cpu++;
            return "scissors beats paper you lose";

        } else {
            return "";
        }

    }


}
