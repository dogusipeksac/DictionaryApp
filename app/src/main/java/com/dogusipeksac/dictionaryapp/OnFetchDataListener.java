package com.dogusipeksac.dictionaryapp;

import com.dogusipeksac.dictionaryapp.Models.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse,String message);
    void onError(String message);
}
