package com.example.githubapifetch;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<items> Items;
    Context context;

    private String numberCalculation(Long number) {
        if (number < 1000)
            return "" + number;
        int exp = (int) (Math.log(number) / Math.log(1000));
        return String.format("%.1f %c", number / Math.pow(1000, exp), "kMGTPE".charAt(exp-1));
    }

    public Adapter(List<items> Items)
    {
        this.Items = Items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        items items = Items.get(position);
        holder.owner.setText(items.getOwner().getLogin());
        holder.textdescription.setText(items.getDescription());
        holder.stars.setText(numberCalculation(Long.parseLong(items.getStargazers_count())));
        holder.textTvShow.setText(items.getName());
        Glide.with(context)
                .asBitmap()
                .load(items.getOwner().getAvatar_url())
                .into(holder.profileimg);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"The position is:"+position,Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textdescription;
        ImageView imgTvShow;
        TextView stars;
        TextView textTvShow;
        TextView owner;
        CardView cv;
        ImageView profileimg;

        public ViewHolder(View itemView)
        {
            super(itemView);
            profileimg = (ImageView) itemView.findViewById(R.id.profileimg);
            owner = (TextView) itemView.findViewById(R.id.owner);
            stars = (TextView) itemView.findViewById(R.id.stars);
            textTvShow = (TextView)itemView.findViewById(R.id.textTvshow);
            textdescription = (TextView) itemView.findViewById(R.id.textdescription);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }

    }
}
