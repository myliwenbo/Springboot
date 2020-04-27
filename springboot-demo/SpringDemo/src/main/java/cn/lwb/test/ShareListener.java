package cn.lwb.test;

public interface ShareListener {

    int STATE_SUCC = 0;
    int STATE_FAIL = 1;

    void onCallback(int state, String msg);
}
