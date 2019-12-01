package com.bawei.combatsample.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import base.BaseActivity;
import contract.IHomeContract;
import model.bean.Lawyer;
import presenter.HomePresenter;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.combatsample.R;

public class MainActivity extends BaseActivity implements IHomeContract.IView {

    private GridView gv;

    @Override
    protected void initData() {

        HomePresenter homePresenter = new HomePresenter();
        homePresenter.getHomeData(this);
    }

    @Override
    protected void initView() {
        gv = findViewById(R.id.gv);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_home2;
    }

    @Override
    public void onHomeSuccess(Lawyer lawyer) {
        Toast.makeText(this, "请求到了数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnmeFailure(Throwable throwable) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }
}
