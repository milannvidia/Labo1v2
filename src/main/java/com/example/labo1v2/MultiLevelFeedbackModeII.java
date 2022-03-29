package com.example.labo1v2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MultiLevelFeedbackModeII extends Scheduler{
    public void update(Process temp) {
        waittime += temp.getWaitTime();
        normtat += temp.getNormTAT();
        tat += temp.getTAT();
    }

    @Override
    public PriorityQueue<Process> schedule(Queue<Process> para) {
        Queue<Process> q = new LinkedList<>();
        for (Process p : para) {
            q.add(new Process(p));
        }
        Queue<Process> queue1 = new LinkedList();
        Queue<Process> queue2 = new LinkedList();
        Queue<Process> queue4 = new LinkedList();
        Queue<Process> queue8 = new LinkedList();
        PriorityQueue<Process> result = new PriorityQueue<>();
        int count = 0;
        while (!q.isEmpty() || !queue1.isEmpty() || !queue2.isEmpty() || !queue4.isEmpty() || !queue8.isEmpty()) {
            Process temp = new Process();
            if (queue1.isEmpty() && queue2.isEmpty() && queue4.isEmpty() && queue8.isEmpty() && !q.isEmpty()) {
                temp = q.poll();
                count = temp.getArrivalTime();
                temp.setArrivalTime(count);
                queue1.add(temp);
            }
            while (!q.isEmpty() && q.peek().getArrivalTime() <= count) {
                temp = q.poll();
                temp.setStartTime(count);
                queue1.add(temp);
            }
            if (!queue1.isEmpty()) {
                temp = queue1.poll();
                if (temp.getServiceTime() <= 1) {
                    count += 1;
                    temp.setEndTime(count);
                    temp.calculate();
                    result.add(temp);
                    update(temp);
                } else {
                    count += 1;
                    temp.decreaseServiceTime(1);
                    queue2.add(temp);
                }
            } else if (!queue2.isEmpty()) {
                temp = queue2.poll();
                if (temp.getServiceTime() <= 2) {
                    count += temp.getServiceTime();
                    temp.setEndTime(count);
                    temp.calculate();
                    result.add(temp);
                    update(temp);
                } else {
                    count += 2;
                    temp.decreaseServiceTime(2);
                    queue4.add(temp);
                }
            } else if (!queue4.isEmpty()) {
                temp = queue4.poll();
                if (temp.getServiceTime() <= 4) {
                    count += temp.getServiceTime();
                    temp.setEndTime(count);
                    temp.calculate();
                    result.add(temp);
                    update(temp);
                } else {
                    count += 4;
                    temp.decreaseServiceTime(4);
                    queue8.add(temp);
                }
            } else if (!queue8.isEmpty()) {
                temp = queue8.poll();
                if (temp.getServiceTime() <= 8) {
                    count += temp.getServiceTime();
                    temp.setEndTime(count);
                    temp.calculate();
                    result.add(temp);
                    update(temp);
                } else {
                    count += 8;
                    temp.decreaseServiceTime(8);
                    queue8.add(temp);
                }
            }
        }

        waittime = waittime / para.size();
        normtat = normtat / para.size();
        tat = tat / para.size();

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
