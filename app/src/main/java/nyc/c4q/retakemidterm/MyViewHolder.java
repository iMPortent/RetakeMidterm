package nyc.c4q.retakemidterm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import static nyc.c4q.retakemidterm.MainActivity.bundleKey;

/**
 * Created by MarckemX on 1/16/18.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView numberView;
    Context context;


    public MyViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        numberView = itemView.findViewById(R.id.number_item);
    }

    public void onBind(int num){
        numberView.setText(String.valueOf(num));
    }

    @Override
    public void onClick(View v) {
       int num = Integer.parseInt(((TextView)v).getText().toString());
        Bundle bundle = new Bundle();
        MultiplierFragment frag = new MultiplierFragment();
        bundle.putInt(bundleKey,num);
        frag.setArguments(bundle);
        Intent intent = new Intent();
    }
}

