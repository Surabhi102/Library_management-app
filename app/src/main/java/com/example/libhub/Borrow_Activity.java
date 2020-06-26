package com.example.libhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Borrow_Activity extends AppCompatActivity {
    EditText edtid;
    Button btnscan;
    Button btnlook;
    ListView listView;
    private IntentIntegrator qrScan;

    UserService userService;
    List<Book> list = new ArrayList<Book>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Borrow Book");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtid = (EditText) findViewById(R.id.edtid);
        btnscan = (Button) findViewById(R.id.btnscan);
        btnlook = (Button) findViewById(R.id.btnlook);
        listView = (ListView) findViewById(R.id.listview);
        userService = APIUtils.getUserService();
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false);


        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });

        btnlook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book b = new Book();
                String id = edtid.getText().toString();
                    //update user
                    getBookList(Integer.parseInt(id));

            }
        });

    }
    public void getBookList(int id){
        Call<List<Book>> call = userService.getBooks(id);
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(new BookAdapter(Borrow_Activity.this, R.layout.list_book, list));
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                edtid.setText(result.getContents());

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
