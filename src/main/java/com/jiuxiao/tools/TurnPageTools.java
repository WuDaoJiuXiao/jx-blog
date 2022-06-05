package com.jiuxiao.tools;

import java.util.List;

/**
 * 控制页面跳转的工具类
 * @Author: 悟道九霄
 * @Date: 2022年06月04日 12:29
 * @Version: 1.0.0
 */
public class TurnPageTools<T> {

    /**
     * @param dataList
     * @param currentPage
     * @param pageSize
     * @return: com.jiuxiao.tools.PageInfoTools<T>
     * @decription 为当前页设置 pageInfo
     * @date 2022/6/5 10:39
     */
    public PageInfoTools<T> getPageInfo(List<T> dataList, Integer currentPage, Integer pageSize) {

        PageInfoTools<T> pageInfo = new PageInfoTools<>();

        Integer totalNum = dataList.size();
        pageInfo.setTotalNum(totalNum);

        if (totalNum % pageSize == 0) {
            pageInfo.setTotalPage(totalNum / pageSize);
        } else {
            pageInfo.setTotalPage(totalNum / pageSize + 1);
        }

        //已经是最后一页，点击下一页依然是最后一页
        if (currentPage >= pageInfo.getTotalPage()) {
            pageInfo.setCurrentPage(pageInfo.getTotalPage());
            pageInfo.setDataList(dataList.subList((pageInfo.getCurrentPage() - 1) * pageSize, dataList.size()));
        } else if (currentPage <= 0) {//已经是第一页，点击上一页依然是最后一页
            pageInfo.setCurrentPage(1);
            pageInfo.setDataList(dataList.subList(0, dataList.size() >= pageSize ? pageSize : dataList.size()));
        } else {//正常情况
            pageInfo.setCurrentPage(currentPage);
            pageInfo.setDataList(dataList.subList((currentPage - 1) * pageSize, pageInfo.getCurrentPage() * pageSize));
        }

        return pageInfo;
    }
}

