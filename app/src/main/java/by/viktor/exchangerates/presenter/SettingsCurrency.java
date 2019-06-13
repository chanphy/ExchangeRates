package by.viktor.exchangerates.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import by.viktor.exchangerates.adapter.SettingsAdapter;
import by.viktor.exchangerates.model.CurrencyModel;


public class SettingsCurrency extends ReadCurrency {

    private static ArrayList<CurrencyModel> namesCurrency;
    private RecyclerView recyclerView;
    private Context context;

    public SettingsCurrency(Context context, RecyclerView mRvCurrency) {
        super(context, mRvCurrency);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        SettingsAdapter adapter = new SettingsAdapter(namesCurrency, context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

}
