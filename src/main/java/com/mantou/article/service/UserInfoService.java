package com.mantou.article.service;

import com.mantou.article.bean.CompanyInfo;
import com.mantou.article.bean.FieldInfo;
import com.mantou.article.bean.SuccessfulCase;
import com.mantou.article.bean.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserInfoService {
    Map<String, Object> insertUserInfo(UserInfo userInfo);

    Map<String, Object> uploadImg(MultipartFile img);

    Map<String, Object> getUserInfo(String ids);

    Map<String, Object> updateUserInfo(UserInfo userInfo);

    Map<String, Object> deleteUserInfo(String ids);

    Map<String, Object> getCompanyInfo(String number);

    Map<String, Object> saveCompanyInfo(CompanyInfo companyInfo);

    Map<String, Object> saveFieldInfo(FieldInfo fieldInfo);

    Map<String, Object> getFieldInfo();

    Map<String, Object> updateFieldInfo(FieldInfo fieldInfo);

    Map<String, Object> deleteFieldInfoByIds(String ids);

    Map<String, Object> saveSuccessfulCase(SuccessfulCase successfulCase);

    Map<String, Object> getSuccessfulCase();

    Map<String, Object> updateSuccessfulCase(SuccessfulCase successfulCase);

    Map<String, Object> deleteSuccessfulCaseByIds(String ids);
}
