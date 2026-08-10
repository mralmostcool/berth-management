package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.FlagsRepository;

@Service
@RequiredArgsConstructor
public class FlagsService {

    private final FlagsRepository flagsRepository;

}
