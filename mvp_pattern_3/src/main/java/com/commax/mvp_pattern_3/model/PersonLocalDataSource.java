package com.commax.mvp_pattern_3.model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class PersonLocalDataSource implements PersonSource {

    private static PersonLocalDataSource instance;

    public static PersonLocalDataSource getInstance(){
        if(instance==null)
            instance = new PersonLocalDataSource();

        return instance;
    }

    public PersonLocalDataSource() {
        makePerson();
    }

    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }

    ArrayList<Person> personList;
    private List<Person> makePerson(){
        personList = new ArrayList<>();
        personList.add(new Person(1, "John"));
        personList.add(new Person(2, "michael"));
        personList.add(new Person(3, "clarke"));
        personList.add(new Person(4, "sujan"));

        return personList;
    }
    public ArrayList<Person> getPersonList(){
        return personList;
    }

    @Override
    public Single<ArrayList<Person>> getSinglePersons() {

        Observable observable = Observable.fromArray(personList);
        return Single.fromObservable(observable);

    }


}
