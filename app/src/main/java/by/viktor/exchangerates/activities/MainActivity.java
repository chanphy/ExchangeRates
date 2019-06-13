package by.viktor.exchangerates.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import by.viktor.exchangerates.presenter.GetDateDey;
import by.viktor.exchangerates.R;
import by.viktor.exchangerates.presenter.ReadCurrency;
import by.viktor.exchangerates.views.ViewDate;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView dateToday, dateTomorrow, dateYesterday;
    GetDateDey getDateDay = new GetDateDey();


    ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = findViewById(R.id.settings);
        recyclerView = findViewById(R.id.rv_currency);

        dateToday = findViewById(R.id.txt_today_data);
        dateTomorrow = findViewById(R.id.txt_tomorrow_data);
        dateYesterday = findViewById(R.id.txt_yesterday_data);

        dateToday.setText(getDateDay.dateToday());
        dateTomorrow.setText(getDateDay.dateTomorrow());
        dateYesterday.setText(getDateDay.dateYesterday());

        ReadCurrency readCurrency = new ReadCurrency(this, recyclerView);
        readCurrency.execute();



        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });


    }
}

