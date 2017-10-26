package com.example.ehab.dagger2withmvp.activities.mainActivity;

import android.content.Context;
import android.util.Log;

import com.example.ehab.dagger2withmvp.app.MyApplication;
import com.example.ehab.dagger2withmvp.models.SOAnswersResponse;
import com.example.ehab.dagger2withmvp.network.ApiInterface;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ehab on 10/26/17.
 */

public class MainActivityPresenter {
    public static final String TAG = "mainPresTag";
    @Inject
    ApiInterface mApiInterface;
    private Context mContext;
    private MainActivityView view;
    private MainActivityModel mainActivityModel;

    public MainActivityPresenter(Context context, MainActivityView view) {
        this.mContext = context;
        this.view = view;
        ((MyApplication) ((MainActivity) context).getApplication()).getDaggerMainComponent(context, view).inject(this);
        mainActivityModel = new MainActivityModel();
    }

    public void getAnswers() {
        view.showLoading();

        mainActivityModel.getAnswers(mApiInterface, new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    view.showData(response.body().getItems());
                    Log.d(TAG, "answers loaded from API");
                } else {
                    Log.d(TAG, "Error loading Answers from API");
                    // handle request errors depending on status code
                    view.showErrorDialog();

                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                view.hideLoading();
                view.showErrorDialog();
                Log.d(TAG, "error loading from API");

            }
        });

    }


}



