package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements  MainActivityContract.View{
    MainActivityContract.Presenter presenter;
    @BindView(R.id.editmvp) EditText email;
    @BindView(R.id.edit2mvp) EditText password;
    @BindView(R.id.buttmvp)
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter=new MainActivityPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1 =password.getText().toString();
                String email1= email.getText().toString();

                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1) ){
                    onError("Fields Requried");
                } else {
                    presenter.doLogin(email1,password1);
                }

            }
        });
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this,"Succesful",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String message) {
        Toast.makeText(this,"Failure",Toast.LENGTH_LONG).show();


    }
}