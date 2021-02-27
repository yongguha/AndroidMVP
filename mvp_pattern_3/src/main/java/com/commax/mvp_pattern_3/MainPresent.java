package com.commax.mvp_pattern_3;

import android.content.Context;

import com.commax.mvp_pattern_3.model.Person;
import com.commax.mvp_pattern_3.model.PersonRepository;

import java.util.ArrayList;

public class MainPresent implements MainContract.Presenter{
    private PersonRepository personRepository;
    private MainContract.View view;
    private Context context;
    Person person;
    ArrayList<Person> personArrayList;
    MainAdapter adapter;

    public MainPresent(PersonRepository personRepository, MainContract.View view, MainAdapter adapter) {
        this.personRepository = personRepository;
        this.view = view;
        context = (Context)view;
        this.adapter = adapter;
    }

    @Override
    public void load() {
        personRepository.getSinglePersons()
                .doOnSuccess(x->System.out.println("doOnSuccess"))
                .subscribe(
                        s->{
                            personArrayList=s;
                            view.showPersonList(s);
                        }
                        );
    }

    @Override
    public void addPerson(Person person) {
        personRepository.addPerson(person);
        /*
        if(personArrayList!=null)
            personArrayList.add(person);
            adapter.notifyDataSetChanged();

         */
    }

    @Override
    public void removePerson(Person person) {

    }
}
