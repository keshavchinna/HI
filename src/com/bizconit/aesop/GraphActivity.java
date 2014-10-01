package com.bizconit.aesop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.google.gson.Gson;
import com.jjoe64.graphview.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 29/9/14
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphActivity extends Activity {
  private String[] dates;
  private int[] values;
  private String productName;
  private GraphView.GraphViewData[] graphData;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.graph_layout);
    dates = getIntent().getStringArrayExtra("dates");
    values = getIntent().getIntArrayExtra("values");
    productName = getIntent().getStringExtra("productName");
    getActionBar().setTitle(productName);
    LinearLayout rootView = (LinearLayout) findViewById(R.id.root);
    GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[]{
        new GraphView.GraphViewData(1, values[0])
        , new GraphView.GraphViewData(2, values[1])
        , new GraphView.GraphViewData(3, values[2])
        , new GraphView.GraphViewData(4, values[3])
    });

    LineGraphView graphView = new LineGraphView(this, productName + " Inventory");
    graphView.addSeries(exampleSeries);
    graphView.setManualYAxisBounds(100, 0);
    graphView.setHorizontalLabels(dates);
    graphView.setDrawDataPoints(true);
    graphView.setDataPointsRadius(5.0f);
    graphView.setDrawBackground(true);
    graphView.getGraphViewStyle().setTextSize(14);
    graphView.getGraphViewStyle().getGridStyle().drawHorizontal();
    graphView.getGraphViewStyle().setNumHorizontalLabels(4);
    graphView.getGraphViewStyle().setNumVerticalLabels(11);
    rootView.addView(graphView);
  }
}
