package com.example.libhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.libhub.Model.Book;
import com.example.libhub.Model.Trans;
import com.example.libhub.remote.APIUtils;
import com.example.libhub.remote.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReturnActivity extends AppCompatActivity {
    UserService userService;
    ListView listView;
    List<Trans> list = new ArrayList<Trans>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        listView = (ListView) findViewById(R.id.listView);
        userService = APIUtils.getUserService();
        Call<List<Trans>> call = userService.getreturn();
        call.enqueue(new Callback<List<Trans>>() {
            @Override
            public void onResponse(Call<List<Trans>> call, Response<List<Trans>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new TransactionAdapter(ReturnActivity.this, R.layout.list_book, list));
                }
            }

            @Override
            public void onFailure(Call<List<Trans>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }


        });
    }
    }

