package com.company;

public interface IAbstractFactory {
    IPassangerDriver getPassangerDriver();
    ILuggageDriver getLuggageDriver();
    IDispatcher getDispatcher();
}
