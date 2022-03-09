package com.archaeologyprojects.strabomap.settlement;

//Spring
import org.springframework.data.repository.CrudRepository;

public interface SettlementRepository extends CrudRepository<Settlement, Long> {

    Iterable<Settlement> findByProvince (String Province);
}

