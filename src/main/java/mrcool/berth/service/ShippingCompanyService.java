package mrcool.berth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mrcool.berth.repository.ShippingCompanyRepository;

@Service
@RequiredArgsConstructor
public class ShippingCompanyService {

    private final ShippingCompanyRepository shippingCompanyRepository;

}
