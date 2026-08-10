package mrcool.berth.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import mrcool.berth.model.Flags;
import mrcool.berth.repository.FlagsRepository;

@Service
@RequiredArgsConstructor
public class FlagsService {

    private final FlagsRepository flagsRepository;

    public List<Flags> getAllFlags() {
        return flagsRepository.findAll();
    }

    public Flags getFlagById(UUID id) {
        return flagsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Flag not found with ID: " + id));
    }

}
