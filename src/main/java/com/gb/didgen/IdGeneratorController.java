package com.gb.didgen;

import com.gb.didgen.exception.ClockMovedBackException;
import com.gb.didgen.exception.NodeIdOutOfBoundException;
import com.gb.didgen.service.IdGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/id")
public class IdGeneratorController {

    private IdGenerator idGenerator;

    @GetMapping(produces = {"application/JSON"})
    public ResponseEntity<?> getNextId() throws NodeIdOutOfBoundException, ClockMovedBackException {
        return ResponseEntity.ok(idGenerator.generateId());
    }
}
