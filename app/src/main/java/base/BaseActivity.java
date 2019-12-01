package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@auther:张奕漫
 *@Date: 2019/12/1
 *@Time:19:53
 *@Description:
 * */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();
}
