package by.viktor.exchangerates.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import by.viktor.exchangerates.model.CurrencyModel;
import by.viktor.exchangerates.R;
import by.viktor.exchangerates.model.CurrencyModelRate;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CustomViewHolder> {

    private ArrayList<CurrencyModel> currencyModels;
    private Context context;
    private ArrayList<CurrencyModelRate> currencyModelRates;
    private ArrayList<CurrencyModelRate> currencyYesterday;

    public CurrencyAdapter(Context context, ArrayList<CurrencyModel>currencyModels,
                           ArrayList<CurrencyModelRate> currencyModelRates, ArrayList<CurrencyModelRate> currencyYesterday){
        this.context= context;
        this.currencyModels = currencyModels;
        this.currencyModelRates = currencyModelRates;
        this.currencyYesterday = currencyYesterday;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_new_item, parent, false);
        return new CustomViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        CurrencyModel current = currencyModels.get(position);
        CurrencyModelRate currencyModelRate = currencyModelRates.get(position);
        CurrencyModelRate currencyYesterday = currencyModelRates.get(position);
        holder.CharCode.setText(current.getCharCode());
        holder.Name.setText(current.getScale() + " " + current.getName());
        holder.Rate.setText(current.getRate());
        holder.RateTomorrow.setText(currencyModelRate.getRate());
        holder.RateYesterday.setText(currencyYesterday.getRate());

    }

    @Override
    public int getItemCount() {
        return currencyModels.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView CharCode,Scale, Name, Rate, RateTomorrow, RateYesterday;
        @SuppressLint("CutPasteId")
        public CustomViewHolder(View itemView) {
            super(itemView);
            CharCode = itemView.findViewById(R.id.txt_char_code);
            Scale = itemView.findViewById(R.id.txt_currency_name);
            Name = itemView.findViewById(R.id.txt_currency_name);
            Rate = itemView.findViewById(R.id.txt_currency_today_value);
            RateTomorrow = itemView.findViewById(R.id.txt_currency_tomorrow_value);
            RateYesterday = itemView.findViewById(R.id.txt_currency_yesterday_value);


        }
    }
}
