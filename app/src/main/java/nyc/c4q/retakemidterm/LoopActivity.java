package nyc.c4q.retakemidterm;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by MarckemX on 12/6/17.
 */

public class LoopActivity {


    public static class MySyncTask extends AsyncTask<Integer, Integer, Integer> {

        int loopsCompleted = 0;
        static TextView partOneScreen;

        MySyncTask(TextView textView){
            partOneScreen = textView;
        }

        @Override
        protected void onPreExecute(){
            loopsCompleted = 0;
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for( int i = integers[0]; i < 100000; i++){
                loopsCompleted++;
                publishProgress(integers);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress){
            partOneScreen.setText("Loops completed: " + loopsCompleted);
        }

        @Override
        protected void onPostExecute(Integer result){
            partOneScreen.setText("Loops completed: " + loopsCompleted);
        }


    }
}
