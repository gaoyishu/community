package life.hk.community.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.shiro.UnavailableSecurityManagerException;

import javax.persistence.*;
import java.util.List;

/**
 * @author gaoyishu
 * @date 2020/1/13 18:24
 **/

@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",
            joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;

    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> userInfos;

}
