package com.example.labo1v2;

import java.util.*;
//First Come First Serve
public class FIFO extends Scheduler{
    @Override
    public PriorityQueue<Process> schedule(Queue<Process> q) throws NullPointerException {
        Queue<Process> queue = new LinkedList<>();
        for (Process process : q) {
            queue.add(new Process(process));
        }

        int count = 0;
        int wait = 0;
        Process current;
        PriorityQueue<Process> result = new PriorityQueue();

        while (!queue.isEmpty()) {
            current = queue.poll();
            if (count < current.getArrivalTime()) {
                count = current.getArrivalTime() + current.getServiceTime();
                current.setStartTime(current.getArrivalTime());
                current.setEndTime(count);
                current.calculate(); // met deze methode ga je in het process zelf de waarden gaan uitrekenen
                result.add(current);
                waittime += current.getWaitTime();
                normtat += current.getNormTAT();
                tat += current.getTAT();
            } else {
                current.setStartTime(count);
                count += current.getServiceTime();
                current.setEndTime(count);
                current.calculate();
                result.add(current);
                waittime += current.getWaitTime();
                normtat += current.getNormTAT();
                tat += current.getTAT();
            }

        }

        waittime = waittime / q.size();
        normtat = normtat / q.size();
        tat = tat / q.size();

        return result;
    }

    @Override
    public double[] getParameters() {
        double [] temp = new double[3];
        temp[0]= waittime;
        temp[1]= normtat;
        temp[2] = tat;
        return temp;
    }
}
