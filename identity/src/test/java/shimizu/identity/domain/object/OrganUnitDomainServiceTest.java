package shimizu.identity.domain.object;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import shimizu.identity.IdentityApplication;
import shimizu.identity.domain.OrganUnit;

import shimizu.identity.enums.OrganUnitLevel;
import shimizu.identity.repository.OrganUnitRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
//@ContextConfiguration(classes = {OrganUnitDomainServiceTest.class})
//@EnableJpaRepositories(basePackageClasses = {OrganUnitDomainServiceTest.class})
//@EntityScan(basePackageClasses = IdentityApplication.class)
@Import(OrganUnitDomainService.class)
@Rollback(value = false)
class OrganUnitDomainServiceTest {

    @Autowired
    private OrganUnitRepository organUnitRepository;
    @Autowired
    private OrganUnitDomainService organUnitDomainService;

    @Test
    void notNull() {
        assertNotNull(organUnitRepository);
        assertNotNull(organUnitDomainService);
    }

    @Test
    void add() {
        final String name = "温州市局";
        OrganUnit organUnit1 = new OrganUnit(name, OrganUnitLevel.V1, null);
        organUnit1.setId("1");
        OrganUnit organUnit = organUnitRepository.save(organUnit1);
        assertEquals(name, organUnit.getName());

    }

    @Test
    void addOrganUnit() {
        final String name = "乐清市局";
        OrganUnit organUnit = new OrganUnit(name, OrganUnitLevel.V2, null);
        organUnit.setId("2");
        OrganUnit save = organUnitRepository.save(organUnit);
        organUnitRepository.findById("1").get().addOrganUnit(save);
    }

}