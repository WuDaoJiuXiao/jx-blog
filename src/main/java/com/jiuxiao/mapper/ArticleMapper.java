package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 文章Mapper层接口
 * @author: WuDaoJiuXiao
 * @Date: 2022/06/01 09:07
 * @since: 1.0.0
 */
@Repository
@Mapper
public interface ArticleMapper {

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 查询所有的文章列表(无序)
     * @date 2022/6/7 21:25
     */
    List<Article> queryAllArticleList();

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 查询所有的文章列表(按照发布时间降序)
     * @date 2022/6/9 17:56
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
    List<Article> queryArticleByUncertainCondition(@Param("title") String title,
                                                   @Param("tags") String tags,
                                                   @Param("sort") String sort,
                                                   @Param("type") String type);

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Article
     * @decription 通过 ID 查询文章
     * @date 2022/6/7 21:22
     */
    Article queryArticleById(@Param("id") Integer id);

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除文章
     * @date 2022/6/7 21:24
     */
    void deleteArticleById(@Param("id") Integer id);

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

    /**
     * @param queryText
     * @return: java.util.List<java.util.Map < java.lang.Object, java.lang.Object>>
     * @decription 搜索标题和摘要，是否包含要搜索的字符串内容
     * @date 2022/6/9 20:51
     */
    List<Map<Object, Object>> searchText(@Param("queryText") String queryText);

    /**
     * @param sort
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 通过分类名称查询文章
     * @date 2022/6/11 21:54
     */
    List<Article> queryArticleBySortName(@Param("sort") String sort);

    /**
     * @param tags
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 通过标签名称查询文章
     * @date 2022/6/11 21:54
     */
    List<Article> queryArticleByTagsName(@Param("tags") String tags);

    /**
     * @return: java.util.List<java.util.Map < java.lang.Object, java.lang.Object>>
     * @decription 查询所有的文章标签列表
     * @date 2022/6/11 22:48
     */
    List<Map<Object, Object>> queryTagsList();

    /**
     * @return: java.util.List<java.util.Map < java.lang.Object, java.lang.Object>>
     * @decription 查询所有的文章分类列表
     * @date 2022/6/11 22:47
     */
    List<Map<Object, Object>> querySortList();
}
