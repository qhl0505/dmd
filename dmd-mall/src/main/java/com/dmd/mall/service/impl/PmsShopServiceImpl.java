package com.dmd.mall.service.impl;

import com.dmd.mall.mapper.PmsShopProductMapper;
import com.dmd.mall.model.domain.PmsComment;
import com.dmd.mall.model.domain.PmsProduct;
import com.dmd.mall.model.domain.PmsShopDetails;
import com.dmd.mall.model.domain.SmsHomeAdvertise;
import com.dmd.mall.service.PmsShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品首页内容
 * </p>
 *
 * @author 王海成
 * @since 2019-09-29
 */
@Service
public class PmsShopServiceImpl implements PmsShopService {
    @Autowired
    private PmsShopProductMapper psmShopProductMapper;
    @Override
    public Map<String,Object> getShopIndex(Map<String,Object> map){
        PageHelper.startPage((int)(map.get("page")), (int)(map.get("pageSize")));
        List<SmsHomeAdvertise> advertises=psmShopProductMapper.getShopAdvertise(map);
        PageInfo<SmsHomeAdvertise> advertisesPageInfo=new PageInfo<>(advertises);
        PageHelper.startPage((int)(map.get("page")), (int)(map.get("pageSize")));
        List<PmsProduct> pmsProducts=psmShopProductMapper.getShopProduct(map);
        PageInfo<PmsProduct> pmsProductsPageInfo=new PageInfo<>(pmsProducts);
        Map<String,Object> maps=new HashMap<>();
        maps.put("advertises",advertisesPageInfo);
        maps.put("pmsProducts",pmsProductsPageInfo);
        return maps;
    }
    //获取商品详情和评论
    @Override
    public Map<String,Object> shopProductDetails(Map<String,Object> mapParam) {
        int id=(int)mapParam.get("id");
        int page=(int)mapParam.get("page");
        int pageSize=(int)mapParam.get("pageSize");
        PmsShopDetails pmsShopDetails=psmShopProductMapper.shopProductDetails(id);
        Map<String,Object> map=new HashMap<>();
        PageInfo<PmsComment> pmsCommentPageInfo=shopProductComment(id,page,pageSize);
        map.put("pmsShopDetails",pmsShopDetails);
        map.put("pmsCommentPageInfo",pmsCommentPageInfo);
        return map;
    }
    //获取商品评论
    @Override
    public PageInfo<PmsComment> shopProductComment(int id,int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<PmsComment> pmsComment=psmShopProductMapper.shopComment(id);
        PageInfo<PmsComment> pmsCommentPageInfo=new PageInfo<>(pmsComment);
        return pmsCommentPageInfo;
    }
}
