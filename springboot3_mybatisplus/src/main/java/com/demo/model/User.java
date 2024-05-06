package com.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.demo.config.MyJacksonTypeHandler;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user", autoResultMap = true)
public class User extends Model<User> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

//    private String password;

    /* 二进制 */
//    @TableField(typeHandler = BlobTypeHandler.class)
//    private byte[] password;

    /* 类型转换，实体类需要包含构造器 */
//    @TableField(typeHandler = FastjsonTypeHandler.class)
//    private JSONObject password;

    /* 类型转换，实体类需要包含构造器 */
    @TableField(typeHandler = MyJacksonTypeHandler.class)
    private Password password;

//    private Date password;

    /* 自动填充时间 */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

//    @Version
//    private Integer version;

    @TableField(exist = false)
    private List nameList;

}
