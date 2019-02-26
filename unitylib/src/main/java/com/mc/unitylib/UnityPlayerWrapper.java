package com.mc.unitylib;

import android.content.ContextWrapper;

import com.unity3d.player.UnityPlayer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnityPlayerWrapper extends UnityPlayer {

    private List<IUnityPlayerWrapperObserver> mObservers = new CopyOnWriteArrayList<IUnityPlayerWrapperObserver>();

    public UnityPlayerWrapper(ContextWrapper context) {
        super(context);
    }

    public void addObserver(IUnityPlayerWrapperObserver ob) {
        mObservers.add(ob);
    }

    public void removeObserver(IUnityPlayerWrapperObserver observer) {
        mObservers.remove(observer);
    }

    public void notifyOnUnityQuit() {
        for (IUnityPlayerWrapperObserver observer : mObservers) {
            observer.onUnityQuit();
        }
    }

    public final void onStart() {
        this.requestFocus();
        this.windowFocusChanged(true);
        this.resume();
    }
    public final void onResume() {
        this.resume();
    }

    public void onPause() {
        this.pause();
    }

    public void onStop() {
        this.quit();
    }

    @Override
    public void quit() {
        super.quit();
        notifyOnUnityQuit();
    }

}
