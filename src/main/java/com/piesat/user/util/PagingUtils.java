package com.piesat.user.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页的工具类
 *  Created by fanxiaodan on 2018/05/28
 */
public class PagingUtils {
    /**
     * 每页显示的条数
    private static int count=2;*/

    /**
     * 进行分页
     * @param info   所有信息
     * @param pageNo   第几页
     * @param pageCount   每页显示的数量
     * @param <T>
     * @return
     */
    public static <T> List<T> getPageInfo(List<T> info,int pageNo,int pageCount){
        List<T> list=new ArrayList<T>();
        int start=(pageNo-1)*pageCount;
        int size=info.size();
        int end=pageNo*pageCount>size?size:pageNo*pageCount;
        if(start<=end){
            list=info.subList(start,end);
        }
        return list;
    }
}
