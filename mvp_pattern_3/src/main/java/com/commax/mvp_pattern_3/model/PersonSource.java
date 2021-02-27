package com.commax.mvp_pattern_3.model;

import android.content.Context;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface PersonSource {
    interface  LoadPersonCallback{
        void onPersonLoaded();
    }
    Single<ArrayList<Person>> getSinglePersons();
    void addPerson(Person person);
}
