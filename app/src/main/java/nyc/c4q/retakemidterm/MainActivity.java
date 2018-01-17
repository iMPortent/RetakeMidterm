package nyc.c4q.retakemidterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView partOneScreen;
        Intent toLoginPage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            partOneScreen = findViewById(R.id.part_one_screen);
            LoopActivity.MySyncTask myTask = new LoopActivity.MySyncTask(partOneScreen);
            myTask.execute(90000);


            toLoginPage = new Intent(this, LoginPage.class);
            startActivity(toLoginPage);
        }

}

