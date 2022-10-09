package com.josue.example.myapplication.Interface;

public interface ContractInterface {
    interface View{
        void showProgress();
        void hideProgress();
        void setString(String string);
    }
    interface Presenter{
        void onButtonClick();
        void onDestroy();
    }
    interface Model{
        interface OnFinishedListener{
            void onFinished(String  string);
        }

        void getNextCourse(ContractInterface.Model.OnFinishedListener onFinishedListener);
    }
}
