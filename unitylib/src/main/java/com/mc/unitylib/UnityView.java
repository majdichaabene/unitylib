package com.mc.unitylib;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.unitylib.R;


public class UnityView extends FrameLayout implements IUnityPlayerWrapperObserver {

    private UnityPlayerWrapper unityPlayerWrapper;
    private ViewGroup unityContainer;
    private Context context;

    public UnityView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View v = inflate(context, R.layout.unity_view, this);
        unityContainer = (ViewGroup) v.findViewById(R.id.unity_view);
    }

    public void start(){
        unityPlayerWrapper = new UnityPlayerWrapper((ContextWrapper) context.getApplicationContext());
        unityContainer.addView(unityPlayerWrapper.getView());
        unityPlayerWrapper.addObserver(this);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                unityPlayerWrapper.onStart();
            }
        });
    }

    public void stop(){
        unityContainer.removeView(unityPlayerWrapper.getView());
        unityPlayerWrapper.onStop();
        unityPlayerWrapper.removeObserver(this);
    }

    public void pause(){
        unityPlayerWrapper.onPause();

    }

    public void resume(){
        unityPlayerWrapper.onResume();
    }

    @Override
    public void onUnityQuit() {

    }
}
