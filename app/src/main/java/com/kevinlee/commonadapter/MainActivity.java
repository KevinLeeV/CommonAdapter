package com.kevinlee.commonadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.kevinlee.commonadapter.commonadapter.CommonAdapter;
import com.kevinlee.commonadapter.commonadapter.ViewHolder;
import com.kevinlee.commonadapter.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lv;
    private List<Bean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setContent("今天的天气真正好啊，好想出去玩啊！" + i);
            bean.setRedId(R.drawable.ic_launcher);
            bean.setTitle("天气变冷了");
            mList.add(bean);
        }

    }

    /**
     * 初始化View
     */
    private void initViews() {
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new CommonAdapter<Bean>(MainActivity.this, R.layout.list_item_layout, mList) {
            @Override
            public void convert(ViewHolder holder, Bean bean, int position) {
                holder.setImageResource(R.id.iv, R.drawable.ic_launcher)
                        .setTextWithTextView(R.id.tv_title, bean.getTitle())
                        .setTextWithTextView(R.id.tv_content, bean.getContent());
            }
        });
    }


}
