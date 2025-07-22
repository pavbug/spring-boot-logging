package com.javatechie.spring.logging.api;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class MarkerFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        Marker markerToMatch = MarkerFactory.getMarker("PERF");

        if (nonNull(event.getMarkerList()) && event.getMarkerList().contains(markerToMatch)) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }
}
