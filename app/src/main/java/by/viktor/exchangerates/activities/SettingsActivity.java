package by.viktor.exchangerates.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toolbar;

import java.util.ArrayList;

import by.viktor.exchangerates.R;
import by.viktor.exchangerates.adapter.CurrencyAdapter;
import by.viktor.exchangerates.adapter.SettingsAdapter;
import by.viktor.exchangerates.model.CurrencyModel;
import by.viktor.exchangerates.presenter.ReadCurrency;
import by.viktor.exchangerates.presenter.SettingsCurrency;

public class SettingsActivity extends AppCompatActivity /*implements CompoundButton.OnCheckedChangeListener*/{

    RecyclerView recyclerView;
    Switch mSwitch = null;
//    public static ArrayList<CurrencyModel> namesCurrency = new ArrayList<>();
    LinearLayout linearLayout;
    ImageView back, save;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        recyclerView = findViewById(R.id.rv_settings);
        mSwitch = findViewById(R.id.switch_showing);
        linearLayout = findViewById(R.id.currency_row);

        back = findViewById(R.id.go_to_back);
        save = findViewById(R.id.save_settings);

        SettingsCurrency settingsCurrency = new SettingsCurrency(this, recyclerView);
        settingsCurrency.execute();

//        back.setOnClickListener();
//        save.setOnClickListener();


    }
}
