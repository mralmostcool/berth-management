package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.PreSeaCourseRepository;

@Service
@RequiredArgsConstructor
public class PreSeaCourseService {

    private final PreSeaCourseRepository preSeaCourseRepository;

}
