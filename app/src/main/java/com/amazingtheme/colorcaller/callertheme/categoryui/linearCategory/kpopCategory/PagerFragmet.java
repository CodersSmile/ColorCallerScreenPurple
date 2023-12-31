package com.amazingtheme.colorcaller.callertheme.categoryui.linearCategory.kpopCategory;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.amazingtheme.colorcaller.R;

/**
 * Created by TomazWang on 2016/10/31.
 */

public class PagerFragmet extends Fragment {


    private static final String KEY_IMAGE = "key_image";
    private static final String KEY_PAGE_ID = "key_page_id";
    private String title;
    private TextView titleView;
    private int page_id;

    private static final int[] colors = new int[]{
            Color.CYAN,
            Color.WHITE,
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.GRAY,
            Color.YELLOW
    };

    public static PagerFragmet newInstance(String title, int page_id) {

        Bundle args = new Bundle();
        args.putString(KEY_IMAGE, title);
        args.putInt(KEY_PAGE_ID, page_id);
        PagerFragmet fragment = new PagerFragmet();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            this.title = bundle.getString(KEY_IMAGE);
            this.page_id = bundle.getInt(KEY_PAGE_ID);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page, container, false);
        this.titleView = (TextView) view.findViewById(R.id.txt_title);
        titleView.setText(title);

        view.setBackgroundColor(colors[page_id % colors.length]);

        return view;
    }


}
