package com.example.labo1v2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//RoundRobin
public class RR extends Scheduler{
    int delta;

    public RR(int i) {
        delta = i;
    }

    @Override
    public PriorityQueue<Process> schedule(Queue<Process> queue) {
        Queue<Process> q = new LinkedList<>();
        for (Process p : queue) {
            q.add(new Process(p));
        }
        PriorityQueue<Process> result = new PriorityQueue<>();
        Queue<Process> waitingQueue = new LinkedList();
        int count = 0;

        while (!q.isEmpty() || !waitingQueue.isEmpty()) {
            Process p;
            if (!q.isEmpty() && waitingQueue.isEmpty()) {
                p = q.poll();
                count = p.getArrivalTime();
                p.setStartTime(count);
            } else {
                p = waitingQueue.poll();
            }

            if (p.getServiceTime() <= delta) {
                count += p.getServiceTime();
                while (!q.isEmpty() && q.peek().getArrivalTime() <= count) {
                    Process current = q.poll();
                    current.setStartTime(count);
                    waitingQueue.add(current);
                }
                p.setEndTime(count);
                p.calculate();
                result.add(p);
                waittime += p.getWaitTime();
                normtat += p.getNormTAT();
                tat += p.getTAT();
            } else {
                count += delta;
                while (!q.isEmpty() && q.peek().getArrivalTime() <= count) {
                    Process current = q.poll();
                    current.setStartTime(count);
                    waitingQueue.add(current);
                }
                p.setServiceTime(p.getServiceTime() - delta);
                waitingQueue.add(p);
            }
        }

        waittime = waittime / queue.size();
        normtat = normtat / queue.size();
        tat = tat / queue.size();



        return result;
    }

    @Override
    public double[] getParameters() {
        double [] current = new double[3];
        current[0]= waittime;
        current[1]= normtat;
        current[2] = tat;
        return current;
    }
}
