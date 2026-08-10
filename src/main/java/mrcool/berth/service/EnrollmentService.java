package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.EnrollmentRepository;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

}
