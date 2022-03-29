package com.example.labo1v2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Shortest Job First
public class SJF extends Scheduler{
    @Override
    public PriorityQueue<Process> schedule(Queue<Process> input){
        Queue<Process> queue =new LinkedList<>();

        for (Process p: input){
            queue.add(new Process(p));
        }

        PriorityQueue<Process> finishedProcesses = new PriorityQueue<>();
        PriorityQueue<Process> waitingProcesses = new PriorityQueue<Process>(10,(a, b)->a.getServicetime()-b.getServicetime());

        Process temp;
        int count=0;

        while (finishedProcesses.size() != input.size()){
            while (queue.peek() != null && queue.peek().getArrivaltime()<=count)
                waitingProcesses.add(queue.poll());
                if (!waitingProcesses.isEmpty()) {
                    temp = waitingProcesses.poll();
                    temp.setStartTime(count);
                    count += temp.getServicetime();
                    temp.setEndtime(count);
                    temp.calculate();
                    finishedProcesses.add(temp);
                    waittime += temp.getWaittime();
                    normtat += temp.getNormtat();
                    tat += temp.getTat();
                }else{
                    count++;
                }
            }
            waittime=waittime/input.size();
            normtat=normtat/ input.size();
            tat=tat/ input.size();
            StringBuffer sb=new StringBuffer();
            sb.append("Glob parameters SJF ");
            sb.append(waittime + " " + normtat + " " + tat + " ");
            System.out.println(sb.toString());
            return finishedProcesses;
        }

        @Override
        public PriorityQueue<Process> schedule(Queue<Process> queue, int slice){
            return schedule(queue);
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

