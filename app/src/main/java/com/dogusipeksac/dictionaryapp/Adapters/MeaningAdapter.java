package com.dogusipeksac.dictionaryapp.Adapters;

import android.content.Context;
import android.telephony.SmsMessage;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dogusipeksac.dictionaryapp.Models.Meanings;
import com.dogusipeksac.dictionaryapp.R;
import com.dogusipeksac.dictionaryapp.ViewHolder.MeaningsViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {

    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        Meanings meanings=meaningsList.get(position);
        holder.textView_partsOfSpeech.setText(meanings.getPartOfSpeech());
        holder.recyclerView_definition.setHasFixedSize(true);
        holder.recyclerView_definition.setLayoutManager(new GridLayoutManager(context,1));
        DefinitionAdapter definitionAdapter=new DefinitionAdapter(context, meanings.getDefinitions());
        holder.recyclerView_definition.setAdapter(definitionAdapter);

    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
