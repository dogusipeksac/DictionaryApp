package com.dogusipeksac.dictionaryapp.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dogusipeksac.dictionaryapp.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_partsOfSpeech;
    public RecyclerView recyclerView_definition;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_partsOfSpeech=itemView.findViewById(R.id.textView_partsOfSpeech);
        recyclerView_definition=itemView.findViewById(R.id.recycler_definitions);
    }
}
