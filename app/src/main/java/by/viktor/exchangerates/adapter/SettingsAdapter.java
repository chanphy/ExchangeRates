package by.viktor.exchangerates.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final CurrencyModel mCurrent = settingCurrencyModels.get(position);
        holder.CharCode.setText(mCurrent.getCharCode());
        holder.Name.setText(mCurrent.getScale() + " " + mCurrent.getName());
        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(context, mCurrent.getName().toString(), Toast.LENGTH_LONG).show();
//                    mCurrent


                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return settingCurrencyModels.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView CharCode, Name;
        Switch aSwitch;
        ImageView burger;
        LinearLayout layoutItem;
        public CustomViewHolder(View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.currency_row);
            CharCode = itemView.findViewById(R.id.txt_char_code);
            Name = itemView.findViewById(R.id.txt_currency_name);
            aSwitch = itemView.findViewById(R.id.switch_showing);
            burger = itemView.findViewById(R.id.txt_currency_tomorrow_value);

        }

        public void visibleOff(){
        layoutItem.setVisibility(View.GONE);
        }
    }


}
