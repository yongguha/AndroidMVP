package com.commax.mvp_pattern_3;

import com.commax.mvp_pattern_3.model.Person;

import java.util.List;

public interface MainContract {

    interface View{
        void showPersonList(List<Person> personList);
    }

    interface Presenter{
        void load();
        void addPerson(Person person);
        void removePerson(Person person);
    }
}
