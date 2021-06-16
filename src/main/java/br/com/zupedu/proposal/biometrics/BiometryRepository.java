package br.com.zupedu.proposal.biometrics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BiometryRepository extends JpaRepository<Biometry, UUID> {
}
