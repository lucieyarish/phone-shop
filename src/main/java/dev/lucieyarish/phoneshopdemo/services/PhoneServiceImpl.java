package dev.lucieyarish.phoneshopdemo.services;

import dev.lucieyarish.phoneshopdemo.models.entities.Phone;
import dev.lucieyarish.phoneshopdemo.repositories.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Override
    public Phone create(Phone phone) {
        return phoneRepository.save(phone);
    }
}
