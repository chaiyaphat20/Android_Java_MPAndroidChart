package com.rudy.java_mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    List<PieEntry> pieEntryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieEntryList = new ArrayList();
        pieChart = findViewById(R.id.chart);
        setValue();
        setupChart();
    }

    private ArrayList<Integer> generateColorsPieChart(){
        final int[] MY_COLORS = {Color.parseColor("#FFA500"),Color.parseColor("#0077B6"),Color.parseColor("#0B2545")};
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for(int c: MY_COLORS) colors.add(c);
        return  colors;
    }

    private void setupChart(){
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Pie Chart");
        PieData pieData = new PieData(pieDataSet);
        pieDataSet.setColors(generateColorsPieChart());
        pieDataSet.setValueTextColor(getResources().getColor(R.color.white));
        pieDataSet.setValueTextSize(16f);
        pieDataSet.setValueFormatter(new DefaultAxisValueFormatter(0));//set ทศนิยม 1 ตำแหน่ง

        pieChart.getLegend().setEnabled(false); //ปิดไม่ให้โชว์ คำอธิบายสี
        pieChart.setData(pieData);
        pieChart.setHoleRadius(65); //ความกว้างของรู
        pieChart.setRotationEnabled(false); //ไม่ให้ หมุน pie chart ได้
        pieChart.setRotationAngle(180);
        pieChart.getDescription().setEnabled(false); //ปิดคำอธิบาย
        pieChart.invalidate();
    }

    private void setValue(){
        PieEntry pieChart1 = new PieEntry(20);
        PieEntry pieChart2 = new PieEntry(20);
        PieEntry pieChart3 = new PieEntry(40);
        pieEntryList.add(pieChart1);
        pieEntryList.add(pieChart2);
        pieEntryList.add(pieChart3);
    }
}