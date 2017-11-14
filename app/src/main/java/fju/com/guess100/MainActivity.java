package fju.com.guess100;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static fju.com.guess100.R.id.secret;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int n = r.nextInt(100)+1;
    int min = 1;
    int max = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void findViews(View view){
        Button send = (Button) findViewById(R.id.send);
        EditText number = (EditText) findViewById(R.id.number);
        TextView secret = (TextView) findViewById(R.id.secret);
        TextView info = (TextView) findViewById(R.id.info);


        int s = Integer.parseInt(secret.getText().toString());
        if (s < min) {
            Toast.makeText(MainActivity.this, "請重新輸入一個更大的數字", Toast.LENGTH_SHORT).show();
        }
        if (s > max) {
            Toast.makeText(MainActivity.this, "請重新輸入一個更小的數字", Toast.LENGTH_SHORT).show();
        }
        if (s > n && s > min && s < max) {

            String q = String.valueOf(number);
            secret.setText(q);
        }
        if (s < n && s > min && s < max) {
            String a = String.valueOf(number);
            secret.setText(a);
        }
        if (s == n) {
            new AlertDialog.Builder(this)
                    .setTitle("結果")
                    .setMessage("bingo!!!")
                    .setNegativeButton("ok", null)
                    .show();
        }
        }
    }
