package base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 *@auther:张奕漫
 *@Date: 2019/12/1
 *@Time:19:54
 *@Description:
 * */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        initView(inflate);
        initData();
        return inflate;

    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int layoutId();
}
