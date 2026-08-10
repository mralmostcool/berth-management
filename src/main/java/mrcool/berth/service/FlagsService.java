package mrcool.berth.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.model.Flags;
import mrcool.berth.repository.FlagsRepository;

@Service
@RequiredArgsConstructor
public class FlagsService {

    private final FlagsRepository flagsRepository;

    public String getFlagNameById(UUID id) {
        String name = flagsRepository.findNameById(id);
        return name;
    }

    public Flags findById(UUID id) throws Exception {
        return flagsRepository.findById(id).orElseThrow(() -> new Exception("Entry not found!"));
    }

}
