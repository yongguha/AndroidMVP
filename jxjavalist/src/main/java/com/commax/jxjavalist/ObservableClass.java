package com.commax.jxjavalist;

import com.commax.jxjavalist.databinding.ActivityMainBinding;
import com.commax.jxjavalist.util.Constants;
import com.commax.jxjavalist.util.User;
import com.commax.jxjavalist.util.UserUtil;

import java.util.Random;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.internal.operators.observable.ObservablePublish.create;

public class ObservableClass {
    ActivityMainBinding binding;

    public ObservableClass() {
    }

    public Flowable<Integer> getFlowableData() {
        return getFlowable();
    }

    private Flowable<Integer> getFlowable() {
        //return Flowable.range(0, new Random().nextInt(500));
        return Flowable.range(0, 9);
    }

    public Maybe<User> getMayble() {
        //return Flowable.range(0, new Random().nextInt(500));
        return Maybe.create(
                emitter -> {
                    emitter.onSuccess(UserUtil.getUser());
                }
        );
    }

    public Single<User> getSingle(){
        return Single.create(
                e->{
                    try {
                        e.onSuccess(UserUtil.getUser());
                    }catch (Exception f){
                        f.printStackTrace();
                    }
                }
        );
    }

    public Observable<User> getObservableFlatmap(){
        return Observable.create(
                emitter->{
                    if (!emitter.isDisposed()) {
                        for (User user : UserUtil.getUserList()) {
                            emitter.onNext(user);
                        }
                        emitter.onComplete();
                    }
                });
    }
}
