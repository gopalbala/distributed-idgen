package com.gb.didgen.service;

import com.gb.didgen.exception.ClockMovedBackException;
import com.gb.didgen.exception.NodeIdOutOfBoundException;

public interface IdGenerator {
    long generateId() throws ClockMovedBackException, NodeIdOutOfBoundException;
}
