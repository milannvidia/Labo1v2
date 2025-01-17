package com.example.labo1v2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MultiLevelFeedbackModeII extends Scheduler{
    public void update(Process current) {
        waittime += current.getWaitTime();
        normtat += current.getNormTAT();
        tat += current.getTAT();
    }

    @Override
    public PriorityQueue<Process> schedule(Queue<Process> queue) {
        Queue<Process> q = new LinkedList<>();
        for (Process p : queue) {
            q.add(new Process(p));
        }
        Queue<Process> queue1 = new LinkedList();
        Queue<Process> queue2 = new LinkedList();
        Queue<Process> queue4 = new LinkedList();
        Queue<Process> queue8 = new LinkedList();
        PriorityQueue<Process> result = new PriorityQueue<>();
        int count = 0;
        while (!q.isEmpty() || !queue1.isEmpty() || !queue2.isEmpty() || !queue4.isEmpty() || !queue8.isEmpty()) {
            Process current = new Process();
            if (queue1.isEmpty() && queue2.isEmpty() && queue4.isEmpty() && queue8.isEmpty() && !q.isEmpty()) {
                current = q.poll();
                count = current.getArrivalTime();
                current.setArrivalTime(count);
                queue1.add(current);
            }
            while (!q.isEmpty() && q.peek().getArrivalTime() <= count) {
                current = q.poll();
                current.setStartTime(count);
                queue1.add(current);
            }
            if (!queue1.isEmpty()) {
                current = queue1.poll();
                if (current.getServiceTime() <= 1) {
                    count += 1;
                    current.setEndTime(count);
                    current.calculate();
                    result.add(current);
                    update(current);
                } else {
                    count += 1;
                    current.decreaseServiceTime(1);
                    queue2.add(current);
                }
            } else if (!queue2.isEmpty()) {
                current = queue2.poll();
                if (current.getServiceTime() <= 2) {
                    count += current.getServiceTime();
                    current.setEndTime(count);
                    current.calculate();
                    result.add(current);
                    update(current);
                } else {
                    count += 2;
                    current.decreaseServiceTime(2);
                    queue4.add(current);
                }
            } else if (!queue4.isEmpty()) {
                current = queue4.poll();
                if (current.getServiceTime() <= 4) {
                    count += current.getServiceTime();
                    current.setEndTime(count);
                    current.calculate();
                    result.add(current);
                    update(current);
                } else {
                    count += 4;
                    current.decreaseServiceTime(4);
                    queue8.add(current);
                }
            } else if (!queue8.isEmpty()) {
                current = queue8.poll();
                if (current.getServiceTime() <= 8) {
                    count += current.getServiceTime();
                    current.setEndTime(count);
                    current.calculate();
                    result.add(current);
                    update(current);
                } else {
                    count += 8;
                    current.decreaseServiceTime(8);
                    queue8.add(current);
                }
            }
        }

        waittime = waittime / queue.size();
        normtat = normtat / queue.size();
        tat = tat / queue.size();

        System.out.println("Multilevel feedback met waarde q = 2^i");
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
