package com.example.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }
    public MyAdapter(Context context, List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.recDevImage.setImageResource(dataList.get(position).getDeviceImage());
        holder.tvDevName.setText(dataList.get(position).getDeviceName());
        holder.tvDevNum.setText(dataList.get(position).getDeviceNum());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getBindingAdapterPosition()).getDeviceImage());
                intent.putExtra("Device Name", dataList.get(holder.getBindingAdapterPosition()).getDeviceName());
                intent.putExtra("Device Number", dataList.get(holder.getBindingAdapterPosition()).getDeviceNum());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tvDevName, tvDevNum;
    ImageView recDevImage;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        tvDevName = itemView.findViewById(R.id.recDevName);
        tvDevNum = itemView.findViewById(R.id.recDevNum);
        recDevImage = itemView.findViewById(R.id.recDevImage);
        recCard = itemView.findViewById(R.id.recCard);
    }
}

