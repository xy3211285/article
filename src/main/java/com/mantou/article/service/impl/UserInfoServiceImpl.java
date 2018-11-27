package com.mantou.article.service.impl;

import com.mantou.article.bean.CompanyInfo;
import com.mantou.article.bean.FieldInfo;
import com.mantou.article.bean.SuccessfulCase;
import com.mantou.article.bean.UserInfo;
import com.mantou.article.dao.UserInfoDao;
import com.mantou.article.service.UserInfoService;
import com.mantou.article.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Value("${image.baseDir}")
    private String imgPath;

    @Override
    public Map<String, Object> insertUserInfo(UserInfo userInfo) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.insertUserInfo(userInfo);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> uploadImg(MultipartFile img) {
        Map<String, Object> result = new HashMap<>();
        String imageName = FileUtils.getFileName(img.getOriginalFilename());
        File file = new File(imgPath + File.separator + imageName);
        String sqlPath = "/image/" + imageName;
        try {
            img.transferTo(file);
            userInfoDao.saveImagePath(sqlPath);
            result.put("result", "success");
            result.put("path", sqlPath);
        } catch (IOException e) {
            result.put("result", "failed");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> getUserInfo(String ids) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<String> idList = null;
            if (StringUtils.isNoneEmpty(ids)){
                idList = Arrays.asList(ids.split(","));
            }
            List<UserInfo> userInfos = userInfoDao.getUserInfoByUserIds(idList);
            result.put("result", "success");
            result.put("data", userInfos);
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> updateUserInfo(UserInfo userInfo) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.updateUserInfo(userInfo);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> deleteUserInfo(String ids) {
        Map<String, Object> result = new HashMap<>();
        if (StringUtils.isEmpty(ids)) {
            result.put("result", "failed");
            result.put("errMsg", "id列表为空");
            return result;
        }
        try {
            List<String> idList = Arrays.asList(ids.split(","));
            userInfoDao.deleteUserInfo(idList);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "删除数据失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> getCompanyInfo(String number) {
        Map<String, Object> result = new HashMap<>();
        try {
            CompanyInfo companyInfo = userInfoDao.getcompanyInfoByNumber(number);
            result.put("result", "success");
            result.put("data", companyInfo);
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "查询公司简介失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> saveCompanyInfo(CompanyInfo companyInfo) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.insertCompanyInfo(companyInfo);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存公司信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> saveFieldInfo(FieldInfo fieldInfo) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.saveFieldInfo(fieldInfo);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> getFieldInfo() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<FieldInfo> fieldInfo = userInfoDao.getFieldInfo();
            result.put("result", "success");
            result.put("data", fieldInfo);
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> updateFieldInfo(FieldInfo fieldInfo) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.updateFieldInfo(fieldInfo);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> deleteFieldInfoByIds(String ids) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<String> idList = null;
            if (StringUtils.isNoneEmpty(ids)){
                idList = Arrays.asList(ids.split(","));
            }
            userInfoDao.deleteFieldInfoByIds(idList);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> saveSuccessfulCase(SuccessfulCase successfulCase) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.saveSuccessfulCase(successfulCase);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> getSuccessfulCase() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<SuccessfulCase> successfulCase = userInfoDao.getSuccessfulCase();
            result.put("result", "success");
            result.put("data", successfulCase);
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> updateSuccessfulCase(SuccessfulCase successfulCase) {
        Map<String, Object> result = new HashMap<>();
        try {
            userInfoDao.updateSuccessfulCase(successfulCase);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> deleteSuccessfulCaseByIds(String ids) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<String> idList = null;
            if (StringUtils.isNoneEmpty(ids)){
                idList = Arrays.asList(ids.split(","));
            }
            userInfoDao.deleteSuccessfulCaseByIds(idList);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "保存专注领域信息失败,服务异常");
            e.printStackTrace();
        }
        return result;
    }
}
