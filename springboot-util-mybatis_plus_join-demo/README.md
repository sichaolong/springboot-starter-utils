### mybatis plus table left and right join starter util 工具简介

mybatis-plus作为mybatis的增强工具，它的出现极大的简化了开发中的数据库操作，但是长久以来，它的联表查询能力一直被大家所诟病。一旦遇到left join或right join的左右连接，你还是得老老实实的打开xml文件，手写上一大段的sql语句。

直到前几天，偶然碰到了这么一款叫做mybatis-plus-join的工具（后面就简称mpj了），使用了一下，不得不说真香！彻底将我从xml地狱中解放了出来，终于可以以类似mybatis-plus中QueryWrapper的方式来进行联表查询了，话不多说，我们下面开始体验。


### 使用步骤

1、依赖
```xml
<dependency>
    <groupId>com.github.yulichang</groupId>
    <artifactId>mybatis-plus-join</artifactId>
    <version>1.2.4</version>
</dependency>

<!--以及mybatis-plus的依赖-->

```

2、新建数据库表user、order、product以及实体

3、编写相应的Mapper、service等

以往在使用myatis-plus的时候，我们的Mapper层接口都是直接继承的BaseMapper，使用mpj后需要对其进行修改，改为继承MPJBaseMapper接口。

```java
@Mapper
public interface OrderMapper extends MPJBaseMapper<Order> {
}
//对其余两个表的Mapper接口也进行相同的改造。此外，我们的service也可以选择继承MPJBaseService，serviceImpl选择继承MPJBaseServiceImpl，这两者为非必须继承。




```


4、测试使用

