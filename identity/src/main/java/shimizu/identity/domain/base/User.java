package shimizu.identity.domain.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import shimizu.common.basedomain.SimpleEntity;
import shimizu.identity.enums.RoleEnum;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/7/29 14:53
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends SimpleEntity implements UserDetails {
    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("role")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
