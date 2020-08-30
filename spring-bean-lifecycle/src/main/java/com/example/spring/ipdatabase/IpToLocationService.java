package com.example.spring.ipdatabase;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class IpToLocationService implements BeanFactoryAware {

    DefaultListableBeanFactory listableBeanFactory;
    IpDatabaseRepo ipDatabaseRepo;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        listableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        updateDatabaseInfo();
    }

    public void updateDatabaseInfo() {
        String updateUrl = "https://download.acme.com/latest/ip-address-database.mdb";

        AbstractBeanDefinition definition = BeanDefinitionBuilder
                .genericBeanDefinition(IpDatabaseRepo.class)
                .addConstructorArgValue(updateUrl)
                .getBeanDefinition();

        listableBeanFactory.registerBeanDefinition("ipDatabaseRepository", definition);
        ipDatabaseRepo = listableBeanFactory.getBean(IpDatabaseRepo.class);
    }

    public String getCountryByIp(String ipAddress) {
        return ipDatabaseRepo.lookup(ipAddress);
    }
}
