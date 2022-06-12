package com.jiuxiao.tools;

import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.node.*;
import org.commonmark.renderer.html.AttributeProvider;

import java.util.Map;

/**
 * 自定义标签类
 * @Author: 悟道九霄
 * @Date: 2022年06月10日 10:53
 * @Version: 1.0.0
 */
public class CustomAttributeProvider implements AttributeProvider {

    /**
     * @param node
     * @param s
     * @param map
     * @return: void
     * @decription 处理标签的属性
     * @date 2022/6/10 10:55
     */
    @Override
    public void setAttributes(Node node, String s, Map<String, String> map) {
        //点击 a 链接后，跳转到新页面
        if (node instanceof Link){
            map.put("target", "_blank");
        }
        //表格使用 SemanticUI 的
        if (node instanceof TableBlock){
            map.put("class", "ui celled table");
            map.put("style", "text-align: center");
        }
        //约束图片宽度，不让超出容器，并且居中显示
        if (node instanceof Image){
            map.put("style", "max-width: 96%;height: auto");
            map.put("class", "ui image centered");
        }
        //列表的行距
        if (node instanceof ListItem){
            map.put("style", "margin-bottom: 5px;margin-top: 5px");
        }
        if (node instanceof OrderedList){
            map.put("style", "line-height: 1.4em;padding-top: 5px");
        }
        //引用字体的透明度
        if (node instanceof BlockQuote){
            map.put("style", "opacity: 0.6");
        }
    }
}