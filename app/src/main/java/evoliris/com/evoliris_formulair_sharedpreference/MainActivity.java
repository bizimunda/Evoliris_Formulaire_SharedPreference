package evoliris.com.evoliris_formulair_sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView email, password, remember;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.tv_main_email);
        password = (TextView) findViewById(R.id.tv_main_password);
        remember = (TextView) findViewById(R.id.tv_main_remember);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String Email_ = sharedPreferences.getString("email", "No Email");
        String Password_ = sharedPreferences.getString("password", "No Password");
        boolean RememberMe = sharedPreferences.getBoolean("rememberMe", false);

        email.setText(Email_);
        password.setText(Password_);
        remember.setEnabled(RememberMe);


    }


}
