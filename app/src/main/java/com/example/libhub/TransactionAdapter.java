package com.example.libhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.libhub.Model.Book;
import com.example.libhub.Model.Trans;

import java.util.List;

public class TransactionAdapter extends ArrayAdapter<Trans> {
    private Context context;
    private List<Trans> trans;

    public TransactionAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Trans> objects) {
        super(context, resource, objects);
        this.context = context;
        this.trans=objects;
    }
    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_trans, parent, false);

        TextView txtBookId = (TextView) rowView.findViewById(R.id.edtid);
        TextView txtBookName = (TextView) rowView.findViewById(R.id.edtname);
        TextView txtDueDate = (TextView) rowView.findViewById(R.id.edtduedate);
        Button btnAdd = (Button) rowView.findViewById(R.id.btnreturn);
        txtBookId.setText(String.format("#ID: %s", trans.get(pos).getBookid()));
        txtBookName.setText(String.format("BOOK NAME: %s", trans.get(pos).getName()));
        txtDueDate.setText(String.format("DueDate: %s", trans.get(pos).getDueDate()));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Return request is sent!", Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }
}
