package com.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

//    @Id
//    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @GeneratedValue(generator = "uuid")
//    @Column(name = "role_id")
//    private String roleId;

    @Column(name = "role_name")
    private String roleName;

//    @Column(name = "user_id")
//    private Integer userId;

    /* 多对多 */
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
    private List<User> userList;

    @Override
    public String toString() {
        return "";
    }

}
