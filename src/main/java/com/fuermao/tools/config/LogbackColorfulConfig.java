package com.fuermao.tools.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

public class LogbackColorfulConfig extends ForegroundCompositeConverterBase<ILoggingEvent> {

    @Override
    protected String getForegroundColorCode(ILoggingEvent iLoggingEvent) {
        String color;
        Level level = iLoggingEvent.getLevel();
        switch (level.toInt()) {
            case Level.ERROR_INT:
                color = ANSIConstants.RED_FG;
                break;
            case Level.WARN_INT:
                color = ANSIConstants.YELLOW_FG;
                break;
            case Level.INFO_INT:
                color = ANSIConstants.BLUE_FG;
                break;
            case Level.DEBUG_INT:
                color = ANSIConstants.GREEN_FG;
                break;
            default:
                color = ANSIConstants.WHITE_FG;
                break;
        }
        return color;
    }
}
