package com.lgs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.pojo.UserQuery;
import com.lgs.pojo.UserVo;
import com.lgs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:TestController
 * @Auther:lgs
 * @Description:
 * @DateTime: 2023/6/13 10:43
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserForPage")
    public PageInfo<UserVo> getUserForPage(UserQuery userQuery){

        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());

        List<UserVo> userVoList =userService.getUserForPage(userQuery);

        PageInfo<UserVo> pageInfo = new PageInfo<UserVo>(userVoList);

        return pageInfo;
    }

}
