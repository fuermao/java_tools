package com.fuermao.tools.utils;

import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 将异常
 */
public class LogToLogger {
	/**
	 * 根据日志等级将信息输出到日志中
	 * @param logStr String 需要记录的日志信息
	 * @param logger Logger 日志记录器
	 * @param level Level 日志等级
	 */
	public static void log(String logStr,Logger logger,Level level){
		switch (level){
			case TRACE:
				logger.trace(logStr);
				break;
			case WARN:
				logger.warn(logStr);
				break;
			case INFO:
				logger.info(logStr);
				break;
			case DEBUG:
				logger.debug(logStr);
				break;
			case ERROR:
				logger.error(logStr);
				break;
			default:
				String format = String.format("所传入的日志等级（%s）不存在！%n", level);
				throw new EnumConstantNotPresentException(Level.class,format);
		}
	}

	/**
	 * 将异常信息记录到日志中
	 * @param throwable Throwable 异常信息
	 * @param logger Logger 日志记录器
	 */
	public static void throwableToLogger(Throwable throwable, Logger logger){
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		throwable.printStackTrace(printWriter);
		log(stringWriter.toString(),logger,Level.ERROR);
	}
}
