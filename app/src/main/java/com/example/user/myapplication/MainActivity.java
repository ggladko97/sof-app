package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapplication.adapter.SOFResponseAdapter;
import com.example.user.myapplication.entity.SOFResponse;
import com.example.user.myapplication.presenter.MainActivityContract;
import com.example.user.myapplication.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private Button btnSearch;
    private EditText etSearch;

    private MainActivityPresenter presenter;
    private SOFResponseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        adapter = new SOFResponseAdapter();
        presenter = new MainActivityPresenter();

        btnSearch.setOnClickListener(btn -> {
            if (validateInputs()) {
                presenter.searchQuestions();
            }
        });
    }

    private boolean validateInputs() {
        //set up validation process
        if (!etSearch.getText().toString().isEmpty()) {
            return true;
        }
        return false;
    }

    private void initViews() {
        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);
    }

    @Override
    public void displaySearchResult(List<SOFResponse> result) {
        adapter.setDataSet(result);
        adapter.notifyDataSetChanged();
    }
}
