package com.example.anchala.swiperefreshlayout;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends RecyclerView.Adapter<Custom_Adapter.MyViewHolder> {

    ArrayList PersonNames ;
    ArrayList PersonImages;
    Context context;


    public Custom_Adapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.PersonNames = personNames;
        this.PersonImages = personImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.recycler_layout, viewGroup, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
        
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.name.setText((CharSequence) PersonNames.get(i));
        myViewHolder.image.setImageResource((Integer) PersonImages.get(i));

    }

    @Override
    public int getItemCount() {
        return PersonImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;

        public MyViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.text);
            image = (ImageView) v.findViewById(R.id.image);
        }
    }
}
