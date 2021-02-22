package example.boot.strategy;

import org.springframework.stereotype.Component;

@Component
public class TrendPermissionCheckHandler implements PermissionCheckHandler{
    @Override
    public boolean isMatched(String type) {
        return "TREND".equalsIgnoreCase(type);
    }

    @Override
    public String permissionCheck(Long userId, String code) {
        return null;
    }
}
