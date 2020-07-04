package com.gb.didgen.service;

import com.gb.didgen.exception.NodeIdOutOfBoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;

import static com.gb.didgen.common.Constants.NODE_ID_BIT_LEN;
import static com.gb.didgen.common.Constants.SEQUENCE_BIT_LEN;

@Service
@AllArgsConstructor
public class SnowflakeIdGenerator implements IdGenerator {

    private final int maxSequence = (int) Math.pow(2, SEQUENCE_BIT_LEN);
    private final int maxNodeVal = (int) Math.pow(2, NODE_ID_BIT_LEN);

    private final long EPOCH = Instant.EPOCH.toEpochMilli();

    private final int generatingNodeId;
    private volatile long currentSequence;
    private volatile long lastTimestamp;

    @PostConstruct
    public void checkNodeIdBounds() throws NodeIdOutOfBoundException {
        if (generatingNodeId < 0 || generatingNodeId > maxNodeVal) {
            throw new NodeIdOutOfBoundException("Node id is < 0 or > " + maxNodeVal);
        }
    }

    @Override
    public long generateId() {
        return 0;
    }
}
