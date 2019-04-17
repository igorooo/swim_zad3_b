package com.example.swim_zad3_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookListAdapter extends ArrayAdapter<Book> {

    private Context mContext;
    private int mResource;


    public BookListAdapter( Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String Author = getItem(position).getAuthor();
        String Title = getItem(position).getTitle();
        String Type = getItem(position).getType();



        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.booktitle_field);
        TextView author = (TextView) convertView.findViewById(R.id.author_field);
        TextView type = (TextView) convertView.findViewById(R.id.type_field);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        title.setText(Title);
        author.setText((String)Author);
        type.setText((String)(Type));

        return convertView;

    }
}
