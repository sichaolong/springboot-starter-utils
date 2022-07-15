package henu.soft.mpj.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private Long id;
    private String productName;
    private String unitPrice;
}
