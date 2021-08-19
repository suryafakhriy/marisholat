package com.surya.marisholat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<DataModel> listData;
    LayoutInflater inflater;
    Context context;

    public AdapterData(Context context, List<DataModel> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent, false);
        HolderData holderData = new HolderData(view);
        holderData.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Detail.class);
                i.putExtra("arab",listData.get(holderData.getAdapterPosition()).getArabic());
                i.putExtra("latin",listData.get(holderData.getAdapterPosition()).getLatin());
                i.putExtra("terjemah",listData.get(holderData.getAdapterPosition()).getTerjemahan());
                context.startActivity(i);
            }
        });
        return holderData ;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.tvNo.setText(listData.get(position).getId());
        holder.tvNama.setText(listData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvNo;
        TextView tvNama;
        LinearLayout view_container;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvId);
            tvNama = itemView.findViewById(R.id.tvName);
            view_container = itemView.findViewById(R.id.L_container);
        }
    }
}

