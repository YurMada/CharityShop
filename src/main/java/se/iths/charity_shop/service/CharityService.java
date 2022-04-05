package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.CharityEntity;
import se.iths.charity_shop.repository.CharityRepository;
import java.util.Optional;

@Service
public class CharityService {

    CharityRepository charityRepository;

    public CharityService(CharityRepository charityRepository) {
        this.charityRepository = charityRepository;
    }

    public CharityEntity createCharity(CharityEntity charityEntity) {
        return charityRepository.save(charityEntity);
    }

    public void saveOrUpdate(CharityEntity charityEntity)
    {
        charityRepository.save(charityEntity);
    }
    public void deleteCharity(Long id) {
        Optional<CharityEntity> foundCharity = charityRepository.findById(id);
        charityRepository.deleteById(id);
    }

    public Optional<CharityEntity> findCharityById(Long id) {
        return charityRepository.findById(id);
    }

    public Iterable<CharityEntity> findAll() {
        return charityRepository.findAll();
    }

    public int getTotalAmountDonation() {
        return charityRepository.getTotalAmount();
    }
}
