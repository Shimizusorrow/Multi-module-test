package shimizu.identity.enums;

import lombok.Getter;

@Getter
public enum OrganUnitLevel {
    /**
     * 标记等级
     */
    V1("Lv1"),
    V2("Lv2"),
    V3("Lv3");

    private String chinese;

    OrganUnitLevel(String chinese) {
        this.chinese = chinese;
    }
}
