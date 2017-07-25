package com.beingmate.common.beancopier;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by yanhaizhe on 2017/2/23.
 */
public class BeanCopierUtils {

    public static void copyProperties(Object source, Object target) {
        if (source == null) {
            return;
        }
        try {
            BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            copier.copy(source, target, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param source
     * @param target
     * @param targetBeanClass
     */
    public static <T, E> void copyListBean(List<T> source, List<E> target,
                                           Class<? extends E> targetBeanClass) {
        if (CollectionUtils.isEmpty(source) || null == target) {
            return;
        }
        E targetBean;
        try {
            for (T srcBean : source) {
                targetBean = createInstance(targetBeanClass);
                BeanCopier copier = BeanCopier.create(srcBean.getClass(), targetBean.getClass(), false);
                copier.copy(srcBean, targetBean, null);
                target.add(targetBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static <T> T createInstance(Class<T> cls) {
        T obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            obj = null;
            e.printStackTrace();
        }
        return obj;
    }

}
