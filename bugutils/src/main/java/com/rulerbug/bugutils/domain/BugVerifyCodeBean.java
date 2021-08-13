package com.rulerbug.bugutils.domain;

import java.util.Timer;
import java.util.TimerTask;

public class BugVerifyCodeBean {
    public int leftTime = 0;
    public boolean isSend = false;

    public void start(int time) {
        isSend = true;
        leftTime = time;
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                leftTime--;

                if (leftTime <= 0) {
                    isSend = false;
                    if (listener != null) {
                        listener.call(leftTime, isSend);
                    }
                    timer.cancel();
                } else {
                    if (listener != null) {
                        listener.call(leftTime, isSend);
                    }
                }

            }
        };
        timer.schedule(timerTask, 0, 1000);
    }
    private  YZMListener listener;

    public void setListener( YZMListener listener) {
        this.listener = listener;
    }

    public interface YZMListener {
        void call(int leftTime, boolean isSend);
    }
}
