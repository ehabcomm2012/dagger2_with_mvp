package com.example.ehab.dagger2withmvp.activities.mainActivity;

import android.util.Log;

import com.example.ehab.dagger2withmvp.models.SOAnswersResponse;
import com.example.ehab.dagger2withmvp.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ehab on 10/26/17.
 */

public class MainActivityModel {

    //business features
    public void getAnswers(ApiInterface mApiInterface, Callback<SOAnswersResponse> callback){
        mApiInterface.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                callback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                callback.onFailure(call,t);

            }
        });
    }

}
