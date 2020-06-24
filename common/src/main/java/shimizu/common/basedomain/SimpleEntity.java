package shimizu.common.basedomain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Shimizu
 */
@MappedSuperclass
@Getter
@Setter
public class SimpleEntity {
    @Id
    private String Id;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 更新时间
     */
    private long updateTime;

    /**
     * @PrePersist 帮助您在持久化之前自动填充实体属性
     * <p>
     * 初始化创建时间和更新时间
     */
    @PrePersist
    public void prePersistTime() {
        long time = System.currentTimeMillis();
        this.createTime = time;
        this.updateTime = time;
    }

    /**
     * @PreUpdate 用于为相应的生命周期事件指定回调方法。
     */
    @PreUpdate
    public void preUpDateTime() {
        this.updateTime = System.currentTimeMillis();
    }


}
