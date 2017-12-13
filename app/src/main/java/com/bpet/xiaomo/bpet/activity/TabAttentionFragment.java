package com.bpet.xiaomo.bpet.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bpet.xiaomo.bpet.R;

/**
 * Created by Stefan on 17/12/13.
 */

public final class TabAttentionFragment extends Fragment {


    private Activity mActivity;
    private View newsLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        newsLayout = inflater.inflate(R.layout.fragment_attention, container,
                false);
        return newsLayout;
    }
}
