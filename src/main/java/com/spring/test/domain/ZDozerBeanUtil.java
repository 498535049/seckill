package com.spring.test.domain;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ZDozerBeanUtil {
    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @SuppressWarnings("unchecked")
    public <P> P clone(P base) {
        if (base == null) {
            return null;
        } else {
            return (P) dozerBeanMapper.map(base, base.getClass());
        }
    }

    public <P> List<P> cloneList(List<P> baseList) {
        if (baseList == null) {
            return null;
        } else {
            List<P> targetList = new ArrayList<P>();
            for (P p : baseList) {
                targetList.add((P) clone(p));
            }
            return targetList;
        }
    }

    public <V, P> P convert(V base, P target) {
        if (base != null) {
            dozerBeanMapper.map(base, target);
            return target;
        }
        return target;
    }

    public <V, P> P convert(V base, Class<P> target) {
        if (base == null) {
            return null;
        } else {
            P p = (P) dozerBeanMapper.map(base, target);
            return p;
        }
    }

    public <V, P> List<P> convertList(List<V> baseList, Class<P> target) {
        if (baseList == null) {
            return null;
        } else {
            List<P> targetList = new ArrayList<P>();
            for (V vo : baseList) {

                targetList.add((P) convert(vo, target));
            }
            return targetList;
        }
    }

    public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

}
