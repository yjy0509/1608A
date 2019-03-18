package com.example.week01.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.week01.R;
import com.example.week01.adapter.MainAdapter;
import com.example.week01.bean.Bean;
import com.example.week01.present.MyPresent;

/**
 * 用来更新UI
 *
 */
public class MainActivity extends AppCompatActivity implements IViewInterface{

    RecyclerView rv;
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private String baseUrl = "http://www.qubaobei.com/ios/cf/";
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        //向Present发送请求数据的指令
        MyPresent myPresent = new MyPresent(this);
        myPresent.getData(url,baseUrl);
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter = new MainAdapter();
        rv.setAdapter(adapter);
    }

    @Override
    public void onSuccess(Bean bean) {
        adapter.refresh(bean.getData());
    }

    @Override
    public void onError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
