package com.bicubic.gincana.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bicubic.gincana.R;

/**
 * Created by admin on 06-Dec-16.
 */

public class StartDialog extends DialogFragment implements View.OnClickListener{

    View rootView;
    ImageView img_close;
    Dialog dialog;

    public static StartDialog newInstance() {
        return new StartDialog();
    }

    public StartDialog() {
        // Empty constructor required for DialogFragment
    }

   /* @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        if (dialog!=null) {
            dialog = super.onCreateDialog(savedInstanceState);
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimatiion;
            return dialog;
        }else {
            return null;
        }
    }*/


    @Override
    public void onStart()
    {
        super.onStart();
        dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimatiion;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.start_dialog, container, false);

        img_close = (ImageView) rootView.findViewById(R.id.img_close);


        img_close.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.img_close:

                if (dialog!=null) {
                    dialog.cancel();
                }

                break;

        }
    }
}
