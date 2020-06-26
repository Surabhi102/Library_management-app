package com.example.libhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libhub.Model.Result;
import com.example.libhub.remote.APIUtils;
import com.example.libhub.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edtusn;
    EditText edtpassword;
    Button btnlogin;
    private APIUtils ApiUtils;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtusn = (EditText) findViewById(R.id.edtusn);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        userService = ApiUtils.getUserService();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = edtusn.getText().toString();
                String password = edtpassword.getText().toString();
                if (validateLogin(usn, password)) {
                    //do login
                    dologin(usn, password);
                }
            }
        });

    }
    private boolean validateLogin(String usn, String password){
        if(usn == null || usn.trim().length() == 0){
            Toast.makeText(this, "Usn is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public  void dologin(String usn, String password){
        Call<Result> call = userService.login(usn,password);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                if(response.isSuccessful()){
                    Result resObj = response.body();
                    if(resObj.getMessage().equals("true")){
                        //login start main activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    }

