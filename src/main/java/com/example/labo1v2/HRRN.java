package com.example.labo1v2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//Highest Response Ratio Next
public class HRRN extends Scheduler{

    @Override
    public PriorityQueue<Process> schedule(Queue<Process> queue) {
        Queue<Process> q = new LinkedList<>();
        for (Process p : queue) {
            q.add(new Process(p));
        }
        Queue<Process> waitingQueue = new LinkedList<>();
        PriorityQueue<Process> result = new PriorityQueue<>();
        int count = 0;
        Process p;
        while (!q.isEmpty() || !waitingQueue.isEmpty()) {
            while (!q.isEmpty() && q.peek().getArrivalTime() <= count) {
                Process temp = q.poll();
                temp.setStartTime(count);
                waitingQueue.add(temp);
            }
            Process temp = new Process();
            if (!waitingQueue.isEmpty()) {
                double largestTat = waitingQueue.peek().getNormTAT();
                for (Process process : waitingQueue) {
                    process.setEndTime(count + process.getServiceTime());
                    process.calculate();
                    if (largestTat < process.getNormTAT()) {
                        temp = process;
                        largestTat = process.getNormTAT();
                    }
                }
                waitingQueue.remove(temp);
                result.add(temp);
                waittime += temp.getWaitTime();
                normtat += temp.getNormTAT();
                tat += temp.getTAT();
            } else {
                temp = q.poll();
                count = temp.getArrivalTime();
                temp.setStartTime(count);
                temp.setEndTime(count + temp.getServiceTime());
                temp.calculate();
                result.add(temp);
                waittime += temp.getWaitTime();
                normtat += temp.getNormTAT();
                tat += temp.getTAT();
            }

            count += temp.getServiceTime();
        }

        waittime = waittime / queue.size();
        normtat = normtat / queue.size();
        tat = tat / queue.size();

        System.out.println("Highest response ratio next");
        System.out.println("De gemiddelde wachttijd is: " + waittime);
        System.out.println("De gemiddelde genormalisserde omlooptijd is: " + normtat);
        System.out.println("De gemiddelde omlooptijd is: " + tat + "\n");

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
