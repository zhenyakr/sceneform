package com.google.ar.sceneform.samples.gltf;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    //private List<String> titles;
    private List<Integer> images;
    //int images[];
    private List<Model> mModels;


    private OnModelClickListener mOnModelClickListener;

    Adapter(Context context, List<Model> models, OnModelClickListener onModelClickListener){
        this.layoutInflater = LayoutInflater.from(context);
        this.mModels = models;
        this.mOnModelClickListener = onModelClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_item_for_rv_models,parent,false);
        return new ViewHolder(view, mOnModelClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.image.setImageResource(images.get(position));
        holder.title.setText(mModels.get(position).getTitle());
        holder.image.setImageResource(mModels.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        //return titles.size();
        return mModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView image;

        OnModelClickListener onModelClickListener;

        public ViewHolder(@NonNull View itemView, OnModelClickListener onModelClickListener) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title_for_model);
            image = itemView.findViewById(R.id.image_view_for_online_courses);
            this.onModelClickListener = onModelClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onModelClickListener.onModelClick(getAdapterPosition());
        }
    }


    public interface OnModelClickListener{
        void onModelClick(int position);
    }
}
