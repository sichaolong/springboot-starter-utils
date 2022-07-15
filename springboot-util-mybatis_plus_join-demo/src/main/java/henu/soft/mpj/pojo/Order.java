package henu.soft.mpj.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private Long id;
    private Long orderNumber;
    private Long userId;
    private Long money;
    private Integer status;
    private Long productId;
}
