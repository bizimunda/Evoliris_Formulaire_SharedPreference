package evoliris.com.evoliris_formulair_sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class LoginActivity extends ActionBarActivity {

    private EditText email, password;
    private CheckBox remember;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.et_login_email);
        password = (EditText) findViewById(R.id.et_login_password);
        remember = (CheckBox) findViewById(R.id.cb_login_rememberme);
        login = (Button) findViewById(R.id.btn_login_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                SharedPreferences.Editor editor = prefs.edit();

                if (remember.isChecked()) {
                    editor.putString("email", email.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("remember", remember.isChecked());
                } else {
                    editor.clear();
                }
                editor.apply();

                Intent mainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);

            }
        });

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);

        String email_ = sharedPreferences.getString("email", "");
        String password_ = sharedPreferences.getString("password", "");
        boolean remember_ = sharedPreferences.getBoolean("remember", false);

        email.setText(email_);
        password.setText(password_);
        remember.setChecked(remember_);
    }


}




