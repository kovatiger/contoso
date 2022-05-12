package app.controller;

import app.dto.ClientDto;
import app.dto.UserOrderDto;
import app.dto.UserOrderDtoToAdd;
import app.entity.Client;
import app.entity.UserOrder;
import app.mapper.ClientMapper;
import app.mapper.UserOrderMapper;
import app.service.user_order_service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping("/userOrder")
    public ResponseEntity<List<UserOrderDto>> getAllUserOrders() {
        List<UserOrder> userOrders = userOrderService.findAll();
        if (!userOrders.isEmpty()) {
            List<UserOrderDto> userOrderDtos = UserOrderMapper.getUserOrderDtoFromUserOrder(userOrders);
            return new ResponseEntity<>(userOrderDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/userOrder/add")
    public HttpStatus saveUserOrder(@RequestBody final UserOrderDtoToAdd userOrderDtoToAdd) {
        if (userOrderDtoToAdd != null) {
            UserOrder userOrder = UserOrderMapper.getUserOrderFromUserOrderDto(userOrderDtoToAdd);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }


}
