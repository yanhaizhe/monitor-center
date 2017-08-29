package com.beingmate.monitorcenter.dp.pattern.observer;

import java.util.Observable;

/**
 * @author yanhaizhe
 * @create 2017-03-29 下午 3:50
 **/
public class NewsPaper extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        this.notifyObservers(this.content);
    }
}
