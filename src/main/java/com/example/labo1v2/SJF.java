package com.example.labo1v2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Shortest Job First
public class SJF extends Scheduler{
    @Override
    public PriorityQueue<Process> schedule(Queue<Process> q){
        Queue<Process> queue =new LinkedList<>();

        for (Process p: q){
            queue.add(new Process(p));
        }

        PriorityQueue<Process> finishedProcesses = new PriorityQueue<>();
        PriorityQueue<Process> waitingProcesses = new PriorityQueue<Process>(10,(a, b)->a.getServiceTime()-b.getServiceTime());

        Process temp;
        int count=0;

        while (finishedProcesses.size() != q.size()){
            while (queue.peek() != null && queue.peek().getArrivalTime()<=count)
                waitingProcesses.add(queue.poll());
                if (!waitingProcesses.isEmpty()) {
                    temp = waitingProcesses.poll();
                    temp.setStartTime(count);
                    count += temp.getServiceTime();
                    temp.setEndTime(count);
                    temp.calculate();
                    finishedProcesses.add(temp);
                    waittime += temp.getWaitTime();
                    normtat += temp.getNormTAT();
                    tat += temp.getTAT();
                }else{
                    count++;
                }
            }
            waittime=waittime/q.size();
            normtat=normtat/ q.size();
            tat=tat/ q.size();
            StringBuffer sb=new StringBuffer();
            sb.append("Glob parameters SJF ");
            sb.append(waittime + " " + normtat + " " + tat + " ");
            System.out.println(sb.toString());
            return finishedProcesses;
        }

        @Override
        public double[] getParameters(){
            double [] temp = new double[3];
            temp[0]= waittime;
            temp[1]= normtat;
            temp[2] = tat;
            return temp;
        }
    }

