package com.star.easyfun.user.controller;

import com.star.easyfun.common.pojo.dto.Result;
import com.star.easyfun.common.util.ResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author ：Star
 * @description ：无描述
 * @date ：2026 2月 24 15:51
 */

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @GetMapping("/test/get")
    public Result test() {
        return ResultUtil.success_10000(LocalDateTime.now(),"测试成功");
    }

    @PostMapping("/test/post")
    public Result testPost(@RequestBody String body) {
        System.out.println(body);
        return ResultUtil.success_10000(LocalDateTime.now(),"测试成功");
    }

}