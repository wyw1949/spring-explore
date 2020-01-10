package com.yoke.moel;

import lombok.Data;

@Data
public class PersonEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件号
     */
    private String cardId;
    /**
     * 证件地址
     */
    private String address;
    /**
     * 证件类型
     */
    private String idType;
    /**
     * 民族
     */
    private String nation;
    /**
     * 性别 "1"-男   "2"-女
     */
    private String gender;
    /**
     * 证件照绝对路径
     */
    private String idImagePath;
    /**
     * 场景照绝对路径
     */
    private String sceneImagePath1;
    /**
     * 场景照绝对路径
     */
    private String sceneImagePath2;
}
