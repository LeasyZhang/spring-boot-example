package example.boot.strategy;

import org.springframework.stereotype.Component;

@Component
public class ColdStartPermissionCheckHandler implements PermissionCheckHandler{
    @Override
    public boolean isMatched(String type) {
        return "COLD_START".equalsIgnoreCase(type);
    }

    @Override
    public String permissionCheck(Long userId, String code) {
        return null;
    }
}
