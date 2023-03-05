package dev.lucieyarish.phoneshopdemo.repositories;

import dev.lucieyarish.phoneshopdemo.models.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
