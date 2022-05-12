package app.mapper;

import app.dto.UserOrderDto;
import app.dto.UserOrderDtoToAdd;
import app.entity.UserOrder;

import java.util.ArrayList;
import java.util.List;

public class UserOrderMapper {
    public static List<UserOrderDto> getUserOrderDtoFromUserOrder(List<UserOrder> userOrders) {
        List<UserOrderDto> userOrderDtos = new ArrayList<>();
        for (UserOrder userOrder : userOrders) {
            UserOrderDto userOrderDto = new UserOrderDto();
            userOrderDto.setId(userOrder.getId());
            userOrderDto.setCustomer(userOrder.getClient().getName());
            userOrderDto.setProductName(userOrder.getProduct().getProduct() + " "
                    + userOrder.getProduct().getName());
            userOrderDto.setColor(userOrder.getProduct().getColor());
            userOrderDto.setAmount(userOrder.getAmount());
            userOrderDto.setPrice(userOrder.getProduct().getPriceId().getPrice());
            userOrderDto.setDate(userOrder.getDate());
            userOrderDto.setPay(userOrder.getPay());
            userOrderDto.setStatus(userOrder.getStatus());
            userOrderDtos.add(userOrderDto);
        }
        return userOrderDtos;
    }

    public static UserOrder getUserOrderFromUserOrderDto(UserOrderDtoToAdd userOrderDtoToAdd) {
        UserOrder userOrder = new UserOrder();
        return null;
    }
}