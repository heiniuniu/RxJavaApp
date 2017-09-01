package com.example.testrx.domain;

/**
 * Created by pengleigang on 2017/9/1.
 */

public interface Responsitory<T> {
    T pull(Object... objects);
}
