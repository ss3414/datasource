package com.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Id
//    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @GeneratedValue(generator = "uuid")
//    private String id;

    @Column(name = "name", nullable = false, length = 5)
    private String name;

    private String password;

    /* 一对一（user_id直接存在role表中） */
//    @OneToOne
//    @JoinColumn(name = "user_id") /* 外键 */
//    private Role role;

    /* 一对多 */
//    @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<Role> roleList;

    /*
     * 多对多（中间表）
     *
     * 级联策略
     * PERSIST：新建（同时插入user/role/user_role）
     * REMOVE：删除
     * REFRESH：刷新
     * MERGE：更新（同时插入user/user_role）
     * ALL：全部
     *
     * fetch：不要使用懒加载
     *
     * 使用Set而非List存储
     * */
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), /* 关联表外键/被关联表主键 */
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roleList;

    /* 不在表中的属性 */
    @Transient
    private List<String> nameList;

    /* 多对多需要重写toString()方法 */
    @Override
    public String toString() {
        return "";
    }

}
