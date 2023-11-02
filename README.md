# 工具说明
## 配置类
### 日志配色规则类
> 该自定义转换规则仅适用于 Logback 日志框架。

提供日志信息配色信息类。使用说明如下： 

第一步：在日志配置文件中添加转换规则，定义转换规则名称：`conversionWord="customcolor"`
以及指定转换规则类，代码如下：
```xml
<?xml version="1.0" encoding="UTF-8" ?>
 <configuration scan="true" scanPeriod="30000">
    <!--  全局变量配置  -->
    <!-- 自定义颜色 -->
    <conversionRule conversionWord="customcolor" converterClass="com.fuermao.tools.config.LogbackColorfulConfig"/>
</configuration>
```
第二步：配置输出源，主要是配置日志信息输出格式，需要只用自定义转换规则，代码如下：
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<configuration scan="true" scanPeriod="30000">
    <!--  全局变量配置  -->
    <!-- 自定义颜色 -->
    <conversionRule conversionWord="customcolor" converterClass="com.fuermao.tools.config.LogbackColorfulConfig"/>
    <!--  输出源配置  -->
    <appender class="ch.qos.logback.core.ConsoleAppender" name="CONSOLE_APPENDER">
        <target>System.out</target>
        <immediateFlush>true</immediateFlush>
        <withJansi>false</withJansi>
        <encoder>
            <pattern>
                %white(┏ %d{yyyy-MM-dd HH:mm:ss.SSS}) %customcolor([%5level]) %white([%10.10t] %30.30lo{29})：%n%white(┗ 日志信息：%msg%n)
            </pattern>
        </encoder>
    </appender>
    <!--  日志记录器配置  -->
    <root level="Trace">
        <appender-ref ref="CONSOLE_APPENDER"/>
    </root>
</configuration>
```
第三步，完成上述配置即可在其他日志信息中使用。

## 实体类
### Person
#### 介绍
用于创建随机人类信息，该实体类可随机创建人物的姓名、年龄等信息。该类仅提供了两个属性如下：

1. `name` 人物的名字属性。
2. `age` 人物的年龄属性。

以及对应的 `setter` 方法以及 `getter` 方法如下：
1. `setName()` 创建人物的随机名称，其还有另一种重载方法`setName(String name)` 用于设置人物的指定姓名。
2. `setAge()` 创建人物的随机年龄，其还有一种重载方法`setAge(int age)` 用于设置人物的指定年龄。
#### 相关类
与其相关的类有 `AgeSegmentation` 以及 `CreateNameTools`。这两个类的作用如下：

* `AgeSegmentation` 枚举类，年龄分段。该类目前提供了 6 种年龄分段。提供了 4 个属性（`displayName`该年龄段显示名称、`minAge` 该年龄段最小年龄、`maxAge` 该年龄段最大年龄、`index` 该年龄段的索引值），
枚举常量如下所示：
  * `INFANT("婴幼儿", 0, 6, 0)`
  * `CHILDREN("少年", 7, 12, 1)`
  * `TEENAGERS("青少年", 8, 17, 2)`
  * `YOUTHS("青年", 18, 45, 3)`
  * `MIDDLE_AGED("中年人", 46, 69, 4)`
  * `AGED("老年人", 70, 120, 5)`
* `CreateNameTools` 主要用于创建随机名字。该类提供了两个方法，如下：
  * `createName()` 创建随机长度的名字。
  * `createName(int length)` 创建指定长度的名字。

## 工具类
### StatisticsRunTimeTools
该类用于统计代码运行时间，并通过日志输出代码的运行时间。该类提供了一个静态方法，如下：

* `public static void statistic(IStatisticsRunTimes statisticsRunTimes)` 直接调用该方法即可。

也可实现接口 `IStatisticsRunTimes`。该接口是一个函数式接口。使用方法如下：

```java
class StatisticsRunTimeToolsTest {
	
  @Test
  @DisplayName("测试方法执行的时间")
  void statistic() {
    assertDoesNotThrow(()->{
      IStatisticsRunTimes times = () -> {
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      };
      StatisticsRunTimeTools.statistic(times);
    });
  }
}
```
### LogToLogger
将信息记录到日志记录器中，提供了两个公共方法，如下：
```java
/**
 * 根据日志等级将信息输出到日志中
 * @param logStr String 需要记录的日志信息
 * @param logger Logger 日志记录器
 * @param level Level 日志等级
 */
public static void log(String logStr,Logger logger,Level level)

/**
 * 将异常信息记录到日志中
 * @param throwable Throwable 异常信息
 * @param logger Logger 日志记录器
 * @param level Level 日志等级
 */
public static void throwableToLogger(Throwable throwable, Logger logger, Level level)
```