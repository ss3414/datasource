package com.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Password {

    @JSONField(name = "key")
    private String pwdKey;

}
