package com.amazingtheme.colorcaller.callertheme.categoryui.linearCategory.kpopCategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.amazingtheme.colorcaller.R;
import com.amazingtheme.colorcaller.callertheme.categoryui.DataClass;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AvtarAdapter extends BaseAdapter {
    private ArrayList<DataClass> dataList;
    private Context context;
    LayoutInflater layoutInflater;
    public AvtarAdapter(Context context, ArrayList<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.recycler_item, null);
        }
        ImageView gridImage = view.findViewById(R.id.gridImage);
//        TextView gridCaption = view.findViewById(R.id.gridCaption);
        Glide.with(context).load(dataList.get(i).getImageURL()).into(gridImage);
//        gridCaption.setText(dataList.get(i).getCaption());
        return view;
    }
}
