package com.example.ehab.dagger2withmvp.activities.mainActivity;

import com.example.ehab.dagger2withmvp.models.Item;

import java.util.List;

/**
 * Created by ehab on 10/26/17.
 */

public interface MainActivityView {
    void showLoading();

    void hideLoading();

    //void showFood(Food food);

    void showErrorDialog();

    void showData(List<Item> items);
}
