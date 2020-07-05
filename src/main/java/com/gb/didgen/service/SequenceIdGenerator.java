package com.gb.didgen.service;

import com.gb.didgen.exception.ClockMovedBackException;
import com.gb.didgen.exception.NodeIdOutOfBoundException;
import org.springframework.stereotype.Service;

@Service
public interface SequenceIdGenerator {
    long generateId() throws ClockMovedBackException, NodeIdOutOfBoundException;
}
