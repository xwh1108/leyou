package com.shopping.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum  ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOND(404,"商品分类为空"),
    BRAND_NOT_FOUND(404,"品牌查询为空"),
    SAVE_BRAND_NOT(500,"品牌添加失败"),
    UPLOAD_FILE_ERROR(500,"文件上传失败"),
    UPLOAD_FILE_TYPE_ERROR(500,"文件类型错误"),
    UPLOAD_FILE_TYPE_NOT_ERROR(500,"文件内容错误"),
    ;
    private int code;
    private String msg;
}
