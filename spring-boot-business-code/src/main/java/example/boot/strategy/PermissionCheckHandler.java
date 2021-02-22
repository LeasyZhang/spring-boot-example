package example.boot.strategy;

public interface PermissionCheckHandler {

    boolean isMatched(String type);

    String permissionCheck(Long userId, String code);
}
