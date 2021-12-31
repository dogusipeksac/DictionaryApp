package com.dogusipeksac.dictionaryapp.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dogusipeksac.dictionaryapp.Models.Phonetics;
import com.dogusipeksac.dictionaryapp.R;
import com.dogusipeksac.dictionaryapp.ViewHolder.PhoneticsViewHolder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticsViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticsViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetics_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticsViewHolder holder, int position) {
        Phonetics phonetics=phoneticsList.get(position);
        holder.textView_phonetics.setText(phonetics.getText());
        holder.imageButton_audio.setOnClickListener(v -> {
            MediaPlayer player=new MediaPlayer();
            try {
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                player.setDataSource("https:"+phonetics.getAudio());
                player.prepare();
                player.start();
            }catch (Exception exception){
                exception.printStackTrace();
                Toast.makeText(context, "Couldn't play audio!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
