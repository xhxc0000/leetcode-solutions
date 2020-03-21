#### L946 验证栈的弹出序列
关键是明白迭代哪个部分 -> push数组
while -> 栈顶和pop相等, 则出栈

最后根据stack是否全匹配(空)来验证

#### NL1 IP to INT
位运算, ip分4部分, 每部分可以占用int类型的8个bit位

#### NL2 BitMap
可以用于大数据量判重, 大数据量排序; 每个bit位代表一个int值是否存在
计算byteIndex, bitIndex

#### NL3 HeapSort
以最大堆为例, 首先算法过程分为**建堆**和**提取最小值**两个部分

建堆过程中, 从倒数第二层开始遍历, 挨个进行down操作
提取最小值中, 交换堆顶到末尾

down操作是, 如果左右子节点, 存在比自己大的, 则将做大值交换 -> 递归操作
不存在则结束down

#### NL4 Trie树
实现word的insert, search, startWith操作
自定义Node内部类  isLeaf, child[26];

结构内部保持一个Root节点, 通过root可达则表示word存在
