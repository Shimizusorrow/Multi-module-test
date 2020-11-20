package shimizu.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shimizu.app.domain.base.ApplyOrder;

import javax.persistence.Entity;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/29 10:42
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class TestApplyOrder extends ApplyOrder {
    private String name;
}
