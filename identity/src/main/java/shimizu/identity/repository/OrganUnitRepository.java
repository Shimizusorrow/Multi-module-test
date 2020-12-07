package shimizu.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shimizu.identity.domain.OrganUnit;

/**
 * @author Shimizu
 * @description organUnit
 * @date 2020-12-07 15:29
 */
public interface OrganUnitRepository extends JpaRepository<OrganUnit, String> {
}
