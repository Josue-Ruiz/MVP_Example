package com.josue.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.josue.example.myapplication.Interface.ContractInterface;
import com.josue.example.myapplication.Model.Model;
import com.josue.example.myapplication.Presenter.Presenter;
import com.josue.example.myapplication.R;

public class MainActivity extends AppCompatActivity implements ContractInterface.View{

    //setUi
    private TextView textView,tv_Link;
    private ProgressBar progressBar;

    ContractInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_Description);
        tv_Link = findViewById(R.id.tv_link);
        Button button = findViewById(R.id.btn_getText);
        progressBar = findViewById(R.id.progressBar);

        presenter = new Presenter(this,new Model());

        tv_Link.setMovementMethod(LinkMovementMethod.getInstance());

        button.setOnClickListener(view -> presenter.onButtonClick());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setString(String string) {
        textView.setText(string);
    }
}