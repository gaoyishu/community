package life.hk.community.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * User: gaoyishu
 * Date: 2020/1/13
 * Time: 21:55
 */

@Entity
public class SysPermission {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String url;
    @JsonIgnoreProperties(value = {"permissions"})
    @ManyToMany
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "permissionId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;

}
