//
//
//package vip.xjdai.HashSet;
//
//import javax.swing.tree.TreeNode;
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.AbstractMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Set;
//
//
//public class HashMap<K, V>  {
//
//
//    //  二进制 1转换成二进制 然后位移4位
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //初始化Map 容量为 16
//
//    /**
//     * 容器的最大值 1073741824
//     * 0001 右移 30个位置不够补0
//     * 100000000000000000000000000000
//     */
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    /**
//     * The load factor used when none specified in constructor.
//     */
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    /**
//     * The bin count threshold for using a tree rather than list for a
//     * bin.  Bins are converted to trees when adding an element to a
//     * bin with at least this many nodes. The value must be greater
//     * than 2 and should be at least 8 to mesh with assumptions in
//     * tree removal about conversion back to plain bins upon
//     * shrinkage.
//     */
//    static final int TREEIFY_THRESHOLD = 8;
//
//    /**
//     * The bin count threshold for untreeifying a (split) bin during a
//     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
//     * most 6 to mesh with shrinkage detection under removal.
//     */
//    static final int UNTREEIFY_THRESHOLD = 6;
//
//    /**
//     * The smallest table capacity for which bins may be treeified.
//     * (Otherwise the table is resized if too many nodes in a bin.)
//     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
//     * between resizing and treeification thresholds.
//     */
//    static final int MIN_TREEIFY_CAPACITY = 64;
//
//    /**
//     * Basic hash bin node, used for most entries.  (See below for
//     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
//     */
//    static class Node<K, V> implements Map.Entry<K, V> {
//        final int hash;
//        final K key;
//        V value;
//        Node<K, V> next;
//
//        Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public final K getKey() {
//            return key;
//        }
//
//        public final V getValue() {
//            return value;
//        }
//
//        public final String toString() {
//            return key + "=" + value;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o instanceof Map.Entry) {
//                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
//                if (Objects.equals(key, e.getKey()) &&
//                        Objects.equals(value, e.getValue()))
//                    return true;
//            }
//            return false;
//        }
//    }
//
//    /* ---------------- Static utilities -------------- */
//
//    /**
//     * Computes key.hashCode() and spreads (XORs) higher bits of hash
//     * to lower.  Because the table uses power-of-two masking, sets of
//     * hashes that vary only in bits above the current mask will
//     * always collide. (Among known examples are sets of Float keys
//     * holding consecutive whole numbers in small tables.)  So we
//     * apply a transform that spreads the impact of higher bits
//     * downward. There is a tradeoff between speed, utility, and
//     * quality of bit-spreading. Because many common sets of hashes
//     * are already reasonably distributed (so don't benefit from
//     * spreading), and because we use trees to handle large sets of
//     * collisions in bins, we just XOR some shifted bits in the
//     * cheapest possible way to reduce systematic lossage, as well as
//     * to incorporate impact of the highest bits that would otherwise
//     * never be used in index calculations because of table bounds.
//     */
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    /**
//     * Returns x's Class if it is of the form "class C implements
//     * Comparable<C>", else null.
//     */
//    static Class<?> comparableClassFor(Object x) {
//        if (x instanceof Comparable) {
//            Class<?> c;
//            Type[] ts, as;
//            Type t;
//            ParameterizedType p;
//            if ((c = x.getClass()) == String.class) // bypass checks
//                return c;
//            if ((ts = c.getGenericInterfaces()) != null) {
//                for (int i = 0; i < ts.length; ++i) {
//                    if (((t = ts[i]) instanceof ParameterizedType) &&
//                            ((p = (ParameterizedType) t).getRawType() ==
//                                    Comparable.class) &&
//                            (as = p.getActualTypeArguments()) != null &&
//                            as.length == 1 && as[0] == c) // type arg is c
//                        return c;
//                }
//            }
//        }
//        return null;
//    }
//
//
//    /**
//     * Returns a power of two size for the given target capacity.
//     */
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//    /* ---------------- Fields -------------- */
//
//    /**
//     * The table, initialized on first use, and resized as
//     * necessary. When allocated, length is always a power of two.
//     * (We also tolerate length zero in some operations to allow
//     * bootstrapping mechanics that are currently not needed.)
//     */
//    transient Node<K, V>[] table;
//
//    /**
//     * Holds cached entrySet(). Note that AbstractMap fields are used
//     * for keySet() and values().
//     */
//    transient Set<Map.Entry<K, V>> entrySet;
//
//    /**
//     * The number of key-value mappings contained in this map.
//     */
//    transient int size;
//
//    /**
//     * The number of times this HashMap has been structurally modified
//     * Structural modifications are those that change the number of mappings in
//     * the HashMap or otherwise modify its internal structure (e.g.,
//     * rehash).  This field is used to make iterators on Collection-views of
//     * the HashMap fail-fast.  (See ConcurrentModificationException).
//     */
//    transient int modCount;
//
//    /**
//     * 阀值
//     */
//    int threshold;
//
//    /**
//     * The load factor for the hash table.
//     *
//     * @serial
//     */
//    final float loadFactor;
//
//
//
//    //初始
//    public HashMap() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//    }
//
//
//
//    /**
//     * Returns the number of key-value mappings in this map.
//     *
//     * @return the number of key-value mappings in this map
//     */
//    public int size() {
//        return size;
//    }
//
//
//
//
//
//
//    /**
//     * Associates the specified value with the specified key in this map.
//     * If the map previously contained a mapping for the key, the old
//     * value is replaced.
//     *
//     * @param key   key with which the specified value is to be associated
//     * @param value value to be associated with the specified key
//     * @return the previous value associated with <tt>key</tt>, or
//     * <tt>null</tt> if there was no mapping for <tt>key</tt>.
//     * (A <tt>null</tt> return can also indicate that the map
//     * previously associated <tt>null</tt> with <tt>key</tt>.)
//     */
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//    /**
//     * 具体的添加
//     *
//     * @param hash
//     * @param key
//     * @param value
//     * @param onlyIfAbsent
//     * @param evict
//     * @return
//     */
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {
//        Node<K, V>[] tab;
//        Node<K, V> p;
//        int n, i;
//        //==null 或者==0 的时候去初始化容器
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//        else {
//            Node<K, V> e;
//            K k;
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k)))) {
//                e = p;
//            } else if (p instanceof TreeNode)
//                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        //当数组大于阀值
//        if (++size > threshold)
//            //进行扩容
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//    void afterNodeAccess(Node<K,V> p) { }
//    void afterNodeInsertion(boolean evict) { }
//    final void treeifyBin(Node<K,V>[] tab, int hash) {
//        int n, index; Node<K,V> e;
//        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
//            resize();
//        else if ((e = tab[index = (n - 1) & hash]) != null) {
//            TreeNode<K,V> hd = null, tl = null;
//            do {
//                TreeNode<K,V> p = replacementTreeNode(e, null);
//                if (tl == null)
//                    hd = p;
//                else {
//                    p.prev = tl;
//                    tl.next = p;
//                }
//                tl = p;
//            } while ((e = e.next) != null);
//            if ((tab[index] = hd) != null)
//                hd.treeify(tab);
//        }
//    }
//    /**
//     * 初始化和扩容
//     *
//     * @return
//     */
//    final Node<K, V>[] resize() {
//        Node<K, V>[] oldTab = table;
//        //老容器的长度
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        //阀值
//        int oldThr = threshold;
//        //新容器的 长度和阀值
//        int newCap, newThr = 0;
//        //老容器的数据长度>0
//        if (oldCap > 0) {
//            //判断是否大于容器的
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                //如果是最大值则把Int类型的最大值赋值给阀值
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        } else if (oldThr > 0) // initial capacity was placed in threshold
//            newCap = oldThr;
//        else {
//            //初始化容器
//            newCap = DEFAULT_INITIAL_CAPACITY;
//            //初始化容器的阀值
//            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//        }
//        //如果新阀值==0
//        if (newThr == 0) {
//            // 新长度 * 阀值
//            float ft = (float) newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
//                    (int) ft : Integer.MAX_VALUE);
//        }
//        //新阀值赋值给全局
//        threshold = newThr;
//        //创建容器
//        @SuppressWarnings({"unchecked"})
//        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
//        //把新容器赋值给 全局table
//        table = newTab;
//        if (oldTab != null) {
//            for (int j = 0; j < oldCap; ++j) {
//                Node<K, V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null) {
//                        newTab[e.hash & (newCap - 1)] = e;
//                    } else if (e instanceof TreeNode) {
//                        ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);
//                    } else { // preserve order
//                        Node<K, V> loHead = null, loTail = null;
//                        Node<K, V> hiHead = null, hiTail = null;
//                        Node<K, V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            } else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
//
//
//    HashMap.Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
//        return new HashMap.Node<>(hash, key, value, next);
//    }
//   TreeNode<K,V> replacementTreeNode(Node<K,V> p, Node<K,V> next) {
//        return new TreeNode<>(p.hash, p.key, p.value, next);
//    }
//}
