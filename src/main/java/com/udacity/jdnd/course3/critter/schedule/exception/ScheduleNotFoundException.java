package com.udacity.jdnd.course3.critter.schedule.exception;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException() {
        super("Schedule not found");
    }

    public ScheduleNotFoundException(String message) {
        super(message);
    }
}
