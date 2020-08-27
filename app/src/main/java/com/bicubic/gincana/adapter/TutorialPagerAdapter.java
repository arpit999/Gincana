package com.bicubic.gincana.adapter;

import android.content.Context;
import android.os.Parcelable;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bicubic.gincana.R;
import com.bicubic.gincana.widget.CustomTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05-Dec-16.
 */

public class TutorialPagerAdapter extends PagerAdapter {


    private ArrayList<Integer> IMAGES;
    private List<String> IntroTitle;
    private List<String> IntroDesc;

    private LayoutInflater inflater;
    private Context context;

    public TutorialPagerAdapter(Context context, ArrayList<Integer> IMAGES) {
        this.context = context;
        this.IMAGES = IMAGES;
        inflater = LayoutInflater.from(context);

    }


    public TutorialPagerAdapter(ArrayList<Integer> IMAGES, List<String> introTitle, List<String> introDesc, Context context) {
        this.IMAGES = IMAGES;
        this.IntroTitle = introTitle;
        this.IntroDesc = introDesc;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return IMAGES.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.tutorial_pager_item, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);
        final CustomTextView tv_intro_title = (CustomTextView) imageLayout
                .findViewById(R.id.tv_intro_title);
        final CustomTextView tv_intro_desc = (CustomTextView) imageLayout
                .findViewById(R.id.tv_intro_desc);

        tv_intro_title.setText(IntroTitle.get(position));
        tv_intro_desc.setText(IntroDesc.get(position));
        imageView.setImageResource(IMAGES.get(position));

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
