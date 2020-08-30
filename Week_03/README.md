# week3学习总结
递归一般用于解决最近重复性问题，递归的代码模版：

``` Java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```
递归可细分为分治和回溯：分治和回溯的概念虽然能够懂得大概的意思，但还需要更多的实际练习来巩固和加深理解。

这周还是没有将练习的数量提升上去，下周开始需加强，针对某一类的概念通过习题来巩固。