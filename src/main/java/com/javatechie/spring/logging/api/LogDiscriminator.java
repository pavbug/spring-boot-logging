package com.javatechie.spring.logging.api;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.Discriminator;
import org.slf4j.Marker;

import java.util.List;

public class LogDiscriminator implements Discriminator<ILoggingEvent> {
    @Override
    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        List<Marker> markers = iLoggingEvent.getMarkerList();
        return "";
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }
}
