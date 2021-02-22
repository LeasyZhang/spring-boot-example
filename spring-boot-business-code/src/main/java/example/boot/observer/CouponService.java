package example.boot.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CouponService {

    @EventListener
    public void addCoupon(UserRegisterEvent event) {
        log.info("Add coupon for user {}", event.getUserName());
    }
}
