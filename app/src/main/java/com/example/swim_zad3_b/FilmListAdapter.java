package com.example.swim_zad3_b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmListAdapter extends ArrayAdapter<Film> {

    private Context mContext;
    private int mResource;

    public FilmListAdapter( Context context, int resource,List<Film> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String Director = getItem(position).getDirector();
        String Title = getItem(position).getTitle();
        String Rating = getItem(position).getRating();
        String Colored = getItem(position).getColored();
        String Sound = getItem(position).getWithSound();


        //Film film = new Film(Title,Director,getItem(position).getR(),getItem(position).getC(),getItem(position).getS());

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.filmtitle_field);
        TextView director = (TextView) convertView.findViewById(R.id.director_field);
        TextView rating = (TextView) convertView.findViewById(R.id.rating_field);
        TextView color = (TextView) convertView.findViewById(R.id.color_field);
        TextView sound = (TextView) convertView.findViewById(R.id.sound_field);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        title.setText(Title);
        director.setText(Director);
        rating.setText(Rating);
        color.setText(Colored);
        sound.setText(Sound);

        return convertView;

    }
}
