package com.example.user.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.myapplication.R;

class SOFResponseViewHolder extends RecyclerView.ViewHolder {

    TextView tvQuestTitle, tvQuestAuthor, tvAnswerScore, tvAnswerLink;
    ImageButton ibExpand;
    LinearLayout llQuestAnsw;


    public SOFResponseViewHolder(@NonNull View itemView) {
        super(itemView);
        tvQuestTitle = (TextView) itemView.findViewById(R.id.tvQuestTitle);
        tvQuestAuthor = (TextView) itemView.findViewById(R.id.tvQuestAuthor);
        tvAnswerScore = (TextView) itemView.findViewById(R.id.tvAnswScore);
        tvAnswerLink = (TextView) itemView.findViewById(R.id.tvAnswLink);
        ibExpand = (ImageButton) itemView.findViewById(R.id.ibExtend);
        llQuestAnsw = itemView.findViewById(R.id.llQuestAnsw);
    }
}
