package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.BerthRepository;

@Service
@RequiredArgsConstructor
public class BerthService {

    private final BerthRepository berthRepository;

}
