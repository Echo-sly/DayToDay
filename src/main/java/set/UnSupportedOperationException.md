## `出现UnSupportedOperationException的原因`

```java
List list1 = new ArrayList();
  list1.add("test");
String[] array = new String[2]; 
List list2 = Arrays.asList(array);
list2.add("test");//抛出异常
```

在上述代码中，list1是正常创建的list，可以进行增删内容。
而list2是通过Arrays.asList方法获得的，是一个固定大小的list,不允许进行添加。
强行添加元素就会报UnSupportedOperationException 异常。

