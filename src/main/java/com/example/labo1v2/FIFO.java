package com.example.labo1v2;
import java.util.*;
//First Come First Serve
public class FIFO extends Scheduler{
    @Override
    public PriorityQueue<Process> schedule(Queue<Process> para) throws NullPointerException {
        Queue<Process> queue = new LinkedList<>();
        for (Process process : para) {
            queue.add(new Process(process));
        }

        int count = 0;
        int wait = 0;
        Process temp;
        PriorityQueue<Process> result = new PriorityQueue();

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (count < temp.getArrivaltime()) {
                count = temp.getArrivaltime() + temp.getServicetime();
                temp.setStartTime(temp.getArrivaltime());
                temp.setEndtime(count);
                temp.calculate(); // met deze methode ga je in het process zelf de waarden gaan uitrekenen
                result.add(temp);
                waittime += temp.getWaittime();
                normtat += temp.getNormtat();
                tat += temp.getTat();
            } else {
                temp.setStartTime(count);
                count += temp.getServicetime();
                temp.setEndtime(count);
                temp.calculate();
                result.add(temp);
                waittime += temp.getWaittime();
                normtat += temp.getNormtat();
                tat += temp.getTat();
            }

        }

        waittime = waittime / para.size();
        normtat = normtat / para.size();
        tat = tat / para.size();

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
