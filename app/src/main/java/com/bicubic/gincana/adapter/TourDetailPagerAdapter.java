package com.bicubic.gincana.adapter;

import android.content.Context;
import android.os.Parcelable;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bicubic.gincana.R;
import com.bicubic.gincana.model.TourDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 05-Dec-16.
 */

public class TourDetailPagerAdapter extends PagerAdapter {

//    private ArrayList<Integer> IMAGES;
    List<TourDetail.ResponseBean.TourAllImageDataBean> allImageTour;

    private LayoutInflater inflater;
    private Context context;

    public TourDetailPagerAdapter(Context context, List<TourDetail.ResponseBean.TourAllImageDataBean> allImageTour) {
        this.context = context;
        this.allImageTour = allImageTour;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return allImageTour.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.tour_pager_item, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.img_tour);

        Picasso.with(context)
                .load(allImageTour.get(position).getIImageData())
                .fit()
                .into(imageView);

//        imageView.setImageResource(allImageTour.get(position).getIImageData());

        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
