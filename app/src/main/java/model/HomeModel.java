package model;

import com.google.gson.Gson;

import contract.IHomeContract;
import model.bean.Lawyer;
import util.Util;

/*
 *@auther:张奕漫
 *@Date: 2019/12/1
 *@Time:20:34
 *@Description:
 * */
public class HomeModel {
    public void getHomeData(final IHomeContract.IModelCallback iModelCallback){
        Util.getInstance().getJson("http://blog.zhaoliang5156.cn/api/news/lawyer.json", new Util.MyCollBack() {
            @Override
            public void getJson(String json) {
                Lawyer lawyer = new Gson().fromJson(json, Lawyer.class);
                iModelCallback.onHomeSuccess(lawyer);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.OnHomeFailure(throwable);
            }
        });
    }
}
