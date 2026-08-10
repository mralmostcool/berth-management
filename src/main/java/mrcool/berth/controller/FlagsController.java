package mrcool.berth.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mrcool.berth.model.Flags;
import mrcool.berth.service.FlagsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/internal/flags")
public class FlagsController {

    private final FlagsService flagsService;

    @GetMapping
    public List<Flags> allFlags() {
        List<Flags> flags = flagsService.getAllFlags();
        return flags;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flags> getFlagById(@PathVariable UUID id) {
        Flags flags = flagsService.getFlagById(id);
        return ResponseEntity.ok(flags);
    }

}
