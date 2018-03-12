package ca.georgebrown.game2011.cardgame;

import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
//Anto Nanah Ji 1011103788
//Logan King 101100360
//12/03/2018

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

    TextView TextV;



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

        TextV=(TextView) findViewById(R.id.textView);

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

        for(int i=0;i<16;i++)
        {
            imageButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GenerateCards();
                    TextV.setText("Now pick another card!");
                }
            });
        }


    }
    void GenerateCards()
    {
        int  rand1,rand2;
        int []outCome= new int[8];
        for(int i=0;i<8;i++)
        {
            outCome[i]=(int) Math.floor((Math.random()*52));//Generating nrand number
        }
        for(int j=0;j<16;j++)
        {

            rand1=(int) Math.floor((Math.random()*8)); //Generating nrand number
            rand2=(int) Math.floor((Math.random()*8)+7);//Generating nrand number

            imageButtons[rand1].setImageResource(myImages[outCome[j%8]]);
            imageButtons[rand2].setImageResource(myImages[outCome[j%8]]);

        }
    }
    void Timer()
    {

    }
}