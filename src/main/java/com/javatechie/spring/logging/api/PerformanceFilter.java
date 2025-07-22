package com.javatechie.spring.logging.api;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.List;

import static java.util.Objects.isNull;

public class PerformanceFilter extends Filter<ILoggingEvent> {
    private boolean invert;

    public void setInvert(boolean invert) {
        this.invert = invert;
    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        return accept(event) ? FilterReply.ACCEPT : FilterReply.DENY;
    }

    private boolean accept(ILoggingEvent event) {
        if (!invert) {
            return containsMarker(event);
        }
        return !containsMarker(event);
    }

    private boolean containsMarker(ILoggingEvent event) {
        List<Marker> markers = event.getMarkerList();
        if (isNull(markers) || markers.isEmpty()) {
            return false;
        }
        Marker markerToMatch = MarkerFactory.getMarker("PERF");
        return markers.contains(markerToMatch);
    }
}
