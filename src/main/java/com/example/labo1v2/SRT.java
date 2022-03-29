package com.example.labo1v2;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//shortest Remaining Time
public class SRT extends Scheduler {
    @Override
    public PriorityQueue<Process> schedule(Queue<Process> input) {
        Queue<Process> que = new LinkedList<>();
        for (Process p : input) {
            que.add(new Process(p));
        }
        PriorityQueue<Process> finishedProcesses = new PriorityQueue<>();
        PriorityQueue<Process> waitingProcesses = new PriorityQueue<Process>(10,(a, b)->a.getServicetime()-b.getServicetime());
        PriorityQueue<Process> currentProcess = new PriorityQueue<>();
        Process temp;

        int count = 0;

        while(finishedProcesses.size()!=input.size()){
            if(!currentProcess.isEmpty()){
                temp=currentProcess.peek();
                temp.verminder(1);
                if (temp.getServicetime()==0){
                    temp=currentProcess.poll();
                    temp.setEndtime(count);
                    temp.calculate();

                    finishedProcesses.add(temp);
                    waittime += temp.getWaittime();
                    normtat += temp.getNormtat();
                    tat += temp.getTat();
                }
            }
            while(que.peek() != null && que.peek().getArrivaltime()<=count)
                waitingProcesses.add(que.poll());
            if(currentProcess.isEmpty() && !waitingProcesses.isEmpty()){
                temp=waitingProcesses.poll();
                temp.setStartTime(count);
                currentProcess.add(temp);

            } else if (!currentProcess.isEmpty() && !waitingProcesses.isEmpty()){
                temp=currentProcess.peek();
                if(temp.getServicetimeNeeded()>waitingProcesses.peek().getServicetimeNeeded()){
                    temp=currentProcess.poll();
                    Process p=waitingProcesses.peek();
                    if(p.getStartTime()==0)
                        p.setStartTime(count);

                    currentProcess.add(waitingProcesses.poll());
                    waitingProcesses.add(temp);
                }
            }

            count++;

        }
        waittime = waittime / input.size();
        normtat = normtat / input.size();
        tat = tat / input.size();

        StringBuffer sb = new StringBuffer();

        sb.append("Glob parameters SRT ");
        sb.append(waittime + " " + normtat + " " + tat + " ");

        System.out.println(sb.toString());

        return finishedProcesses;
    }

    @Override
    public PriorityQueue<Process> schedule(Queue<Process> q, int slice) {
        return schedule(q);
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
