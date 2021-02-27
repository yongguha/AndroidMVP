package com.ygha.baseproject.base;

public interface BasePresenter<T extends BaseView>{
    void setView(T view);
    void removeView();
}
