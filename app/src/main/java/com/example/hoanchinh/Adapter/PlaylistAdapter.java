package com.example.hoanchinh.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoanchinh.Activity.DanhsachbaihatActivity;
import com.example.hoanchinh.Model.PlaylistModel;
import com.example.hoanchinh.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder>{

    ArrayList<PlaylistModel> mangplaylist;
    View view;
    onClick click;


    public PlaylistAdapter(ArrayList<PlaylistModel> mangplaylist, onClick click) {
        this.mangplaylist = mangplaylist;
        this.click = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.dong_playlist,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        PlaylistModel playlist = mangplaylist.get(position);
        holder.txttenplaylist.setText(playlist.getTen());
        Picasso.get().load(playlist.getHinhPlaylist()).into(holder.imgplaylist);
    }

    @Override
    public int getItemCount() {
        return mangplaylist != null ? mangplaylist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgplaylist;
        TextView txttenplaylist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgplaylist = itemView.findViewById(R.id.imageviewplaylist);
            txttenplaylist = itemView.findViewById(R.id.textviewplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onclick(getAdapterPosition());
                }
            });
        }
    }
    public interface onClick{
        void onclick(int position);
    }
}


