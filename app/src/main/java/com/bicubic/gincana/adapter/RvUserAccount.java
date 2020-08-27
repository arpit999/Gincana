package com.bicubic.gincana.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bicubic.gincana.R;
import com.bicubic.gincana.helper.CircleTransform;
import com.bicubic.gincana.widget.CustomTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by admin on 08-Dec-16.
 */

public class RvUserAccount extends RecyclerView.Adapter<RvUserAccount.ViewHolder> {

    // Allows to remember the last item shown on screen
    private int lastPosition = -1;
    int DataType = 0;
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    Context context;

    public RvUserAccount(int dataType, ArrayList<Integer> imagesArray, Context context) {
        DataType = dataType;
        ImagesArray = imagesArray;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_account_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        holder.img_user_account.setImageResource(ImagesArray.get(position));

        Picasso.with(context).load(ImagesArray.get(position))
                .transform(new CircleTransform())
                .into(holder.img_user_account);
//        holder.tv_user_account.setText("Gincana");

//        // Here you apply the animation when the view is bound
//        setAnimation(holder.img_user_account, position);
    }

    @Override
    public int getItemCount() {
        return ImagesArray.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CustomTextView tv_user_account;
        ImageView img_user_account;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_user_account = (CustomTextView) itemView.findViewById(R.id.tv_user_account);
            img_user_account = (ImageView) itemView.findViewById(R.id.img_user_account);

        }
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


}
