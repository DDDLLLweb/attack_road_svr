package com.el.designPatterns.observer.resolve;

/**
 * @author Danfeng
 * @since 2018/11/18
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
