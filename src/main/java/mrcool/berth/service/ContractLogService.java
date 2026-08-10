package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.ContractLogRepository;

@Service
@RequiredArgsConstructor
public class ContractLogService {

    private final ContractLogRepository contractLogRepository;

}
