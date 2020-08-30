package com.example.spring.ipdatabase;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class IpToLocationService implements BeanFactoryAware {

    DefaultListableBeanFactory listableBeanFactory;
    IpDatabaseRepo ipDatabaseRepo;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        listableBeanFactory = (DefaultListableBeanFactory)beanFactory;
        updateDatabaseInfo();
    }

    public void updateDatabaseInfo() {

    }
}
