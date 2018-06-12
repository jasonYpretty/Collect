package com.atrue.collection;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    private EditText mAccount,mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mAccount = (EditText) findViewById(R.id.account);
        mPasswordView = (EditText) findViewById(R.id.Password);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnSettings = (Button) findViewById(R.id.btnSettings);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String Act = mAccount.getText().toString();
                String Pwd = mPasswordView.getText().toString();
                if(Act.equalsIgnoreCase("") && Pwd.equals("")){
                    Intent MainIntent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(MainIntent);
                   // Snackbar.make(view, R.string.sign_in_success,Snackbar.LENGTH_LONG).show();
                 Toast.makeText(LoginActivity.this,R.string.sign_in_success,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,R.string.sign_in_fail,Toast.LENGTH_LONG).show();
                }

            }
        });  //登陆的幼稚逻辑
        btnSettings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent MainIntent = new Intent(LoginActivity.this, SettingsActivity.class);
                startActivity(MainIntent);
              // Toast.makeText(LoginActivity.this, R.string.title_settings, Toast.LENGTH_LONG).show();
            }
        }); //登陆界面转跳至设置
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnPhone);
        fab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:"+"110");
                    intent.setData(data);
                            startActivity(intent);
                Snackbar.make(view, R.string.cellphone, Snackbar.LENGTH_LONG)
                        .show();

            }

        }); //跳转至电话界面

    }

}