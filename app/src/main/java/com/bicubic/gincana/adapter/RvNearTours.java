package com.bicubic.gincana.adapter;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bicubic.gincana.R;
import com.bicubic.gincana.activity.TourDetailActivity;
import com.bicubic.gincana.helper.CircleTransform;
import com.bicubic.gincana.model.NearTour;
import com.bicubic.gincana.widget.CustomTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by admin on 07-Dec-16.
 */

public class RvNearTours extends RecyclerView.Adapter<RvNearTours.ViewHolder> {

    static List<NearTour.ResponseBean.TourDataBean> nearTourList;
    static Context context;

    public RvNearTours(List<NearTour.ResponseBean.TourDataBean> nearTourList, Context context) {
        this.nearTourList = nearTourList;
        this.context= context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.near_tour_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_title.setText(nearTourList.get(position).getSTourName());
        holder.tv_desc.setText(nearTourList.get(position).getSShortDescription());

        Picasso.with(context).load(nearTourList.get(position).getIImageData()).transform(new CircleTransform()).into(holder.img_tour);

    }

    @Override
    public int getItemCount() {
        return nearTourList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout rel_main;
        LinearLayout lin_download;
        CustomTextView tv_title, tv_desc;
        ImageView img_tour;

        public ViewHolder(View itemView) {
            super(itemView);

            rel_main = (RelativeLayout) itemView.findViewById(R.id.rel_main);
            lin_download = (LinearLayout) itemView.findViewById(R.id.lin_download);
            tv_title = (CustomTextView) itemView.findViewById(R.id.tv_title);
            tv_desc = (CustomTextView) itemView.findViewById(R.id.tv_desc);
            img_tour = (ImageView) itemView.findViewById(R.id.img_tour);

            rel_main.setOnClickListener(this);
            lin_download.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.rel_main:

                    Intent intent = new Intent(context, TourDetailActivity.class);
                    Log.i(TAG, "onClick: tourid : "+nearTourList.get(getAdapterPosition()).getTourID());
                    intent.putExtra("tourid",""+nearTourList.get(getAdapterPosition()).getTourID());
                    context.startActivity(intent);

                    break;
                case R.id.lin_download:

                    Toast.makeText(context, "Download click", Toast.LENGTH_SHORT).show();

                    break;
            }

        }
    }


}
