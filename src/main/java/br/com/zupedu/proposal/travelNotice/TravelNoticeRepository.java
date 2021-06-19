package br.com.zupedu.proposal.travelNotice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TravelNoticeRepository extends JpaRepository<TravelNotice, UUID> {
}
