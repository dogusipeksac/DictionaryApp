package com.dogusipeksac.dictionaryapp.ViewHolder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dogusipeksac.dictionaryapp.R;

public class PhoneticsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_phonetics;
    public ImageButton imageButton_audio;


    public PhoneticsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_phonetics=itemView.findViewById(R.id.textView_phonetics);
        imageButton_audio=itemView.findViewById(R.id.imageButton_audio);
    }
}
