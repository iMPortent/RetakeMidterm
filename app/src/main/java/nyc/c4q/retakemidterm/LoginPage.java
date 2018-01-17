package nyc.c4q.retakemidterm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by MarckemX on 1/16/18.
 */

public class LoginPage extends AppCompatActivity {

        EditText userName, passWord;
        RadioButton rememberMe;
        Button loginButton;
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        String PREF_KEY = "my_key_to_pref";
        String REMEM_USER = "rememberedUser";
        String REMEM_PASS = "rememberedPass";
        Intent toListAct;


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.login_page);


            toListAct = new Intent(this, ListActivity.class);

            userName = findViewById(R.id.user_name);
            passWord = findViewById(R.id.pass_word);
            rememberMe = findViewById(R.id.remember_me);
            loginButton = findViewById(R.id.login_button);

            preferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);

            String savedUser = preferences.getString(REMEM_USER,null);
            String savedPass = preferences.getString(REMEM_PASS,null);
            if(savedUser != null && savedPass != null) {
                userName.setText(savedUser);
                passWord.setText(savedPass);
                rememberMe.setChecked(true);
            }

            editor = preferences.edit();

        }

        public void loginClick(View view){
            String userVal = userName.getText().toString();
            String passVal = passWord.getText().toString();
            Boolean isChecked = rememberMe.isChecked();

            String checkUser = preferences.getString(userVal,null);
            String checkPass = preferences.getString(passVal,null);
            if(checkUser == null && checkPass == null){

                if(isChecked){
                    editor.putString(REMEM_USER, userVal);
                    editor.putString(REMEM_PASS,passVal);
                    editor.commit();

                } else {
                    editor.putString(userVal, userVal);
                    editor.putString(passVal, passVal);
                    editor.commit();
                }
                startActivity(toListAct);
            } else {
                startActivity(toListAct);
            }
        }
}
