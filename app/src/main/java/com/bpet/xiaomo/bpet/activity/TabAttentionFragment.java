package com.bpet.xiaomo.bpet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bpet.xiaomo.bpet.R;


/**
 * Created by Stefan on 17/12/13.
 */

public final class TabAttentionFragment extends Fragment {


    private Activity mActivity;
    private Context mContext;
    private View newsLayout;

    //private BlurLayout mSampleLayout, mSampleLayout2, mSampleLayout3, mSampleLayout4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        mContext = getActivity();
        newsLayout = inflater.inflate(R.layout.fragment_attention, container,
                false);
        //newsLayout.setPadding(0,0,0,80);


        return newsLayout;
    }
}
