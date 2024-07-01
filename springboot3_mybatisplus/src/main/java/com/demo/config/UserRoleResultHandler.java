package com.demo.config;

import com.demo.model.User;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

@Component
public class UserRoleResultHandler implements ResultHandler<User> {

    @Override
    public void handleResult(ResultContext<? extends User> resultContext) {
    }

}
