package life.hk.community.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * User: gaoyishu
 * Date: 2019/11/29
 * Time: 00:34
 */


@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String salt;
    @JsonIgnoreProperties(value = {"userInfos"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = @JoinColumn(name = "uid"),inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<SysRole> roles;
}
