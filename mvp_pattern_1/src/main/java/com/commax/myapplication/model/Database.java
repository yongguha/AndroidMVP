package com.commax.myapplication.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    private static Database instance;
    private ArrayList<Person> personList = new ArrayList<>();
    private DatabaseListener databaseListener;

    public void setOnDatabaseListener(DatabaseListener databaseListener) {
        this.databaseListener = databaseListener;
    }
    public interface DatabaseListener {
        void onChanged();
    }

    public Database() {
        for (int index = 0; index < 10; index++) {
            personList.add(new Person(index, String.format("Charles%d", index)));
        }

    }

    public static Database getInstance(){
        if(instance==null){
            instance = new Database();
        }
        return instance;
    }

    public void notifyChange(){
        if(databaseListener!=null){
            databaseListener.onChanged();
        }
    }

    public void add(Person person){
        personList.add(person);
        notifyChange();
    }

    public void remove(Person person){
        int position = personList.indexOf(person);
        personList.remove(position);
        notifyChange();
    }

    public List<Person> getPersonList(){
        return personList;
    }




}
