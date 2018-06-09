package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapplication.adapter.SOFResponseAdapter;
import com.example.user.myapplication.entity.Items;
import com.example.user.myapplication.presenter.MainActivityContract;
import com.example.user.myapplication.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private Button btnSearch;
    private EditText etSearch;

    private MainActivityPresenter presenter;
    private SOFResponseAdapter adapter;
    private RecyclerView rcViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        adapter = new SOFResponseAdapter();
        presenter = new MainActivityPresenter();
        presenter.bindView(MainActivity.this);
        btnSearch.setOnClickListener(btn -> {
            if (validateInputs()) {
                presenter.searchQuestions(etSearch.getText().toString());
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rcViewResult.setLayoutManager(layoutManager);
        rcViewResult.setAdapter(adapter);
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
        rcViewResult = findViewById(R.id.rcViewResult);
    }


    @Override
    public void displaySearchResult(List<Items> result) {
        adapter.setDataSet(result);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateAdapterDataSet(List<Items> responseBody) {
        adapter.setDataSet(responseBody);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void displayError() {
        Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_LONG).show();
    }
}
