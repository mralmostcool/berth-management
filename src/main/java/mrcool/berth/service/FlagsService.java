package mrcool.berth.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}