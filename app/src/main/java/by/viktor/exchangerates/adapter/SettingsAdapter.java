package by.viktor.exchangerates.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import by.viktor.exchangerates.R;
import by.viktor.exchangerates.model.CurrencyModel;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.CustomViewHolder> {

    private ArrayList<CurrencyModel> settingCurrencyModels;
    private Context context;

    public SettingsAdapter(ArrayList<CurrencyModel> settingCurrencyModels, Context context) {
        this.settingCurrencyModels = settingCurrencyModels;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_settings_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        CurrencyModel current = settingCurrencyModels.get(position);
        holder.charCode.setText(current.getCharCode());
        holder.name.setText(current.getName());
    }

    @Override
    public int getItemCount() {
        return settingCurrencyModels.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView charCode, name;
        public CustomViewHolder(View itemView) {
            super(itemView);
            charCode = itemView.findViewById(R.id.txt_char_code);
            name = itemView.findViewById(R.id.txt_currency_name);
        }
    }
}
