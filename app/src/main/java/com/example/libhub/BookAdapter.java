package com.example.libhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.libhub.Model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private  Context context;
    private List<Book> book;

    public BookAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        this.context = context;
        this.book=objects;
    }


    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_book, parent, false);

        TextView txtBookId = (TextView) rowView.findViewById(R.id.txtBookId);
        TextView txtBookName = (TextView) rowView.findViewById(R.id.txtBookName);
        TextView txtAuthName = (TextView) rowView.findViewById(R.id.txtAuthName);
        Button btnAdd = (Button) rowView.findViewById(R.id.btnAddBook);
        txtBookId.setText(String.format("#ID: %s", book.get(pos).getBookid()));
        txtBookName.setText(String.format("BOOK NAME: %s", book.get(pos).getName()));
        txtAuthName.setText(String.format("Author NAME: %s", book.get(pos).getAuthor()));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Book Added Successfully", Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

}
