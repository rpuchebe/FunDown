package com.example.raimundoj.fundown;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Depor extends AppCompatActivity implements View.OnClickListener {

    ImageView shirt;
    ImageView shorts;
    ImageButton shorttest;
    ImageButton shirttest;
    ImageButton box;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depor);
        shirt=(ImageView)findViewById(R.id.shirt);
        shorts=(ImageView)findViewById(R.id.shorts);
        box=(ImageButton)findViewById(R.id.box);
        shirttest=(ImageButton)findViewById(R.id.shirttest);
        shorttest=(ImageButton)findViewById(R.id.shorttest);
        box.setOnClickListener(this);
        shirt.setOnTouchListener(new ChoiceTouchListener());
        shorts.setOnTouchListener(new ChoiceTouchListener());
        shirttest.setOnDragListener(new ChoiceDragListener());
        shorttest.setOnDragListener(new ChoiceDragListener());
    }

    private final class ChoiceTouchListener implements View.OnTouchListener {


        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                //start dragging the item touched
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
            else {
                return false;
            }
        }
    }

    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:
                    //handle the dragged view being dropped over a drop view

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }
            return false;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.box:

                shirt.setVisibility(View.VISIBLE);
                shorts.setVisibility(View.VISIBLE);

                break;

        }

    }
}
