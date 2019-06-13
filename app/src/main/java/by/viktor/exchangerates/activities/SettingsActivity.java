package by.viktor.exchangerates.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import by.viktor.exchangerates.R;
import by.viktor.exchangerates.adapter.CurrencyAdapter;
import by.viktor.exchangerates.adapter.SettingsAdapter;
import by.viktor.exchangerates.model.CurrencyModel;
import by.viktor.exchangerates.presenter.ReadCurrency;
import by.viktor.exchangerates.presenter.SettingsCurrency;

public class SettingsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
//    public static ArrayList<CurrencyModel> namesCurrency = new ArrayList<>();
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        recyclerView = findViewById(R.id.rv_settings);

//        CurrencyAdapter adapter = new CurrencyAdapter(context, namesCurrency);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        recyclerView.setAdapter(adapter);

//        ReadCurrency readCurrency = new ReadCurrency(this, recyclerView);
//        readCurrency.execute();

        SettingsCurrency settingsCurrency = new SettingsCurrency(this, recyclerView);
        settingsCurrency.execute();
    }
}
