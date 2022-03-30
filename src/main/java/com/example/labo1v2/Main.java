package com.example.labo1v2;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Process scheduler");
        final NumberAxis x2 = new NumberAxis();
        final NumberAxis y2 = new NumberAxis();
        final NumberAxis x = new NumberAxis();
        final NumberAxis y = new NumberAxis(0, 100, 10);
        final NumberAxis x4 = new NumberAxis();
        final NumberAxis y4 = new NumberAxis();
        final NumberAxis x3 = new NumberAxis();
        final NumberAxis y3 = new NumberAxis(0, 100, 10);
        final NumberAxis x6 = new NumberAxis();
        final NumberAxis y6 = new NumberAxis();
        final NumberAxis x5 = new NumberAxis();
        final NumberAxis y5 = new NumberAxis(0, 100, 10);

        y.setLabel("Norm omlooptijd");
        x.setLabel("Bedieningstijd");
        y2.setLabel("Wachttijd");
        x2.setLabel("Bedieningstijd");
        y3.setLabel("Norm omlooptijd");
        x3.setLabel("Bedieningstijd");
        y4.setLabel("Wachttijd");
        x4.setLabel("Bedieningstijd");
        y5.setLabel("Norm omlooptijd");
        x5.setLabel("Bedieningstijd");
        y6.setLabel("Wachttijd");
        x6.setLabel("Bedieningstijd");

        final LineChart<Number, Number> lineChart1 = new LineChart<Number, Number>(x, y);
        lineChart1.setTitle("normTAT functie van bedieningstijd /20000");
        lineChart1.setCreateSymbols(false);

        final LineChart<Number, Number> lineChart2 = new LineChart<Number, Number>(x2, y2);
        lineChart2.setTitle("Wachttijd in functie van bedieningstijd /20000");
        lineChart2.setCreateSymbols(false);

        final LineChart<Number, Number> lineChart3 = new LineChart<Number, Number>(x3, y3);
        lineChart3.setTitle("normTAT in functie van bedieningstijd /10000");
        lineChart3.setCreateSymbols(false);

        final LineChart<Number, Number> lineChart4 = new LineChart<Number, Number>(x4, y4);
        lineChart4.setTitle("Wachttijd in functie van bedieningstijd /10000");
        lineChart4.setCreateSymbols(false);

        final LineChart<Number, Number> lineChart5 = new LineChart<Number, Number>(x5, y5);
        lineChart5.setTitle("normTAT in functie van bedieningstijd /50000");
        lineChart5.setCreateSymbols(false);

        final LineChart<Number, Number> lineChart6 = new LineChart<Number, Number>(x6, y6);
        lineChart6.setTitle("Wachttijd in functie van bedieningstijd /50000");
        lineChart6.setCreateSymbols(false);

        XYChart.Series series1_1 = new XYChart.Series();
        series1_1.setName("FIFO");
        XYChart.Series series1_2 = new XYChart.Series();
        series1_2.setName("RR");
        XYChart.Series series1_3 = new XYChart.Series();
        series1_3.setName("HRRN");
        XYChart.Series series1_4 = new XYChart.Series();
        series1_4.setName("MLFB");
        XYChart.Series series1_5 = new XYChart.Series();
        series1_5.setName("SJF");
        XYChart.Series series1_6 = new XYChart.Series();
        series1_6.setName("SRT");
        XYChart.Series series2_1 = new XYChart.Series();
        series2_1.setName("FIFO");
        XYChart.Series series2_2 = new XYChart.Series();
        series2_2.setName("RR");
        XYChart.Series series2_3 = new XYChart.Series();
        series2_3.setName("HRRN");
        XYChart.Series series2_4 = new XYChart.Series();
        series2_4.setName("MLFB");
        XYChart.Series series2_5 = new XYChart.Series();
        series2_5.setName("SJF");
        XYChart.Series series2_6 = new XYChart.Series();
        series2_6.setName("SRT");
        XYChart.Series series3_1 = new XYChart.Series();
        series3_1.setName("FIFO");
        XYChart.Series series3_2 = new XYChart.Series();
        series3_2.setName("RR");
        XYChart.Series series3_3 = new XYChart.Series();
        series3_3.setName("HRRN");
        XYChart.Series series3_4 = new XYChart.Series();
        series3_4.setName("MLFB");
        XYChart.Series series3_5 = new XYChart.Series();
        series3_5.setName("SJF");
        XYChart.Series series3_6 = new XYChart.Series();
        series3_6.setName("SRT");
        XYChart.Series series4_1 = new XYChart.Series();
        series4_1.setName("FIFO");
        XYChart.Series series4_2 = new XYChart.Series();
        series4_2.setName("RR");
        XYChart.Series series4_3 = new XYChart.Series();
        series4_3.setName("HRRN");
        XYChart.Series series4_4 = new XYChart.Series();
        series4_4.setName("MLFB");
        XYChart.Series series4_5 = new XYChart.Series();
        series4_5.setName("SJF");
        XYChart.Series series4_6 = new XYChart.Series();
        series4_6.setName("SRT");
        XYChart.Series series5_1 = new XYChart.Series();
        series5_1.setName("FIFO");
        XYChart.Series series5_2 = new XYChart.Series();
        series5_2.setName("RR");
        XYChart.Series series5_3 = new XYChart.Series();
        series5_3.setName("HRRN");
        XYChart.Series series5_4 = new XYChart.Series();
        series5_4.setName("MLFB");
        XYChart.Series series5_5 = new XYChart.Series();
        series5_5.setName("SJF");
        XYChart.Series series5_6 = new XYChart.Series();
        series5_6.setName("SRT");
        XYChart.Series series6_1 = new XYChart.Series();
        series6_1.setName("FIFO");
        XYChart.Series series6_2 = new XYChart.Series();
        series6_2.setName("RR");
        XYChart.Series series6_3 = new XYChart.Series();
        series6_3.setName("HRRN");
        XYChart.Series series6_4 = new XYChart.Series();
        series6_4.setName("MLFB");
        XYChart.Series series6_5 = new XYChart.Series();
        series6_5.setName("SJF");
        XYChart.Series series6_6 = new XYChart.Series();
        series6_6.setName("SRT");

        ProcessReader fact = new ProcessReader();
        Queue<Process> processen1 = fact.leesProcessen("50000");
        Queue<Process> processen2 = fact.leesProcessen("20000");
        Queue<Process> processen3 = fact.leesProcessen("10000");

        Scheduler fifo = new FIFO();
        PriorityQueue<Process> firstinfirstout = fifo.schedule(processen2);

        int procentSize = firstinfirstout.size() / 100;
        double waitTime = 0;
        Process process;
        double normTAT = 0;
        int amount = 0;

        while (!firstinfirstout.isEmpty()) {
            process = firstinfirstout.poll();
            waitTime += process.getWaitTime();
            normTAT += process.getNormTAT();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series1_1.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series2_1.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                waitTime = 0;
                normTAT = 0;
            }
            amount++;
        }

        Scheduler rr = new RR(2);
        PriorityQueue<Process> roundrobin = rr.schedule(processen2);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!roundrobin.isEmpty()) {
            process = roundrobin.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series1_2.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series2_2.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        Scheduler hrrn = new HRRN();
        PriorityQueue<Process> highestresponserationext = hrrn.schedule(processen2);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!highestresponserationext.isEmpty()) {
            process = highestresponserationext.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series1_3.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series2_3.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        Scheduler mlfb = new MultiLevelFeedbackModeII();
        PriorityQueue<Process> multilevelfeedback = mlfb.schedule(processen2);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!multilevelfeedback.isEmpty()) {
            process = multilevelfeedback.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series1_4.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series2_4.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        Scheduler sjf = new SJF();
        PriorityQueue<Process> shortestJobFirst = sjf.schedule(processen2);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!shortestJobFirst.isEmpty()) {
            process = shortestJobFirst.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series1_5.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series2_5.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        Scheduler srt = new SRT();
        PriorityQueue<Process> shortestRemainingTime = srt.schedule(processen2);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!shortestRemainingTime.isEmpty()) {
            process = shortestRemainingTime.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series1_6.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series2_6.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        firstinfirstout = fifo.schedule(processen3);
        normTAT = 0;
        amount = 0;
        waitTime = 0;
        procentSize = processen3.size() / 100;
        while (!firstinfirstout.isEmpty()) {
            process = firstinfirstout.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series3_1.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series4_1.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        roundrobin = rr.schedule(processen3);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!roundrobin.isEmpty()) {
            process = roundrobin.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series3_2.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series4_2.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        highestresponserationext = hrrn.schedule(processen3);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!highestresponserationext.isEmpty()) {
            process = highestresponserationext.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series3_3.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series4_3.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        multilevelfeedback = mlfb.schedule(processen3);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!multilevelfeedback.isEmpty()) {
            process = multilevelfeedback.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series3_4.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series4_4.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        shortestJobFirst = sjf.schedule(processen3);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!shortestJobFirst.isEmpty()) {
            process = shortestJobFirst.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series3_5.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series4_5.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        shortestRemainingTime = srt.schedule(processen3);
        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!shortestRemainingTime.isEmpty()) {
            process = shortestRemainingTime.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series3_6.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series4_6.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        firstinfirstout = fifo.schedule(processen1);
        normTAT = 0;
        amount = 0;
        waitTime = 0;
        procentSize = processen1.size() / 100;
        while (!firstinfirstout.isEmpty()) {
            process = firstinfirstout.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series5_1.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series6_1.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        roundrobin = rr.schedule(processen1);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!roundrobin.isEmpty()) {
            process = roundrobin.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series5_2.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series6_2.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        highestresponserationext = hrrn.schedule(processen1);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!highestresponserationext.isEmpty()) {
            process = highestresponserationext.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series5_3.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series6_3.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        multilevelfeedback = mlfb.schedule(processen1);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!multilevelfeedback.isEmpty()) {
            process = multilevelfeedback.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series5_4.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series6_4.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        shortestJobFirst = sjf.schedule(processen1);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!shortestJobFirst.isEmpty()) {
            process = shortestJobFirst.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series5_5.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series6_5.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        shortestRemainingTime = srt.schedule(processen1);

        normTAT = 0;
        amount = 0;
        waitTime = 0;
        while (!shortestRemainingTime.isEmpty()) {
            process = shortestRemainingTime.poll();
            normTAT += process.getNormTAT();
            waitTime += process.getWaitTime();
            if (amount % procentSize == 0 && amount != 0) {
                normTAT = normTAT / procentSize;
                waitTime = waitTime / procentSize;
                series5_6.getData().add(new XYChart.Data(amount / procentSize, normTAT));
                series6_6.getData().add(new XYChart.Data(amount / procentSize, waitTime));
                normTAT = 0;
                waitTime = 0;
            }
            amount++;
        }

        VBox vbox = new VBox();
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        VBox labels = new VBox();
        hbox1.getChildren().addAll(lineChart3,lineChart1, lineChart5, labels);
        hbox2.getChildren().addAll(lineChart4, lineChart2, lineChart6);

        vbox.getChildren().addAll(hbox1, hbox2);

        BorderPane root = new BorderPane();
        root.setCenter(vbox);

        Scene scene = new Scene(root, 1000, 800);
        lineChart1.getData().addAll(series1_1, series1_2, series1_3, series1_4, series1_5, series1_6);
        lineChart2.getData().addAll(series2_1, series2_2, series2_3, series2_4, series2_5, series2_6);
        lineChart3.getData().addAll(series3_1, series3_2, series3_3, series3_4, series3_5, series3_6);
        lineChart4.getData().addAll(series4_1, series4_2, series4_3, series4_4, series4_5, series4_6);
        lineChart5.getData().addAll(series5_1, series5_2, series5_3, series5_4, series5_5, series5_6);
        lineChart6.getData().addAll(series6_1, series6_2, series6_3, series6_4, series6_5, series6_6);

        stage.setScene(scene);
        stage.show();

    }
}