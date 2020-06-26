package com.example.libhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.libhub.Model.Book;
import com.example.libhub.remote.APIUtils;
import com.example.libhub.remote.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class search_activity extends AppCompatActivity {
EditText edttext;
Button btnsearch;
ListView listview;
    UserService userService;
    List<Book> list = new ArrayList<Book>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_activity);

        edttext = (EditText) findViewById(R.id.edttext);
        btnsearch = (Button) findViewById(R.id.btnsearch);
        listview = (ListView) findViewById(R.id.listview);
        userService = APIUtils.getUserService();
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book b = new Book();
                String book = edttext.getText().toString();
                searchbook(book);
            }
        });
    }
     public void searchbook(String book){
         Call<List<Book>> call = userService.searchbook(book);
         call.enqueue(new Callback<List<Book>>() {
             @Override
             public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                 if(response.isSuccessful()){
                     list = response.body();
                     listview.setAdapter(new BookAdapter(search_activity.this, R.layout.list_book, list));
                 }
                 else{
                     Toast.makeText(search_activity.this,"no found",Toast.LENGTH_LONG).show();
                 }
             }

             @Override
             public void onFailure(Call<List<Book>> call, Throwable t) {
                 Log.e("ERROR: ", t.getMessage());
             }
         });
     }

}
