package com.el.designPatterns.mediator;

public interface Mediator {
    void Register(String colleagueName, Colleague colleague);

    void GetMessage(int stateChange, String colleagueName);

    void SendMessage();
}
