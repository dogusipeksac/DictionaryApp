package com.dogusipeksac.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dogusipeksac.dictionaryapp.Adapters.MeaningAdapter;
import com.dogusipeksac.dictionaryapp.Adapters.PhoneticsAdapter;
import com.dogusipeksac.dictionaryapp.Models.APIResponse;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TextView textView_word;
    RecyclerView recyclerView_phonetics,recyclerView_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.search_view);
        textView_word=findViewById(R.id.textview_word);
        recyclerView_phonetics=findViewById(R.id.recycler_phonetics);
        recyclerView_meanings=findViewById(R.id.recycler_meanings);
        progressDialog=new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RequestManager manager=new RequestManager(getApplication());
        manager.getWordMeaning(listener,"Hello");
        
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for "+query);
                progressDialog.show();
                RequestManager manager=new RequestManager(getApplication());
                manager.getWordMeaning(listener,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }
    private final OnFetchDataListener listener=new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(MainActivity.this, "No data found!!", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(APIResponse apiResponse) {
        textView_word.setText("Word:"+apiResponse.getWord());
        recyclerView_phonetics.setHasFixedSize(true);
        recyclerView_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter=new PhoneticsAdapter(this,apiResponse.getPhonetics());
        recyclerView_phonetics.setAdapter(phoneticsAdapter);

        recyclerView_meanings.setHasFixedSize(true);
        recyclerView_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter=new MeaningAdapter(this,apiResponse.getMeanings());
        recyclerView_meanings.setAdapter(meaningAdapter);


    }
}