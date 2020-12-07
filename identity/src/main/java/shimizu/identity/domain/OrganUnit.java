package shimizu.identity.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shimizu.common.basedomain.SimpleEntity;
import shimizu.identity.enums.OrganUnitLevel;

import javax.persistence.*;
import java.util.*;

/**
 * @author Shimizu
 * @description 机构信息
 * @date 2020-12-07 14:49
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrganUnit extends SimpleEntity {
    @ApiModelProperty("机构名称")
    private String name;

    @ApiModelProperty("机构级别")
    @Enumerated(EnumType.STRING)
    private OrganUnitLevel level = OrganUnitLevel.V1;

    @ApiModelProperty("下属机构")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Set<OrganUnit> organUnitList = new HashSet<>();

    @PrePersist
    void prePersist() {
        if (getId() == null || getId().isEmpty()) {
            setId((int) (Math.random() * 100) + "");
        }
    }

    public void addOrganUnit(OrganUnit organUnit) {
        this.organUnitList = this.organUnitList == null ? new HashSet<>() : this.organUnitList;
        this.organUnitList.add(organUnit);
    }

    /**
     * @param name
     * @param level
     * @param organUnitList
     */
    public OrganUnit(String name, OrganUnitLevel level, Set<OrganUnit> organUnitList) {
        this.name = name;
        this.level = level;
        this.organUnitList = organUnitList;
    }
}

