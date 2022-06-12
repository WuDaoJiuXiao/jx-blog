package com.jiuxiao.controller.web;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.pojo.Archive;
import com.jiuxiao.pojo.Article;
import com.jiuxiao.service.archive.ArchiveService;
import com.jiuxiao.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.util.*;

/**
 * 前端归档页面控制器
 * @Author: 悟道九霄
 * @Date: 2022年06月12日 15:48
 * @Version: 1.0.0
 */
@Controller
public class WebArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @Autowired
    private ArticleService articleService;

    /**
     * @param model
     * @return: java.lang.String
     * @decription 归档显示页面
     * @date 2022/6/12 21:55
     */
    @MyLogAnnotation("查询")
    @RequestMapping("/archive")
    public String archive(Model model) {
        //查询全部归档
        List<Archive> archives = archiveService.queryAllArchive();

        //将归档按照年份分类
        ArrayList<String> arrOld = new ArrayList<>();
        for (Archive archive : archives) {
            arrOld.add(StringUtils.substring(archive.getCreatedTime().toString(), 0, 4));
        }

        //对年份去重
        ArrayList<String> arrNew = new ArrayList<>();
        for (String year : arrOld) {
            if (!arrNew.contains(year)) {
                arrNew.add(year);
            }
        }

        //这里根据年份排序后，下面用 LinkedHashMap 就会依然按照该顺序
        Collections.sort(arrNew, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        //根据归档的 id，查询出对应的文章 id
        //这里用 LinkedHashMap，按照顺序添加后，就会成为有序的结果
        LinkedHashMap<String, List<List<String>>> articleMap = new LinkedHashMap<>();
        for (String year : arrNew) {
            List<Integer> idList = archiveService.queryArchiveByYear(year);
            List<List<String>> infoList = new ArrayList<>();
            for (Integer id : idList) {
                List<String> infos = new ArrayList<>();

                Article article = articleService.queryArticleById(id);
                //将归档页展示的四条数据取出来，其他的不要
                infos.add(article.getId().toString());
                infos.add(article.getTitle());
                infos.add(article.getCreatedTime().toString());
                infos.add(article.getType());
                infoList.add(infos);
            }
            articleMap.put(year, infoList);
        }
        model.addAttribute("articleMap", articleMap);
        model.addAttribute("archiveCount", archives.size());
        model.addAttribute("arrNew", arrNew);
        return "mainPage/archivePage";
    }
}