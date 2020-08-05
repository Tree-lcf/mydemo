package com.tree.mydemo.domain;

public class Telemetry {
    private float v;
    private float i;
    private String ts;

    public Telemetry() {
    }

    public Telemetry(float v, float i, String ts) {
        this.v = v;
        this.i = i;
        this.ts = ts;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    public float getI() {
        return i;
    }

    public void setI(float i) {
        this.i = i;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Telemetry{" +
                "v=" + v +
                ", i=" + i +
                ", ts=" + ts +
                '}';
    }
}
