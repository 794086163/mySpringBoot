package com.didispace.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 泛型练习
 * Created by v-yangxu on 2019/5/16.
 */
public class GenericTest {
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();

    static <T> void writeExact(List<T> list, T item) {
        list.add( item );
    }

    static void f1() {
        writeExact( apples, new Apple() );
        writeExact( fruit, new Apple() );
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add( item );
    }

    static void f2() {
        writeWithWildcard( apples, new Apple() );
        writeWithWildcard( fruit, new Apple() );
    }

    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? super Fruit> flist = new ArrayList<Fruit>();
        List<Apple> flist2 = new ArrayList<Apple>();
        // Compile Error: can't add any type of object:
        flist2.add( new Apple() );
        flist.add( new Apple() );
        flist.add( new Fruit() );
        // We Know that it returns at least Fruit:
//        Fruit f = flist.get(0);
        HashMap map=new HashMap();
        map.put( null,"ss" );
        Collections.copy(flist,flist2);
        System.out.println( flist.size() );
        System.out.println(flist2.size());
        System.out.println("==============================");
        int n =32 - 1;
        System.out.println(n);
        n |= n >>> 1;
        System.out.println( n &= n>>>1);
        n |= n >>> 2;
        System.out.println(n |= n >>> 2);
        n |= n >>> 4;
        System.out.println(n |= n >>> 4);
        n |= n >>> 8;
        System.out.println(n |= n >>> 8);
        n |= n >>> 16;
        System.out.println(n |= n >>> 16);
    }

}
