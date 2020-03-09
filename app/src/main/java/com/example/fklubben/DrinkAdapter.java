package com.example.fklubben;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    private List<Drink> myDrinks;
    public DrinkAdapter(List<Drink> myDrinks) {
        this.myDrinks = myDrinks;
    }

    @NonNull
    @Override
    public DrinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drink_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drink drink = myDrinks.get(position);
        holder.name.setText(drink.getName());
        holder.price.setText(drink.getPrice());
    }

    @Override
    public int getItemCount() {
        return myDrinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView name;
        public final TextView price;
        public ViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.drink_name);
            price = (TextView) itemView.findViewById(R.id.drink_price);

        }
    }
}
