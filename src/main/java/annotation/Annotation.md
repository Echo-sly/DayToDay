## 几个基本注解

### 1. 在java.lang.包下

- @Override  
  定义在 java.lang.Override 中 , 此注释只适用于修辞方法 , 表示一个方法声明打算重写超类中 的另一个方法声明.
- @Deprecated  
  定义在java.lang.Deprecated中 , 此注释可以用于修辞方法 , 属性 , 类 , 表示不鼓励程序员使用这样的元素 , 通常是因为它很危险或者存在更好的选择 .
- @SuppressWarnings  
  定义在java.lang.SuppressWarnings中,用来抑制编译时的警告信息. 与前两个注释有所不同,你需要添加一个参数才能正确使用,这些参数都是已经定义好了的,我们 选择性的使用就好了 .  
  @SuppressWarnings("all")  
  @SuppressWarnings("unchecked")  
  @SuppressWarnings(value={"unchecked","deprecation"})等等

### 2. 在java.lang.annotation包下

- 此包下的注解全部是元注解，元注解的作用就是负责注解其他注解 , Java定义了4个标准的meta-annotation类型,他们被用来提供 对其他annotation类型作说明 .
- @Target : 用于描述注解的使用范围(即:被描述的注解可以用在什么地方)
- @Retention : 表示需要在什么级别保存该注释信息 , 用于描述注解的生命周期  
  (SOURCE < CLASS < RUNTIME)
- @Document：说明该注解将被包含在javadoc中
- @Inherited：说明子类可以继承父类中的该注解

```java
package com.annotation;
		import java.lang.annotation.*;

//定义一个注解 
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface MyAnnotation {
	class Test2 {
		@MyAnnotation
		public void test() {
		}
	}
}```