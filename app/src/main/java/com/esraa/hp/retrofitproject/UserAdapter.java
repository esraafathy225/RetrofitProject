package com.esraa.hp.retrofitproject;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class UserAdapter extends ArrayAdapter<Post> {

    public UserAdapter(@NonNull Context context, @NonNull ArrayList<Post> posts) {
        super(context, 0,posts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
        TextView name=convertView.findViewById(R.id.txt1);
        TextView likes=convertView.findViewById(R.id.txt2);
        ImageView profileImage=convertView.findViewById(R.id.img);

        Post post=getItem(position);
        name.setText(post.getUser().getName());
        likes.append(" "+post.getLikes());
        Glide.with(getContext()).load(post.getUser().getProfileImage().getMedium()).into(profileImage);
        return convertView;
    }
}
