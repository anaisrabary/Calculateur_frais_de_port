package com.fredericboisguerin.insa;

public enum Destination {

    FR("FR"), MC("MC"),DT("DT");

    private String text;

    Destination(final String st) {
        this.text = st ;
    }

    @Override
    public String toString() {
        return this.text;
    }
}

