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
        Process temp;
        PriorityQueue<Process> result = new PriorityQueue();

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (count < temp.getArrivalTime()) {
                count = temp.getArrivalTime() + temp.getServiceTime();
                temp.setStartTime(temp.getArrivalTime());
                temp.setEndTime(count);
                temp.calculate(); // met deze methode ga je in het process zelf de waarden gaan uitrekenen
                result.add(temp);
                waittime += temp.getWaitTime();
                normtat += temp.getNormTAT();
                tat += temp.getTAT();
            } else {
                temp.setStartTime(count);
                count += temp.getServiceTime();
                temp.setEndTime(count);
                temp.calculate();
                result.add(temp);
                waittime += temp.getWaitTime();
                normtat += temp.getNormTAT();
                tat += temp.getTAT();
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
