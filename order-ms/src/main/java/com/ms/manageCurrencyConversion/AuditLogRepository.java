package com.ms.manageCurrencyConversion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuditLogRepository extends  JpaRepository<AuditLog, Integer>{

	//Optional<CurrencyConversion> findByCountryCode(String countryCode);
}
