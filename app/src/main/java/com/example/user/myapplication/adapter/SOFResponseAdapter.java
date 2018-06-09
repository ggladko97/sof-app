package com.example.user.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.myapplication.R;
import com.example.user.myapplication.entity.Items;

import java.util.List;

public class SOFResponseAdapter  extends RecyclerView.Adapter<SOFResponseViewHolder>  {

    private List<Items> dataSet;

    @NonNull
    @Override
    public SOFResponseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.custom_card_view, viewGroup, false);
        return new SOFResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SOFResponseViewHolder holder, int i) {
        holder.tvQuestTitle.setText(dataSet.get(0).getItems().get(i).getTitle());
        holder.tvQuestAuthor.setText(dataSet.get(0).getItems().get(i).getOwner().getDisplayName());
        holder.ibExpand.setOnClickListener(btn -> {
            holder.tvAnswerScore.setText(dataSet.get(0).getItems().get(i).getScore());
            holder.tvAnswerLink.setText(dataSet.get(0).getItems().get(i).getAcceptedAnswerId());
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setDataSet(List<Items> result) {
        this.dataSet = result;
    }
}
