package com.commax.jxjavalist;

import com.commax.jxjavalist.databinding.ActivityMainBinding;
import com.commax.jxjavalist.util.Constants;
import com.commax.jxjavalist.util.User;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {
    ActivityMainBinding binding;
    ObservableClass observableClass;

    public MainPresenter() {
        observableClass = new ObservableClass();
    }

    public Flowable<Integer> onButtonFlowable(){
        return observableClass.getFlowableData();
    }

    public Maybe<User> onButtonMaybe(){
        return observableClass.getMayble();
    }

    public Single<User> onButtonSingle(){
        return observableClass.getSingle();
    }

    public Observable<User> onButtonObservable(){
        return observableClass.getObservableFlatmap();
    }

}
