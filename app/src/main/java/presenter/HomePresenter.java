package presenter;

import contract.IHomeContract;
import model.HomeModel;
import model.bean.Lawyer;

/*
 *@auther:张奕漫
 *@Date: 2019/12/1
 *@Time:20:32
 *@Description:
 * */
public class HomePresenter {
    public void getHomeData(final IHomeContract.IView iView){
        HomeModel homeModel = new HomeModel();
        homeModel.getHomeData(new IHomeContract.IModelCallback() {
            @Override
            public void onHomeSuccess(Lawyer lawyer) {
                iView.onHomeSuccess(lawyer);
            }

            @Override
            public void OnHomeFailure(Throwable throwable) {
                iView.OnmeFailure(throwable);
            }
        });
    }
}
