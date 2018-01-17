package nyc.c4q.retakemidterm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MarckemX on 1/16/18.
 */

public class MultiplierFragment extends Fragment {

    TextView multipliedNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.multiplier_layout,container,false);

        Bundle bundle =  getArguments();

        multipliedNumber = view.findViewById(R.id.multiplied_number);

        multipliedNumber.setText(bundle.toString());
        alterNumber();
        return view;
    }

    public void alterNumber(){
        String numberStr = multipliedNumber.getText().toString();
        int number = (Integer.parseInt(numberStr)*10)  ;
        multipliedNumber.setText( String.valueOf(number));

    }

}
