package com.fasetime.video.audio.sdk_appscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fasetime.video.audio.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class sdk_app_g extends RecyclerView.Adapter<sdk_app_g.MyHolder> {

    Context context;
    ArrayList<sdk_app_j> loaned_F_Loan_MCS;
    sdk_app_a aakhoSpd_an_BV;
    String[] strings = new String[]{"au", "us", "gb", "ch", "ca"};

    public sdk_app_g(Context context, ArrayList<sdk_app_j> loaned_F_Loan_MCS, sdk_app_a aakhoSpd_an_BV) {
        this.context = context;
        this.loaned_F_Loan_MCS = loaned_F_Loan_MCS;
        this.aakhoSpd_an_BV = aakhoSpd_an_BV;
    }


    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sdk_app_g, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        holder.imgCountry.setImageResource(loaned_F_Loan_MCS.get(position).getResourceId());
        holder.imgCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loaned_F_Loan_MCS.get(position).getCode().equalsIgnoreCase("all")) {
                    aakhoSpd_an_BV.callback(strings[new Random().nextInt(4 - 0 + 1) + 0]);
                } else {
                    aakhoSpd_an_BV.callback(loaned_F_Loan_MCS.get(position).getCode());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return loaned_F_Loan_MCS.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgCountry;


        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgCountry = itemView.findViewById(R.id.imgCountry);

        }
    }
}
