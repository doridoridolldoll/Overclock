package overclock.overclock.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import overclock.overclock.dto.OrderDTO;
import overclock.overclock.entity.*;
import overclock.overclock.model.DeliveryStatus;
import overclock.overclock.repository.MemberRepository;
import overclock.overclock.repository.OrderRepository;

import java.util.List;

public interface OrderService {

    Long order(Long memberId, Long itemId, int count);

}

