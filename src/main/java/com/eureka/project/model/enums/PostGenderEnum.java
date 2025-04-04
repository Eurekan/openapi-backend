package com.eureka.project.model.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 帖子性别枚举
 */
@Getter
public enum PostGenderEnum {

    MALE("男", 0),
    FEMALE("女", 1);

    private final String text;

    private final int value;

    PostGenderEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return List<Integer>
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

}
