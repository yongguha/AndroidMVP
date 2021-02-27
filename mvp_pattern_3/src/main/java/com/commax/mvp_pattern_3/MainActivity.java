package com.commax.mvp_pattern_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.commax.mvp_pattern_3.model.Person;
import com.commax.mvp_pattern_3.model.PersonRepository;
import com.commax.mvp_pattern_3.model.PersonSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, PersonSource.LoadPersonCallback {

    RecyclerView recyclerView;
    MainAdapter adapter;
    MainPresent present;
    PersonRepository personRepository;


    Person person;

    @Override
    public void onPersonLoaded() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        Button button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present.addPerson(new Person(10, "Addy"));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personRepository = personRepository.getInstance();
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        personRepository.setPersonLoadCallback(this);

        present = new MainPresent(personRepository,this, adapter);
        present.load();
    }

    public void buttonOnClick(View view){
        present.addPerson(new Person(10, "Addy"));
    }

    @Override
    public void showPersonList(List<Person> personList) {
        adapter.setItems(personList);
    }
}
