package ai.issm.myanimations;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.ViewHolder> {
    Context context;
    ArrayList<ItemData> list;

    public RV_Adapter(ArrayList<ItemData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getImageUri())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {

            context.startActivity(new Intent(context, ImageViewActivity.class).putExtra("url", list.get(position).getImageUri().toString()),
                    ActivityOptions.makeSceneTransitionAnimation((Activity) context, holder.imageView, "image").toBundle());

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.carousel_image_view);
        }
    }

}

