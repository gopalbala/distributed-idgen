package com.gb.didgen;

import com.gb.didgen.exception.ClockMovedBackException;
import com.gb.didgen.exception.NodeIdOutOfBoundException;
import com.gb.didgen.service.SequenceIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class IdGeneratorController {
    @Autowired
    private SequenceIdGenerator sequenceIdGenerator;

    @GetMapping(produces = {"application/JSON"})
    public ResponseEntity<?> getNextId() throws NodeIdOutOfBoundException, ClockMovedBackException {
        return ResponseEntity.ok(sequenceIdGenerator.generateId());
    }
}
