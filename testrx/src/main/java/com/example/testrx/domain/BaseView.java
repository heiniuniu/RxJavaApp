package com.example.testrx.domain;

/**
 * Created by pengleigang on 2017/9/1.
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showEmpty();
    void showError(String msg);
}
