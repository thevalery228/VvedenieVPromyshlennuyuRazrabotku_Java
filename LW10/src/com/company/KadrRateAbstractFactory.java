package com.company;

public class KadrRateAbstractFactory implements IAbstractFactory{

    @Override
    public IPassangerDriver getPassangerDriver() {
        return new PassangerDriver();
    }

    @Override
    public ILuggageDriver getLuggageDriver() {
        return new LuggageDriver();
    }

    @Override
    public IDispatcher getDispatcher() {
        return new Dispatcher();
    }
}
