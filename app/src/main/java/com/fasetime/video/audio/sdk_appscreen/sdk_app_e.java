package com.fasetime.video.audio.sdk_appscreen;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fasetime.video.audio.sdk_main.sdk_main_c;
import com.fasetime.video.audio.R;
import com.ff.guide.mukesh_ads.pro_sdk_c;

import org.jetbrains.annotations.NotNull;

public class sdk_app_e extends RecyclerView.Adapter<sdk_app_e.MyHolder> {

    Activity context;
    int[] langs;
    pro_sdk_c transMainPref;


    public sdk_app_e(Activity context, int[] langs) {
        this.context = context;
        this.langs = langs;
        transMainPref = new pro_sdk_c(context);
    }


    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sdk_app_h, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        holder.imgCountry.setImageResource(langs[position]);
        holder.imgCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
                    context.startActivity(new Intent(context, sdk_app_i.class).putExtra("app_inter", true));
                } else if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
                    context.startActivity(new Intent(context, sdk_app_f.class).putExtra("app_inter", true));
                } else {
                    context.startActivity(new Intent(context, new sdk_main_c().activity_X).putExtra("app_inter", true));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return langs.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgCountry, imgCheck;


        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgCountry = itemView.findViewById(R.id.imgCountry);
            imgCheck = itemView.findViewById(R.id.imgCheck);

        }
    }
}
