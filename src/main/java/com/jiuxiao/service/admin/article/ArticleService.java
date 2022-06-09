package com.jiuxiao.service.admin.article;

import com.jiuxiao.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 博文管理业务层接口
 * @Author: 悟道九霄
 * @Date: 2022年06月07日 22:01
 * @Version: 1.0.0
 */
@Service
public interface ArticleService {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 查询所有的文章列表(无序)
     * @date 2022/6/7 21:25
     */
    List<Article> queryAllArticleList();

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 查询所有的文章列表(按照发布时间降序)
     * @date 2022/6/9 17:58
     */
    List<Article> queryAllArticleListDESC();

    /**
     * @param title
     * @param tags
     * @param sort
     * @param type
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 根据标题、分类、标签、类型，未定条件查询文章
     * @date 2022/6/7 21:39
     */
    List<Article> queryArticleByUncertainCondition(String title, String tags, String sort, String type);

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Article
     * @decription 通过 ID 查询文章
     * @date 2022/6/7 21:22
     */
    Article queryArticleById(Integer id);

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除文章
     * @date 2022/6/7 21:24
     */
    void deleteArticleById(Integer id);

    /**
     * @return: java.lang.Integer
     * @decription 查询文章总数量
     * @date 2022/6/7 21:26
     */
    Integer queryArticleCount();

    /**
     * @return: void
     * @decription 设置主键由此递增
     * @date 2022/6/7 21:27
     */
    void increaseArticleFromThis();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询所有的文章标签
     * @date 2022/6/7 22:17
     */
    List<String> queryTags();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询所有的文章分类
     * @date 2022/6/7 22:17
     */
    List<String> querySort();

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询所有的文章类型
     * @date 2022/6/7 22:17
     */
    List<String> queryType();

    /**
     * @param article
     * @return: void
     * @decription 新增文章
     * @date 2022/6/8 9:20
     */
    void insertArticle(Article article);

    /**
     * @param article
     * @return: void
     * @decription 根据 ID 修改博客
     * @date 2022/6/8 9:28
     */
    void updateArticleById(Article article);

    /**
     * @return: java.util.List<java.util.Map < java.lang.Object, java.lang.Object>>
     * @decription 根据阅读量，降序返回文章排行
     * @date 2022/6/9 10:26
     */
    List<Map<Object, Object>> DescendingArticleByReadCount();

    /**
     * @return: java.util.List<java.util.Map < java.lang.Object, java.lang.Object>>
     * @decription 根据发布时间，降序返回文章排行
     * @date 2022/6/9 10:28
     */
    List<Map<Object, Object>> DescendingArticleByCreatedTime();
}