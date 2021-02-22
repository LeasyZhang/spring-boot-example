package example.boot.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PermissionServiceImpl implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private List<PermissionCheckHandler> permissionCheckHandlerList = new ArrayList<>();

    public String permissionCheck(Long userId, String code, String type) {
        PermissionCheckHandler handler = getHandler(type);
        return handler.permissionCheck(userId, code);
    }

    private PermissionCheckHandler getHandler(String type) {
        for (PermissionCheckHandler handler : permissionCheckHandlerList) {
            if (handler.isMatched(type)) {
                return handler;
            }
        }

        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (PermissionCheckHandler handler : applicationContext.getBeansOfType(PermissionCheckHandler.class).values()) {
            permissionCheckHandlerList.add(handler);
            log.warn("load permission check handler {}", handler.getClass().getName());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
