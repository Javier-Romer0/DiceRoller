package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button rollButton;
    ImageView imageViewDice1;
    ImageView imageViewDice2;
    static final int[] diceImages = {
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.roll_button);
        imageViewDice1 = findViewById(R.id.result_imageviewdice1);
        imageViewDice2 = findViewById(R.id.result_imageviewdice2);
        resetButton = findViewById(R.id.reset_button);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have clicked the button", Toast.LENGTH_SHORT).show();
                rollButton.setText(R.string.dice_rolled_text);
                int dice1 = (int)Math.floor(Math.random()* 6 );
                int dice2 = (int)Math.floor(Math.random()* 6 );

                imageViewDice1.setImageResource(diceImages[dice1]);
                imageViewDice2.setImageResource(diceImages[dice2]);

                if (dice1 == 5 && dice2 == 5){
                    Toast toast = Toast.makeText(MainActivity.this, "JACKPOT!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollButton.setText(R.string.roll_button_text);
                imageViewDice1.setImageResource(R.drawable.empty_dice);
                imageViewDice2.setImageResource(R.drawable.empty_dice);
            }
        });

        imageViewDice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dice1 = (int)Math.floor(Math.random()* 6 );
                imageViewDice1.setImageResource(diceImages[dice1]);
            }
        });

        imageViewDice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dice2 = (int)Math.floor(Math.random()* 6 );
                imageViewDice2.setImageResource(diceImages[dice2]);
            }
        });
    }

}

