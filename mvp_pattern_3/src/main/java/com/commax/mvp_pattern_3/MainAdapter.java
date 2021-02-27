package com.commax.mvp_pattern_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.commax.mvp_pattern_3.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHodler> {

    private TextView name;
    private Button delete;
    private Person person;

    private List<Person> items = new ArrayList<>();


    @NonNull
    @Override
    public MainViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_main, parent, false);
        return new MainViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHodler holder, int position) {
        setPerson(items.get(position));
    }

    public void setPerson(Person person){
        this.person = person;
        name.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Person> getItems(){
        return items;
    }

    public void setItems(List<Person> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public class MainViewHodler extends RecyclerView.ViewHolder{

        public MainViewHodler(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            delete = itemView.findViewById(R.id.delete);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}
