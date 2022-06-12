package com.jiuxiao.tools;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * markdown转为html工具类
 * @Author: 悟道九霄
 * @Date: 2022年06月10日 10:30
 * @Version: 1.0.0
 */
public class MarkdownToHtmlTools {

    /**
     * @param markdown
     * @return: java.lang.String
     * @decription Markdown 转 HTML
     * @date 2022/6/10 10:34
     */
    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    /**
     * @param markdown
     * @return: java.lang.String
     * @decription 自定义标题、表格格式
     * @date 2022/6/10 10:44
     */
    public static String markdownToHtmlExtensions(String markdown) {
        //给 h 标签生成唯一 id
        Set<Extension> headingExtend = Collections.singleton(HeadingAnchorExtension.create());
        System.out.println(headingExtend.size());
        //转换table
        List<Extension> tableExtend = Collections.singletonList(TablesExtension.create());
        Parser parser = Parser.builder().extensions(tableExtend).build();
        Node node = parser.parse(markdown);

        HtmlRenderer renderer = HtmlRenderer.builder().extensions(headingExtend).extensions(tableExtend)
                .attributeProviderFactory(context -> new CustomAttributeProvider()).build();
        return renderer.render(node);
    }
}