package com.shopping.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.common.enums.ExceptionEnums;
import com.shopping.common.exception.LyException;
import com.shopping.item.mapper.BrandMapper;
import com.shopping.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageInfo<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brands)){
            throw new LyException(ExceptionEnums.BRAND_NOT_FOUND);
        }
        PageInfo<Brand> pageInfo=new PageInfo<>(brands);
        return pageInfo;
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if (count!=1){
            throw new LyException(ExceptionEnums.SAVE_BRAND_NOT);
        }
        Long bid = brand.getId();
        for (Long cid : cids) {
            brandMapper.saveCategoryBrand(cid,bid);
        }
    }
}
