package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.DonationEntity;
import se.iths.charity_shop.repository.DonationRepository;
import java.util.Optional;

@Service
public class DonationService {

    DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public DonationEntity createDonation(DonationEntity donationEntity) {
        return donationRepository.save(donationEntity);
    }

    public void deleteDonation(Long id) {
        Optional<DonationEntity> foundDonation = donationRepository.findById(id);
        donationRepository.deleteById(id);
    }

    public Optional<DonationEntity> findDonationById(Long id) {return donationRepository.findById(id);}

    public Iterable<DonationEntity> findAll() {return donationRepository.findAll();}
}