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

        Process current;
        int count=0;

        while (finishedProcesses.size() != q.size()){
            while (queue.peek() != null && queue.peek().getArrivalTime()<=count)
                waitingProcesses.add(queue.poll());
                if (!waitingProcesses.isEmpty()) {
                    current = waitingProcesses.poll();
                    current.setStartTime(count);
                    count += current.getServiceTime();
                    current.setEndTime(count);
                    current.calculate();
                    finishedProcesses.add(current);
                    waittime += current.getWaitTime();
                    normtat += current.getNormTAT();
                    tat += current.getTAT();
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
            double [] current = new double[3];
            current[0]= waittime;
            current[1]= normtat;
            current[2] = tat;
            return current;
        }
    }

