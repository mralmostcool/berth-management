package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.AllocationRepository;

@Service
@RequiredArgsConstructor
public class AllocationService {

    private final AllocationRepository allocationRepository;

}
