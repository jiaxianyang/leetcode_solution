package com.common.experiment.ref;

import java.lang.ref.WeakReference;

/**
 * Salad简介
 * <p>
 * 继承WeakReference，将Apple作为弱引用。
 * 注意到时候回收的是Apple，而不是Salad
 *
 * @author jiaxianyang
 * @date 2021-11-13 09:39
 */
public class Salad extends WeakReference<Apple> {
    public Salad(Apple apple) {
        super(apple);
    }
}
