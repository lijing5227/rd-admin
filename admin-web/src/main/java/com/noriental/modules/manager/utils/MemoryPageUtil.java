package com.noriental.modules.manager.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Collections;
import java.util.List;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：内存分页
 * *
 * *   @DATE    2020/1/2
 * *   @AUTHOR  Jing.Li
 ***/
public class MemoryPageUtil {
    private static final Integer defaultPage = 1;

    private static final Integer defaultPageSize = 10;

    /**
     * @currPageNo 页面传入的页号，从一开始
     * @pageSize 每页记录数
     */
    public static <T> Page<T> getPage(List<T> list, Integer currentPage, Integer pageSize) {
        Page<T> page = new Page<>(1 > currentPage ? defaultPage : currentPage, 1 > pageSize ? defaultPageSize : pageSize);
        if (list.isEmpty()) {
            page.setRecords(Collections.emptyList());
            page.setTotal(0);
            page.setPages(0L);
            return page;
        }
        int totalRowNum = list.size();
        int totalPageNum = (totalRowNum - 1) / pageSize + 1;
        int realPageNo = currentPage;
        if (currentPage > totalPageNum) {
            realPageNo = totalPageNum;
        } else if (currentPage < 1) {
            realPageNo = 1;
        }
        int fromIdx = (realPageNo - 1) * pageSize;
        int toIdx = realPageNo * pageSize > totalRowNum ? totalRowNum : realPageNo * pageSize;
        List<T> result = list.subList(fromIdx, toIdx);
        page.setTotal(totalRowNum);
        page.setRecords(result);
        page.setPages(totalPageNum);
        return page;
    }
}
