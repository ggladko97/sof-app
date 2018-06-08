package com.example.user.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.myapplication.R;
import com.example.user.myapplication.entity.SOFResponse;

import java.util.List;

public class SOFResponseAdapter  extends RecyclerView.Adapter<SOFResponseViewHolder>  {

    private List<SOFResponse> dataSet;

    @NonNull
    @Override
    public SOFResponseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.custom_card_view, viewGroup, false);
        return new SOFResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SOFResponseViewHolder holder, int i) {
        holder.tvQuestTitle.setText(dataSet.get(i).getQuestTitle());
        holder.tvQuestAuthor.setText(dataSet.get(i).getQuestAuthor());
        holder.ibExpand.setOnClickListener(btn -> {
            holder.tvAnswerScore.setText(dataSet.get(i).getAnswScore());
            holder.tvAnswerLink.setText(dataSet.get(i).getAnswLink());
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setDataSet(List<SOFResponse> result) {
        this.dataSet = result;
    }
}
