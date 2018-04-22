package com.jbt.shopping.common.constants;

public interface Constants {
    // 全局 有效/禁用 状态码
    Integer GLOBAL_ENABLE_NORMAL = 1;
    Integer GLOBAL_ENABLE_DISABLE = 2;
    // 1： 管理员
    Integer GLOBAL_IS_ADMIN = 1;

    Integer JWT_EXP_TIME = 1000 * 60 * 60 * 24;

    String JWT_SECRET_KEY = "@shopping-mail-secret@";
}
