#### L51 n皇后(求所有路径)
基本逻辑跟L52一样, try and cancel设置 `Q`, `.`
address() 遍历`[][]` 数组, 添加棋盘整体摆放位置

```java
for (0 to n) {
  if (...) {
    . -> Q
    ...
    dfs()
    ...
    Q -> .
  }
}
```
#### L52 n皇后2(只求次数)
为dfs, 每层递归栈, 遍历每个col

col[n]标志列访问, diag[2n]标志正对角线, ndiag标志反对角线

正: y = x + k -> k = y - x; 因为k取值 +- n, 故将结果 + n, 改为值域[0, 2n]
```java
for (0 to n) {
  if (列, 正对角线, 反对角线) {
    try, dfs, cancel
  }
}
```
