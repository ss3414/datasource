package com.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;
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

    private Date password;

//    @Version
//    private Integer version;

    @TableField(exist = false)
    private List nameList;

}
