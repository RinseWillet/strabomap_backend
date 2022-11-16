package com.archaeologyprojects.strabomap.ancientreference;

//Spring
import org.springframework.data.repository.CrudRepository;

public interface AncientReferenceRepository extends CrudRepository<AncientReference, Long> {

    public Iterable<AncientReference> findBySettlementId(long id);

    public Iterable<AncientReference> findByTypeWork(TypeWork typeWork);

    Iterable<AncientReference> findByAuthor(String author);

    Iterable<AncientReference> findByTitle(String title);
}
