package com.example.labo1v2;

public class Process implements Cloneable, Comparable {

    private int id;
    private int arrivalTime;
    private int serviceTime;
    private int startTime;
    private int endTime;
    private int TAT;
    private double normTAT;
    private int waitTime;
    private int serviceTimeNeeded;

    public void setServiceTimeNeeded(int i) {
        serviceTimeNeeded = i;
    }

    public int getServiceTimeNeeded() {
        return this.serviceTimeNeeded;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setTAT(int TAT) {
        this.TAT = TAT;
    }

    public void setNormTAT(int normTAT) {
        this.normTAT = normTAT;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getTAT() {
        return TAT;
    }

    public double getNormTAT() {
        return normTAT;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public Process() {
    }

    public Process(int id, int arrivaltime, int servicetime) {
        this.id = id;
        this.arrivalTime = arrivaltime;
        this.serviceTime = servicetime;
        this.serviceTimeNeeded = servicetime;
    }

    public Process(Process p) {
        this.arrivalTime = p.arrivalTime;
        this.serviceTime = p.serviceTime;
        this.serviceTimeNeeded = p.serviceTimeNeeded;
        this.id = p.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void decreaseServiceTime(int i) {
        this.serviceTime -= i;
    }

    @Override
    public int compareTo(Object o) {
        Process p = (Process) o;
        return this.serviceTimeNeeded < p.serviceTimeNeeded ? -1 : 1;
    }

    public void calculate() {
        this.TAT = (endTime - arrivalTime);
        this.normTAT = (double) this.TAT / serviceTimeNeeded;
        this.waitTime = endTime - arrivalTime - serviceTimeNeeded;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

}