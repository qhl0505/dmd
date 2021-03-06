package com.dmd.mall.mapper;

import com.dmd.mall.model.domain.TopicBean;

import java.util.List;

/**
 * @author ChenYanbing
 * @title: TopicMapper
 * @projectName dmd-master
 * @description: TODO
 * @date 2019/9/2910:48
 */
public interface TopicMapper {
    List<TopicBean> queryTopicPage();

    List<TopicBean> queryTopicById(Integer id);

    List<TopicBean> queryTopic();

    void addTopicNum(Integer topicId);

    void reduceTopicNum(Integer topicId);

}
