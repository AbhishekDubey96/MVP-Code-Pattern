package com.example.mvp;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if (email.equals("testlive@gmail.com") && password.equals("pass1234")){
            view.onSuccess("Succesful");
        }else {
            view.onError("Wrong Password");
        }

    }
}
