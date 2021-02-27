package com.commax.mvp_pattern_3.model;

import java.util.ArrayList;

import io.reactivex.Single;

public class PersonRepository implements PersonSource {

    private static final String TAG = "PesonRepository";
    private static PersonRepository instance;

    private PersonLocalDataSource localDataSource;
    public static PersonRepository getInstance(){
        if(instance==null)
            instance = new PersonRepository();

        return instance;
    }
    PersonSource.LoadPersonCallback callback;

    public void setPersonLoadCallback(PersonSource.LoadPersonCallback callback){
        this.callback = callback;
    }

    public PersonRepository(){
        localDataSource = PersonLocalDataSource.getInstance();
    }

    public void addPerson(Person person){
        //localDataSource.getPersonList().add(new Person(10,"Addy"));
        localDataSource.addPerson(person);
        callback.onPersonLoaded();

    }

    @Override
    public Single<ArrayList<Person>> getSinglePersons() {
        return localDataSource.getSinglePersons();
    }
}
