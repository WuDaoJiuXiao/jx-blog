package com.jiuxiao.service.admin.article;

import com.jiuxiao.mapper.ArticleMapper;
import com.jiuxiao.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文章管理业务层接口实现类
 * @Author: 悟道九霄
 * @Date: 2022年06月07日 22:02
 * @Version: 1.0.0
 */
@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 查询所有的文章列表
     * @date 2022/6/7 22:04
     */
    @Override
    public List<Article> queryAllArticleList() {
        return articleMapper.queryAllArticleList();
    }

    /**
     * @param title
     * @param tags
     * @param sort
     * @param type
     * @return: java.util.List<com.jiuxiao.pojo.Article>
     * @decription 根据标题、分类、标签、类型，未定条件查询文章
     * @date 2022/6/7 22:04
     */
    @Override
    public List<Article> queryArticleByUncertainCondition(String title, String tags, String sort, String type) {
        return articleMapper.queryArticleByUncertainCondition(title, tags, sort, type);
    }

    /**
     * @param id
     * @return: com.jiuxiao.pojo.Article
     * @decription 通过 ID 查询文章
     * @date 2022/6/7 22:04
     */
    @Override
    public Article queryArticleById(Integer id) {
        return articleMapper.queryArticleById(id);
    }

    /**
     * @param id
     * @return: void
     * @decription 通过 ID 删除文章
     * @date 2022/6/7 22:05
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArticleById(Integer id) {
        articleMapper.deleteArticleById(id);
    }

    /**
     * @return: java.lang.Integer
     * @decription 查询文章总数量
     * @date 2022/6/7 22:05
     */
    @Override
    public Integer queryArticleCount() {
        return articleMapper.queryArticleCount();
    }

    /**
     * @return: void
     * @decription 设置主键由此递增
     * @date 2022/6/7 22:05
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseArticleFromThis() {
        articleMapper.increaseArticleFromThis();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询文章的所有标签
     * @date 2022/6/7 22:22
     */
    @Override
    public List<String> queryTags() {
        return articleMapper.queryTags();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询文章的所有分类
     * @date 2022/6/7 22:22
     */
    @Override
    public List<String> querySort() {
        return articleMapper.querySort();
    }

    /**
     * @return: java.util.List<java.lang.String>
     * @decription 查询文章的所有类型
     * @date 2022/6/7 22:22
     */
    @Override
    public List<String> queryType() {
        return articleMapper.queryType();
    }

    /**
     * @param article
     * @return: void
     * @decription 新增文章
     * @date 2022/6/8 9:24
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    /**
     * @param article
     * @return: void
     * @decription 根据 ID 修改博客
     * @date 2022/6/8 9:28
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticleById(Article article) {
        articleMapper.updateArticleById(article);
    }
}