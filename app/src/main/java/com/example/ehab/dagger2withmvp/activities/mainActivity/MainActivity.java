package com.example.ehab.dagger2withmvp.activities.mainActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ehab.dagger2withmvp.R;
import com.example.ehab.dagger2withmvp.app.MyApplication;
import com.example.ehab.dagger2withmvp.helpers.DialogsHelper;
import com.example.ehab.dagger2withmvp.models.Item;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private static final String TAG = "MainActivityTag";
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvFetchedData)
    TextView tvFetchedData;
    @Inject
    MainActivityPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication) getApplication()).getDaggerMainComponent(this, this).inject(this);
        ButterKnife.bind(this);
        progressDialog = new DialogsHelper().getProgressDialog(this, getString(R.string.loading), false, false);
        presenter.getAnswers();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorDialog() {
        new DialogsHelper().getAlert(this, "", getString(R.string.error_message), getString(R.string.ok), "", null, null).show();

    }

    @Override
    public void showData(List<Item> items) {
        if (items != null && items.size() > 0 && items.get(0).getOwner()!=null && items.get(0).getOwner().getDisplayName()!=null)
            tvFetchedData.setText(items.get(0).getOwner().getDisplayName());
        else
            showErrorDialog();
    }
}
