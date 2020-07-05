package com.gb.didgen.service;

import com.gb.didgen.exception.ClockMovedBackException;

public interface IdGenerator {
    long generateId() throws ClockMovedBackException;
}
