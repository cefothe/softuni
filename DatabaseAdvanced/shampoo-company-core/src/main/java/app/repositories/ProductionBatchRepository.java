package app.repositories;

import app.domain.batches.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 10.12.16.
 */

@Repository
public interface ProductionBatchRepository extends JpaRepository<ProductionBatch, Long> {
}
