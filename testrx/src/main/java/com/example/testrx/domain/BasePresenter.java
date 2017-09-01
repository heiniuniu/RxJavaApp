package com.example.testrx.domain;

/**
 * Created by pengleigang on 2017/9/1.
 * presenter 持有view 和 responsitory 的引用
 */

public abstract class BasePresenter<T extends BaseView, R> implements Presenter {
    private Responsitory<R> mResponsitory;
    private T mView;

    public void bindView(T view) {
        this.mView = view;
    }

    public void bindResponsitory(Responsitory<R> responsitory) {
        this.mResponsitory = responsitory;
    }

    @Override
    public void onDestory() {
        //解除对view 和 responsitory的引用

    }

    protected R pull(Object... objects) {
        return mResponsitory.pull(objects);
    }
}
