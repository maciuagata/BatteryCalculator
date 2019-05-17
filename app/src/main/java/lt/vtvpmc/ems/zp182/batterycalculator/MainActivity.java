package lt.vtvpmc.ems.zp182.batterycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import java.text.DecimalFormat;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private TextView numberField;
    private TextView numbers;
    private Button convertId;
    private Button resetId;
    private TextView amper0;
    private TextView volt0;
    private TextView watt0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberField = (TextView) findViewById(R.id.numberField);
        numbers = (TextView) findViewById(R.id.numbers);
        convertId = (Button) findViewById(R.id.convertId);
        resetId = (Button) findViewById(R.id.resetId);
        volt0 = (TextView) findViewById(R.id.volt0);
        watt0 = (TextView) findViewById(R.id.watt0);
        amper0 = (TextView) findViewById(R.id.amper0);


        convertId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double userInputValue;
                double userInputValue1;

                try {
                    userInputValue = Double.parseDouble(numberField.getText().toString());
                    userInputValue1 = Double.parseDouble(numbers.getText().toString());
                } catch (Exception ex) {
                    userInputValue = 0;
                    userInputValue1 = 0;
                    Context context = getApplicationContext();
                    CharSequence text = "Įvesk skaičių!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


                if (userInputValue > 0) {

                    DecimalFormat df = new DecimalFormat("##.##");

                    volt0.setText(String.valueOf(df.format(userInputValue)));
                    amper0.setText(String.valueOf(df.format(userInputValue1 / userInputValue)));
                    watt0.setText(String.valueOf(df.format(userInputValue1)));
                }

            }
        });



        resetId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(null);
                numbers.setText(null);

                volt0.setText(R.string.volt0);
                volt0.setText(R.string.volt0);
                watt0.setText(R.string.watt0);
                amper0.setText(R.string.amper0);
            }
        });

    }
}