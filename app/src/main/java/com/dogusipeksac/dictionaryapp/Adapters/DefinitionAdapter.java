package com.dogusipeksac.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dogusipeksac.dictionaryapp.Models.Definitions;
import com.dogusipeksac.dictionaryapp.R;
import com.dogusipeksac.dictionaryapp.ViewHolder.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        Definitions definitions=definitionsList.get(position);
        holder.textView_example.setText("Example"+definitions.getExample());
        holder.textView_definition.setText("Definition"+definitions.getDefinition());
        StringBuilder synonyms=new StringBuilder();
        StringBuilder antonyms=new StringBuilder();
        synonyms.append(definitions.getSynonym());
        antonyms.append(definitions.getAntonyms());

        holder.textView_antonyms.setText(antonyms);
        holder.textView_synonyms.setText(synonyms);

        holder.textView_synonyms.setSelected(true);
        holder.textView_antonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
