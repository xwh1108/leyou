package com.shopping.item.service;

import com.shopping.common.enums.ExceptionEnums;
import com.shopping.common.exception.LyException;
import com.shopping.item.mapper.CategoryMapper;
import com.shopping.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryByPid(Long pid) {
        Category category=new Category();
        category.setParentId(pid);
        List<Category> list = categoryMapper.select(category);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnums.CATEGORY_NOT_FOND);
        }
        return list;
    }
}
