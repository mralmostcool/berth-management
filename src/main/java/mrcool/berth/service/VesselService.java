package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.VesselRepository;

@Service
@RequiredArgsConstructor
public class VesselService {

    private final VesselRepository vesselRepository;

}
