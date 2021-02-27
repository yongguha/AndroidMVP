package com.commax.myapplication;

import com.commax.myapplication.model.Person;

import java.util.List;

public class MainContract {
    public interface View{
        void showPersonList(List<Person> personList);
        void notifyDataChagned();
    }

    public interface Presenter{
        void load();
        void addPerson(Person person);
        void removePerson(Person person);
    }

}
