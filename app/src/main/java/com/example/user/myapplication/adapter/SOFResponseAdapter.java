package com.example.user.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.myapplication.R;
import com.example.user.myapplication.entity.Items;

import java.util.List;

public class SOFResponseAdapter  extends RecyclerView.Adapter<SOFResponseViewHolder>  {

    private Items dataSet;
    private boolean IS_EXPANDED = false;

    @NonNull
    @Override
    public SOFResponseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.custom_card_view, viewGroup, false);
        return new SOFResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SOFResponseViewHolder holder, int i) {

        holder.tvQuestTitle.setText(dataSet.getItems().get(i).getTitle());
        holder.tvQuestAuthor.setText(dataSet.getItems().get(i).getOwner().getDisplayName());
        holder.ibExpand.setOnClickListener(btn -> {
            if (!IS_EXPANDED) {
                holder.llQuestAnsw.setVisibility(View.VISIBLE);
                holder.tvAnswerScore.setText(String.valueOf(dataSet.getItems().get(i).getScore()));
                holder.tvAnswerLink.setText(String.valueOf(dataSet.getItems().get(i).getAcceptedAnswerId()));
                IS_EXPANDED = true;
            } else {
                holder.llQuestAnsw.setVisibility(View.GONE);
                IS_EXPANDED = false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.getItems().size();
    }

    public void setDataSet(Items result) {
        this.dataSet = result;
    }
}
