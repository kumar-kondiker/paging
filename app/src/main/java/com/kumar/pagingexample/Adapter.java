package com.kumar.pagingexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    ArrayList<String> cities;
    Context context;
    Adapter(Context context,ArrayList<String> cities)
    {
        this.context=context;
        this.cities=cities;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.city_item,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.city.setText(cities.get(position));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        TextView city;
      public Holder(@NonNull View itemView) {
          super(itemView);
          city=itemView.findViewById(R.id.cityname_item);

      }
    }
}
