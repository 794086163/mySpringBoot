package com.didispace.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 发布者，订阅者模式
 * Created by v-yangxu on 2019/7/16.
 */
public class ObservableDemo extends Observable{

    public void setChange(){
        super.setChanged();
    }

    public static void main(String[] args){
        ObservableDemo obj=new ObservableDemo();
        //添加订阅者
        obj.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        });
        //判断是否改变，改变了才订阅
        obj.setChanged();
        //发布者
        obj.notifyObservers("Hello11 world");
        //每次发布都需要设置改变
        obj.setChanged();
        obj.notifyObservers("Hello2 world");
        obj.setChanged();
        obj.notifyObservers("Hello3 world");
    }
}
