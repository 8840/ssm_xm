package com.chendongyang;

import com.chendongyang.util.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 处理* *..*Service.*Pager(..)符合这个方法，只要调用这个方法就能够达到分页的效果
 * PageHelper.start();
 * 调用目标方法之前
 * 处理结果集
 */
/*https://github.com*/
@Component
@Aspect
public class PageAspect {
    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable{
//        判断符合条件的方法中是否包含pagebean参数
        Object[] params = args.getArgs();
        PageBean pageBean=null;
        for (Object param : params) {
            if(param instanceof PageBean){
                pageBean = (PageBean)param;
                break;
            }
        }
        if(pageBean !=null && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        Object list = args.proceed(params);
        if(pageBean!=null && pageBean.isPagination()){
            PageInfo pageInfo=new PageInfo((List) list);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return list;
    }

}
