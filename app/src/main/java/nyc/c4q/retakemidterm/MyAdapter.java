package nyc.c4q.retakemidterm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MarckemX on 1/16/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<Integer> numbers;

    public MyAdapter(ArrayList<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.onBind(numbers.get(position));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }


}

