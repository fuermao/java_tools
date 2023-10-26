package com.fuermao.tools.entity;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Person Entity 测试")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonTest {

    private static final Logger logger = LoggerFactory.getLogger(PersonTest.class);

    private Person p1;

    private Person p2;

    @BeforeAll
    void before(){
        p1 = new Person();
        p1.setName();
        p1.setAge();
        p2 = new Person("张三",88);
    }

    @Test
    void test(){
        logger.debug(p1.toString());
        logger.debug(p2.toString());
        logger.debug("{} 的年龄是：{} 岁。",p1.getName(),p1.getAge());
        logger.debug("{} 的年龄是：{} 岁。",p2.getName(),p2.getAge());
    }

    @Test
    @DisplayName("测试实体类的 Hash 值")
    void testHashCode() {
        int hashCode1 = p1.hashCode();
        String s1 = Integer.toHexString(hashCode1);
        String hexString1 = Integer.toHexString(System.identityHashCode(p1));

        int hashCode2 = p2.hashCode();
        String s2 = Integer.toHexString(hashCode2);
        String hexString2 = Integer.toHexString(System.identityHashCode(p2));
        Assertions.assertEquals(hexString1,s1);
        Assertions.assertEquals(hexString2,s2);
        logger.debug("person1（{}）的 hashCode 为：{}，转为十六进制为：{}，系统生成的 Hash 值为：{}", p1, hashCode1, s1, hexString1);
        logger.debug("person2（{}）的 hashCode 为：{}，转为十六进制为：{}，系统生成的 Hash 值为：{}", p2, hashCode2, s2, hexString2);
    }

}