#### 1. two sum

原来想的是先一遍循环put, 再判断是否存在 target - nums[k]

这样会产生严重的问题, [2, 1] target=4 这样就会返回错误结果

最好的解决办法是 for each num -> check first than put

#### 2. add two numbers

给出两个非空的链表用来表示两个非负的整数, 逆序方式存储.  如果将这两个数相加, 则会返回一个新的链表来表示他们的和.   除了0之外,这两个数都不会以0开头

eg (2 -> 4 -> 3) + (5 -> 6 -> 4) = (7 -> 0 -> 8)     342 + 465 = 807

结构可以从两个链表merge的过程修改, 还要处理进位
update 两个链表merge的结构还可以优化成一个while!

#### 3. length of longest substring
eg. abcabcbb -> 3  bbbb -> 1   pwwkew -> 3
维护一个滑动窗口, left表示窗口左边界, right 表示窗口右边界
char[256] map 表示哈希表
arr[str[right]] > 0 -> 窗口滑动 map数量置0, 移动left, 重新计算res
arr[str[right] == 0] -> 窗口滑动 put str[right], right++
最后, 重新计算 res
