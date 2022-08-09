package com.aov.pfg.Common;

public enum Stages{
    STARTING(1),
    MODERATE(2),
    ADVANCED(3),
    ROBUST(4),
    VERTEBRATE(5);

    private int value;

    private Stages(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
