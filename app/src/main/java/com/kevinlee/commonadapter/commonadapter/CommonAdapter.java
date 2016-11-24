package com.kevinlee.commonadapter.commonadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ClassName:CommonAdapter
 * Description: 集成的万能适配器
 * Author:KevinLee
 * Date:2016/11/24 0024
 * Time:下午 4:05
 * Email:KevinLeeV@163.com
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected int layoutId;// 布局文件
    protected List<T> mList;// 数据集合
    private ViewHolder holder;

    public CommonAdapter(Context context, int layoutId, List<T> list) {
        this.mContext = context;
        this.layoutId = layoutId;
        this.mList = list;
    }

    /**
     * 设置数据
     *
     * @param list
     */
    public void setData(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList != null && mList.size() > 0)
            return mList.size();
        return 0;
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder = ViewHolder.getInstance(mContext, parent, convertView, layoutId, position);
        convert(holder, mList.get(position), position);
        return holder.getConvertView();
    }

    /**
     * 释放给用户的接口，用户可以在这个方法里进行操作
     *
     * @param holder
     * @param t
     */
    public abstract void convert(ViewHolder holder, T t, int position);

}
