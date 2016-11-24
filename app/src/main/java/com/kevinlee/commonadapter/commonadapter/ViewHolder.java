package com.kevinlee.commonadapter.commonadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * ClassName: ViewHolder
 * Description: 封装了Item中各种View的类
 * Author:KevinLee
 * Date:2016/11/24 0024
 * Time:上午 11:51
 * Email:KevinLeeV@163.com
 */
public class ViewHolder {

    // Item中各种View的集合，SparseArray类似于Map，key是Integer类型，但是效率比Map要高
    private SparseArray<View> mViews;
    //    private static ViewHolder holder;
    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, ViewGroup parent, int layoutId) {
        mContext = context;
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        // 每new一次都要创建一个新的集合
        mViews = new SparseArray<>();
        mConvertView.setTag(this);
    }

    public static ViewHolder getInstance(Context context, ViewGroup parent, View convertView, int layoutId, int position) {

        if (convertView == null)
            return new ViewHolder(context, parent, layoutId);
        else {
            ViewHolder holder = (ViewHolder) convertView.getTag();

            return holder;
        }
    }

    /**
     * 通过view的id获取View
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 获取convertView
     *
     * @return
     */
    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 为TextView设置文本
     *
     * @param viewId view的id
     * @param text   文本信息
     * @return ViewHolder是为了实现链式代码
     */
    public ViewHolder setTextWithTextView(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为View设置背景图
     *
     * @param viewId view的id
     * @param resId  资源Id
     * @return ViewHolder是为了实现链式代码
     */
    public ViewHolder setBackgroundResource(int viewId, int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    /**
     * 为View设置背景色
     *
     * @param viewId view的id
     * @param color  颜色
     * @return ViewHolder是为了实现链式代码
     */
    public ViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 为ImageView设置前景图
     *
     * @param viewId view的id
     * @param url    图片地址
     * @return ViewHolder是为了实现链式代码
     */
    public ViewHolder setImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        Glide.with(mContext).load(url).skipMemoryCache(true).into(view);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId view的id
     * @param resId  资源Id
     * @return ViewHolder是为了实现链式代码
     */
    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId view的id
     * @param bitmap
     * @return ViewHolder是为了实现链式代码
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }


}
