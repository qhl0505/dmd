package com.dmd.mall.service;

import com.dmd.core.support.IService;
import com.dmd.mall.model.domain.PmsProduct;
import com.dmd.mall.model.dto.SortDto;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 * @author YangAnsheng
 * @since 2019-10-09
 */
public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 分页查询船宿商品的列表信息
     * @param sortDto
     * @return
     */
    PageInfo findShipSleepsProduct(SortDto sortDto);

}
