package com.didispace.generic;

/**
 * Created by v-yangxu on 2019/5/16.
 */
public class Fruit<T,N,C> {
    private T t;
    private N n;
    private C c;
    public void test(){
        System.out.println(n);
    }
    public void set(T t){
        this.t=t;
    }
    public T get(){
        return this.t;
    }
}
