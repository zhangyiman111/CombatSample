package contract;

import model.bean.Lawyer;

/*
 *@auther:张奕漫
 *@Date: 2019/12/1
 *@Time:20:41
 *@Description:
 * */
public interface IHomeContract {

    interface  IModelCallback{
        void onHomeSuccess(Lawyer lawyer);
        void OnHomeFailure(Throwable throwable);
    }

    interface IView{
        void onHomeSuccess(Lawyer lawyer);
        void OnmeFailure(Throwable throwable);
    }
}
