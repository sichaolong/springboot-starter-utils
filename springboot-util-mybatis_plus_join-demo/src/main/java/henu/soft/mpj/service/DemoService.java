package henu.soft.mpj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import henu.soft.mpj.dto.OrderDto;
import henu.soft.mpj.mapper.OrderMapper;
import henu.soft.mpj.pojo.Order;
import henu.soft.mpj.pojo.Product;
import henu.soft.mpj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.security.RunAs;
import java.util.List;

@Service
public class DemoService {

    /**
     * 以order表为主表，只需要OrderMapper即可
     *
     */

    @Autowired
    OrderMapper orderMapper;


    /**
     *
     * 不用写xml完成左右连接查询,具体测试在test包
     *
     * 首先，调用mapper的selectJoinList()方法，进行关联查询，返回多条结果。
     *
     * 后面的第一个参数OrderDto.class代表接收返回查询结果的类，作用和我们之前在xml中写的resultType类似。
     */

    public void getOrder() {
        List<Order> orders = orderMapper.selectList(new QueryWrapper<>());
        System.out.println(orders);
        List<OrderDto> list = orderMapper.selectJoinList(OrderDto.class,
                new MPJLambdaWrapper<Order>()
                        .selectAll(Order.class) // 主表
                        .select(Product::getUnitPrice)
                        .selectAs(User::getName,OrderDto::getUserName) // user.name as orderDto.userName
                        .selectAs(Product::getProductName,OrderDto::getProductName) // product.productName as orderDto.productName
                        .leftJoin(User.class, User::getId, Order::getUserId) //order left join user on user.id = order.userId
                        .leftJoin(Product.class, Product::getId, Order::getProductId) // order left join product on product.id = order.productId
                        .eq(Order::getStatus,1)); // status = 1;

        list.forEach(System.out::println);
    }
}
