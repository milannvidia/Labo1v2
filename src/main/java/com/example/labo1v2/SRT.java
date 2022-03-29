package com.example.labo1v2;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//shortest Remaining Time
public class SRT extends Scheduler {
    @Override
    public PriorityQueue<Process> schedule(Queue<Process> q) {
        Queue<Process> queue = new LinkedList<>();
        for (Process p : q) {
            queue.add(new Process(p));
        }
        PriorityQueue<Process> finishedProcesses = new PriorityQueue<>();
        PriorityQueue<Process> waitingProcesses = new PriorityQueue<Process>(10,(a, b)->a.getServiceTime()-b.getServiceTime());
        PriorityQueue<Process> currentProcesses = new PriorityQueue<>();
        Process current;

        int count = 0;

        while(finishedProcesses.size()!=q.size()){
            if(!currentProcesses.isEmpty()){
                current=currentProcesses.peek();
                current.decreaseServiceTime(1);
                if (current.getServiceTime()==0){
                    current=currentProcesses.poll();
                    current.setEndTime(count);
                    current.calculate();

                    finishedProcesses.add(current);
                    waittime += current.getWaitTime();
                    normtat += current.getNormTAT();
                    tat += current.getTAT();
                }
            }
            while(queue.peek() != null && queue.peek().getArrivalTime()<=count)
                waitingProcesses.add(queue.poll());
            if(currentProcesses.isEmpty() && !waitingProcesses.isEmpty()){
                current=waitingProcesses.poll();
                current.setStartTime(count);
                currentProcesses.add(current);

            } else if (!currentProcesses.isEmpty() && !waitingProcesses.isEmpty()){
                current=currentProcesses.peek();
                if(current.getServiceTimeNeeded()>waitingProcesses.peek().getServiceTimeNeeded()){
                    current=currentProcesses.poll();
                    Process p=waitingProcesses.peek();
                    if(p.getStartTime()==0)
                        p.setStartTime(count);

                    currentProcesses.add(waitingProcesses.poll());
                    waitingProcesses.add(current);
                }
            }

            count++;

        }
        waittime = waittime / q.size();
        normtat = normtat / q.size();
        tat = tat / q.size();

        StringBuffer sb = new StringBuffer();

        sb.append("Glob parameters SRT ");
        sb.append(waittime + " " + normtat + " " + tat + " ");

        System.out.println(sb.toString());

        return finishedProcesses;
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
