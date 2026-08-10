package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.ContractRepository;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

}
