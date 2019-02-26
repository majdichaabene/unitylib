package com.mc.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.mc.unitylib.R;
import com.mc.unitylib.UnityView;

public class MainActivity extends AppCompatActivity {

    private UnityView unityView;
    private ToggleButton btnStartStop;
    private ToggleButton btnPauseResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }
    private void initView(){
        unityView =  findViewById(R.id.custom_unity_view);
        btnStartStop = findViewById(R.id.btn_start_stop);
        btnPauseResume = findViewById(R.id.btn_pause_resume);
    }
    private void setEvent() {
        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton) view).isChecked();
                if (on){
                    unityView.start();
                    btnPauseResume.setVisibility(View.VISIBLE);
                }
                else{
                    unityView.stop();
                    btnPauseResume.setVisibility(View.GONE);
                }
            }
        });
        btnPauseResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton) view).isChecked();
                if (on){
                    unityView.pause();
                }
                else
                    unityView.resume();
            }
        });
    }
}
