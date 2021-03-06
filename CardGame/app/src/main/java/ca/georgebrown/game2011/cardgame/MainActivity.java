package ca.georgebrown.game2011.cardgame;

import android.content.DialogInterface;
import android.media.Image;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Timer;

import javax.crypto.NullCipher;
//Anto Nanah Ji 1011103788
//Logan King 101100360
//12/03/2018
//CardGame

public class MainActivity extends AppCompatActivity {

    ImageButton image1;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    ImageButton image5;
    ImageButton image6;
    ImageButton image7;
    ImageButton image8;
    ImageButton image9;
    ImageButton image10;
    ImageButton image11;
    ImageButton image12;
    ImageButton image13;
    ImageButton image14;
    ImageButton image15;
    ImageButton image16;
    int Count = 0;
    int Score=0;
    String id_1,id_2;
    ImageButton id1;
    ImageButton id2;

    TextView textV;
    TextView scoreText;
    TextView timerText;
    int backImage;
    int []outCome= new int[16];
    int  rand1,rand2;

    int[] myImages = new int[]{R.drawable.card_1c, R.drawable.card_1d, R.drawable.card_1h, R.drawable.card_1s,R.drawable.card_2c,R.drawable.card_2d,R.drawable.card_2h,R.drawable.card_2s,R.drawable.card_3c,R.drawable.card_3d,
            R.drawable.card_3h,R.drawable.card_3s,R.drawable.card_4c,R.drawable.card_4d,R.drawable.card_4h,R.drawable.card_4s,R.drawable.card_5c,R.drawable.card_5d,R.drawable.card_5h,R.drawable.card_5s,
            R.drawable.card_6c, R.drawable.card_6d, R.drawable.card_6h, R.drawable.card_6s,R.drawable.card_7c,R.drawable.card_7d,R.drawable.card_7h,R.drawable.card_7s,R.drawable.card_8c,R.drawable.card_8d,
            R.drawable.card_8h,R.drawable.card_8s,R.drawable.card_9c,R.drawable.card_9d,R.drawable.card_9h,R.drawable.card_9s,R.drawable.card_10c,R.drawable.card_10d,R.drawable.card_10h,R.drawable.card_10s,
            R.drawable.card_11c,R.drawable.card_11d,
            R.drawable.card_11h,R.drawable.card_11s,R.drawable.card_12c,R.drawable.card_12d,R.drawable.card_12h,R.drawable.card_12s,R.drawable.card_13c,R.drawable.card_13d,R.drawable.card_13h,R.drawable.card_13s};
    ImageButton [] imageButtons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textV=(TextView) findViewById(R.id.textView);
        scoreText=(TextView) findViewById(R.id.textscore);
        timerText=(TextView) findViewById(R.id.texttimer) ;

        image1=(ImageButton) findViewById(R.id.image1);
        image2=(ImageButton) findViewById(R.id.image2);
        image3=(ImageButton) findViewById(R.id.image3);
        image4=(ImageButton) findViewById(R.id.image4);
        image5=(ImageButton) findViewById(R.id.image5);
        image6=(ImageButton) findViewById(R.id.image6);
        image7=(ImageButton) findViewById(R.id.image7);
        image8=(ImageButton) findViewById(R.id.image8);
        image9=(ImageButton) findViewById(R.id.image9);
        image10=(ImageButton) findViewById(R.id.image10);
        image11=(ImageButton) findViewById(R.id.image11);
        image12=(ImageButton) findViewById(R.id.image12);
        image13=(ImageButton) findViewById(R.id.image13);
        image14=(ImageButton) findViewById(R.id.image14);
        image15=(ImageButton) findViewById(R.id.image15);
        image16=(ImageButton) findViewById(R.id.image16);
        imageButtons=new ImageButton[]{image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,image14,image15,image16};

        backImage = R.drawable.cardback;

        scoreText.setText(String.valueOf(Score));

        new CountDownTimer(30000, 1000) { //Timer that displays 30 seconds to the user on finish game over.

            public void onTick(long millisUntilFinished) {
                timerText.setText("0 : " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerText.setText("Game Over!!!");
                restartGame();
            }
        }.start();
        for(int i=0;i<16;i+=2) //Loop that selects random cards from the deck of 52
        {
            int r=(int) Math.floor((Math.random()*52));//Generating rand number representing cards
            outCome[i]=r;                              //Populates outcome array
            outCome[i+1]=r;
        }
        for(int i=0;i<16;i++) //Loop that randomly selects where the cards are placed
        {
            rand1 = (int) Math.floor((Math.random() * 8)); //Generating nrand number

            rand2 = (int) Math.floor((Math.random() * 8) + 8);  //Generating nrand number

            int r=outCome[rand1];
            outCome[rand1]=outCome[rand2];
            outCome[rand2]=r;

        }

        image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {                      //when you press a card it does this
                    Count++;                                   //Count is upped by 1
                    textV.setText("Now pick another card..."); //displays txt to player
                    if (Count <= 2) {                          //if count is less then 2 count being cards selected do this
                        image1.setImageResource(myImages[outCome[0]]);
                        image1.setTag(String.valueOf(myImages[outCome[0]]));
                        new android.os.Handler().postDelayed(  //adds a delay before cards flip back over
                                new Runnable() {
                                    public void run() {
                                        checkID(image1, Count);
                                    }
                                },
                                500);
                    } else if (Count > 2) {
                        Count = 1; //Sets count back
                    }
                }
            });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image2.setImageResource(myImages[outCome[1]]);
                    image2.setTag(String.valueOf(myImages[outCome[1]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image2, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image3.setImageResource(myImages[outCome[2]]);
                    image3.setTag(String.valueOf(myImages[outCome[2]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image3, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }

            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image4.setImageResource(myImages[outCome[3]]);
                    image4.setTag(String.valueOf(myImages[outCome[3]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image4, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }

            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image5.setImageResource(myImages[outCome[4]]);
                    image5.setTag(String.valueOf(myImages[outCome[4]]));
                    checkID(image5, Count);new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                checkID(image5, Count);
                            }
                        },
                        500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image6.setImageResource(myImages[outCome[5]]);
                    image6.setTag(String.valueOf(myImages[outCome[5]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image6, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image7.setImageResource(myImages[outCome[6]]);
                    image7.setTag(String.valueOf(myImages[outCome[6]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image7, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image8.setImageResource(myImages[outCome[7]]);
                    image8.setTag(String.valueOf(myImages[outCome[7]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image8, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image9.setImageResource(myImages[outCome[8]]);
                    image9.setTag(String.valueOf(myImages[outCome[8]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image9, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image10.setImageResource(myImages[outCome[9]]);
                    image10.setTag(String.valueOf(myImages[outCome[9]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image10, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image11.setImageResource(myImages[outCome[10]]);
                    image11.setTag(String.valueOf(myImages[outCome[10]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image11, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image12.setImageResource(myImages[outCome[11]]);
                    image12.setTag(String.valueOf(myImages[outCome[11]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image12, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image13.setImageResource(myImages[outCome[12]]);
                    image13.setTag(String.valueOf(myImages[outCome[12]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image13, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image14.setImageResource(myImages[outCome[13]]);
                    image14.setTag(String.valueOf(myImages[outCome[13]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image14, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image15.setImageResource(myImages[outCome[14]]);
                    image15.setTag(String.valueOf(myImages[outCome[14]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image15, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });
        image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count++;
                textV.setText("Now pick another card...");
                if(Count<=2)
                {
                    image16.setImageResource(myImages[outCome[15]]);
                    image16.setTag(String.valueOf(myImages[outCome[15]]));
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    checkID(image16, Count);
                                }
                            },
                            500);
                }
                else if(Count >2)
                {
                    Count=1;
                }
            }
        });



    }
    void checkID(ImageButton id,int count) //compares ID's of buttons to find match
    {
        if(count==1)   //First card selected
        {
            id1 = id;
            id_1=(String)id.getTag();
        }
        if(count==2)  //Second card selected
        {
            id2 = id;
            id_2 = (String) id.getTag();
        }
        if(id1!=null&&id2!=null)         //id1 not null & id2 not null
        {
            if(id1.getId()!=id2.getId()) //if Ids don't match
            {
                if (id_1.equals(id_2))   //if Id's do match
                {
                    Score++;             //Adds to score
                    scoreText.setText("Score" + String.valueOf(Score)); //Shows score to player
                    Count = 0;           //Sets Count back to 0
                    textV.setText("Right!! Pick a card..."); //Asks to pick card
                    id1.setVisibility(View.INVISIBLE);
                    id2.setVisibility(View.INVISIBLE);
                }
                else                    //If wrong
                {
                    Count = 0;
                    textV.setText("Wrong! Pick again...");
                    id1.setImageResource(backImage); //Flips card back over
                    id2.setImageResource(backImage);
                }
                id1 = null;
                id2 = null;
                id_1 = null;
                id_2 = null;
            }
            else                                    //Resets
            {
                Count=0;
                id1.setImageResource(backImage);
                id2.setImageResource(backImage);
                id1 = null;
                id2 = null;
                id_1 = null;
                id_2 = null;
            }
        }
    }
    void restartGame()                           //Restarts game
    {
        AlertDialog.Builder restart= new AlertDialog.Builder(this);
        restart.setTitle("You Lose!!!");
        restart.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        restart.show();
    }
}