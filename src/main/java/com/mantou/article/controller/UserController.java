package com.mantou.article.controller;

import com.alibaba.fastjson.JSON;
import com.mantou.article.bean.CompanyInfo;
import com.mantou.article.bean.FieldInfo;
import com.mantou.article.bean.SuccessfulCase;
import com.mantou.article.bean.UserInfo;
import com.mantou.article.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    /*@RequestMapping("/main")
    public String main() {
        return "index";
    }*/

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public Map<String, Object> uploadImg(MultipartFile img) {
        return userInfoService.uploadImg(img);
    }

    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.POST)
    @ApiImplicitParam(name = "json", paramType = "body", examples = @Example({
            @ExampleProperty(value = "{}", mediaType = "application/json")
    }))
    @ApiImplicitParams({
    })
    public Map<String, Object> insertUserInfo(@RequestBody String json) {
        UserInfo userInfo = JSON.parseObject(json, UserInfo.class);
        return  userInfoService.insertUserInfo(userInfo);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
    })
    public Map<String, Object> getUserInfo(String ids) {
        return userInfoService.getUserInfo(ids);
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public Map<String, Object> updateUserInfo(@RequestBody String json) {
        UserInfo userInfo = JSON.parseObject(json, UserInfo.class);
        return  userInfoService.updateUserInfo(userInfo);
    }

    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
    })
    public Map<String, Object> deleteUserInfo(String ids) {
        return userInfoService.deleteUserInfo(ids);
    }

    @RequestMapping(value = "/saveCompanyInfo", method = RequestMethod.POST)
    public Map<String, Object> saveCompanyInfo(@RequestBody String json) {
        CompanyInfo companyInfo = JSON.parseObject(json, CompanyInfo.class);
        return userInfoService.saveCompanyInfo(companyInfo);
    }

    @RequestMapping(value = "/getCompanyInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
    })
    public Map<String, Object> getCompanyInfo(String number) {
        return userInfoService.getCompanyInfo(number);
    }

    @RequestMapping(value = "/saveFieldInfo", method = RequestMethod.POST)
    @ApiImplicitParam(name = "json", paramType = "body", examples = @Example({
            @ExampleProperty(value = "{}", mediaType = "application/json")
    }))
    public Map<String, Object> saveFieldInfo(@RequestBody String json) {
        FieldInfo fieldInfo = JSON.parseObject(json, FieldInfo.class);
        return userInfoService.saveFieldInfo(fieldInfo);
    }

    @RequestMapping(value = "/getFieldInfo", method = RequestMethod.POST)
    public Map<String, Object> getFieldInfo() {
        return userInfoService.getFieldInfo();
    }

    @RequestMapping(value = "/updateFieldInfo", method = RequestMethod.POST)
    @ApiImplicitParam(name = "json", paramType = "body", examples = @Example({
            @ExampleProperty(value = "{}", mediaType = "application/json")
    }))
    public Map<String, Object> updateFieldInfo(@RequestBody String json) {
        FieldInfo fieldInfo = JSON.parseObject(json, FieldInfo.class);
        return userInfoService.updateFieldInfo(fieldInfo);
    }

    @RequestMapping(value = "/deleteFieldInfo", method = RequestMethod.POST)
    public Map<String, Object> deleteFieldInfo(String ids) {
        return userInfoService.deleteFieldInfoByIds(ids);
    }

    @RequestMapping(value = "/saveSuccessfulCase", method = RequestMethod.POST)
    @ApiImplicitParam(name = "json", paramType = "body", examples = @Example({
            @ExampleProperty(value = "{}", mediaType = "application/json")
    }))
    public Map<String, Object> saveSuccessfulCase(@RequestBody String json) {
        SuccessfulCase successfulCase = JSON.parseObject(json, SuccessfulCase.class);
        return userInfoService.saveSuccessfulCase(successfulCase);
    }

    @RequestMapping(value = "/getSuccessfulCase", method = RequestMethod.POST)
    public Map<String, Object> getSuccessfulCase() {
        return userInfoService.getSuccessfulCase();
    }

    @RequestMapping(value = "/updateSuccessfulCase", method = RequestMethod.POST)
    @ApiImplicitParam(name = "json", paramType = "body", examples = @Example({
            @ExampleProperty(value = "{}", mediaType = "application/json")
    }))
    public Map<String, Object> updateSuccessfulCase(@RequestBody String json) {
        SuccessfulCase successfulCase = JSON.parseObject(json, SuccessfulCase.class);
        return userInfoService.updateSuccessfulCase(successfulCase);
    }

    @RequestMapping(value = "/deleteSuccessfulCaseByIds", method = RequestMethod.POST)
    public Map<String, Object> deleteSuccessfulCaseByIds(String ids) {
        return userInfoService.deleteSuccessfulCaseByIds(ids);
    }
}
