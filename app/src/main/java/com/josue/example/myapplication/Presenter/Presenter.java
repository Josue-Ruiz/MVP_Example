package com.josue.example.myapplication.Presenter;

import com.josue.example.myapplication.Interface.ContractInterface;

public class Presenter implements ContractInterface.Presenter, ContractInterface.Model.OnFinishedListener {

    private ContractInterface.View view;

    private final ContractInterface.Model model;

    public Presenter(ContractInterface.View view, ContractInterface.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onButtonClick() {
        if (view != null) {
            view.showProgress();
        }
        model.getNextCourse(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onFinished(String string) {
        if (view != null) {
            view.setString(string);
            view.hideProgress();
        }
    }
}
