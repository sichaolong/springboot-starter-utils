package henu.soft.mpj.dto;

import henu.soft.mpj.pojo.Order;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends Order {
    String userName;
    String productName;
    Double unitPrice;
}
