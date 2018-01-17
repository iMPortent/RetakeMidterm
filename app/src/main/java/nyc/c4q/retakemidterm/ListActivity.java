package nyc.c4q.retakemidterm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MarckemX on 1/16/18.
 */

public class ListActivity  extends AppCompatActivity {

    TextView emailHolder;
    public static String bundleKey = "selected";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        emailHolder = findViewById(R.id.email_holder);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.frag_holder, new RecyclerFragment());
        transaction.commit();
    }

    public void takeToMultiply(View view){
        MultiplierFragment multiplier = new MultiplierFragment();
        Bundle bundle = new Bundle();


        bundle.putString(bundleKey,((TextView) view).getText().toString());
        multiplier.setArguments(bundle);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.frag_holder, multiplier);
        transaction.commit();
    }

}
