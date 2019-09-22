package com.yusril.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FilmModel> films;

    public FilmAdapter(Context context) {
        this.context = context;
        films=new ArrayList<>();
    }

    public void setFilms(ArrayList<FilmModel> films) {
        this.films = films;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        FilmModel film = (FilmModel) getItem(i);
        viewHolder.bind(film);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(FilmModel  film) {
            txtName.setText(film.getName());
            txtDescription.setText(film.getDescription());
            imgPhoto.setImageResource(film.getPhoto());
        }
    }
}
