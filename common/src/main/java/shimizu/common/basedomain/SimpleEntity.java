package shimizu.common.basedomain;

import io.netty.util.internal.StringUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;
import shimizu.common.exception.BusinessException;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;

/**
 * @author Shimizu
 */
@MappedSuperclass
@Getter
@Setter
public class SimpleEntity implements Serializable {
    @Id
    private String id;

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

    public void setId(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("Id 不能为空");
        }
        this.id = id;
    }
}
