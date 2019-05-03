Plz check HuffmanCode.java

Modify the main method (changing the characters, pmf or D) and run it.

This code based on the fact that for D-ary Huffman codes, we need fixed amount of steps. Each step is treated as a layer and therefore, build a tree by adding multiple layers.

For example, four elements 

```java
map.put("A", 0.28182733);
map.put("T", 0.28302858);
map.put("C", 0.21806686);
map.put("G", 0.21707721);
```

have a layer-tree (D=2) like:

```
=================Layer1==================
||  G		||  C		||  A		||  T		||
||  0.217	||  0.218	||  0.281	||  0.283	||
=================Layer2==================
||  GC		||  A		||  T		||
||  0.435	||  0.281       ||  0.283       ||
=================Layer3==================
||  AT			||  GC			||
||  0.564		||  0.435		||
=================Layer4==================
||  GCAT			||
||  0.999			||
=========================================
```

After the tree is built, numbers will be given from higher layer to lower. Therefore, generate Huffman codes at the bottom layer (layer 1).
