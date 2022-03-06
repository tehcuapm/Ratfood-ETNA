package com.example.ratfoodapp.models;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ratfoodapp.views.RestaurantsActivity;

import org.w3c.dom.Text;

public class ProgressBarAnimation extends Animation {
    private Context context;
    private ProgressBar progressBar;
    private TextView text;
    private float from,to;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, TextView text, float from, float to){
        this.context = context;
        this.progressBar = progressBar;
        this.from = from;
        this.text = text;
        this.to = to;
    }
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t){
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to-from) * interpolatedTime;
        progressBar.setProgress((int)value);
        text.setText((int)value +"%");

        if(value == to){context.startActivity(new Intent(context, RestaurantsActivity.class));}
    }
}
