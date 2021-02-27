package com.commax.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.commax.myapplication.model.Database;
import com.commax.myapplication.model.Person;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainContract.View, MainViewHolder.HolderClickListener{

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    MainAdapter adapter;
    MainContract.Presenter presenter;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addPerson(new Person(System.currentTimeMillis(), String.format("Added Charles %d", new Random().nextInt(1000))));
            }
        });
        recyclerView = findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MainAdapter(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        presenter = new MainPresenter(Database.getInstance(), this);
        presenter.load();


    }

    @Override
    public void onDeleteClick(Person person) {
        presenter.removePerson(person);
    }

    @Override
    public void showPersonList(List<Person> personList) {
        adapter.setItems(personList);
    }

    @Override
    public void notifyDataChagned() {
        adapter.notifyDataSetChanged();
    }
}