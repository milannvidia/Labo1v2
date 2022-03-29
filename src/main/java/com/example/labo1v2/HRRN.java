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
        while (!q.isEmpty() || !waitingQueue.isEmpty()) {
            while (!q.isEmpty() && q.peek().getArrivalTime() <= count) {
                Process temp = q.poll();
                temp.setStartTime(count);
                waitingQueue.add(temp);
            }
            Process current = new Process();
            if (!waitingQueue.isEmpty()) {
                double largestTat = waitingQueue.peek().getNormTAT();
                for (Process process : waitingQueue) {
                    process.setEndTime(count + process.getServiceTime());
                    process.calculate();
                    if (largestTat < process.getNormTAT()) {
                        current = process;
                        largestTat = process.getNormTAT();
                    }
                }
                waitingQueue.remove(current);
                result.add(current);
                waittime += current.getWaitTime();
                normtat += current.getNormTAT();
                tat += current.getTAT();
            } else {
                current = q.poll();
                count = current.getArrivalTime();
                current.setStartTime(count);
                current.setEndTime(count + current.getServiceTime());
                current.calculate();
                result.add(current);
                waittime += current.getWaitTime();
                normtat += current.getNormTAT();
                tat += current.getTAT();
            }

            count += current.getServiceTime();
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
        double [] current = new double[3];
        current[0]= waittime;
        current[1]= normtat;
        current[2] = tat;
        return current;
    }
}
