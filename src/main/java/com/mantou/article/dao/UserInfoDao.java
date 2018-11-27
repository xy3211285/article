package com.mantou.article.dao;

import com.mantou.article.bean.CompanyInfo;
import com.mantou.article.bean.FieldInfo;
import com.mantou.article.bean.SuccessfulCase;
import com.mantou.article.bean.UserInfo;

import java.util.List;

public interface UserInfoDao {
    void insertUserInfo(UserInfo userInfo);

    List<UserInfo> getUserInfoByUserIds(List<String> list);

    void updateUserInfo(UserInfo userInfo);

    void deleteUserInfo(List<String> list);

    void insertCompanyInfo(CompanyInfo companyInfo);

    CompanyInfo getcompanyInfoByNumber(String number);

    void saveImagePath(String path);

    void saveFieldInfo(FieldInfo fieldInfo);

    List<FieldInfo> getFieldInfo();

    void updateFieldInfo(FieldInfo fieldInfo);

    void deleteFieldInfoByIds(List<String> list);

    void saveSuccessfulCase(SuccessfulCase successfulCase);

    List<SuccessfulCase> getSuccessfulCase();

    void updateSuccessfulCase(SuccessfulCase successfulCase);

    void deleteSuccessfulCaseByIds(List<String> list);
}
