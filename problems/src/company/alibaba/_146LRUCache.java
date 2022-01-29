package company.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * @Author Zhang Qihang
 * @Date 2022/1/29 16:41
 */
public class _146LRUCache {

    class LRUCache {

        // 新建一个双向链表
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;

            public DLinkedNode() {

            }

            public DLinkedNode(int key, int value) {
                // 必须要同时存key和value，如果只存value的话，超出容量的时候没法删除
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DLinkedNode> map = new HashMap<>();
        // 虚拟的头、尾节点
        private DLinkedNode head, tail;
        // 当前容量
        private int size;
        // 总容量
        private int capacity;

        // 构造函数
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            // 创建虚拟头节点和为节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            // next和pre在这里进行定义与使用
            head.next = tail;
            tail.pre = head;
        }

        // 移除给定节点的通用方法
        private void removeNode(DLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        // 将节点放到头部
        private void addToHead(DLinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        // 移动节点到头部，包含上面两种
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        // 删除队末节点，同时返回其key
        private int removeTail() {
            DLinkedNode last = tail.pre;
            removeNode(tail.pre);
            return last.key;
        }

        public int get(int key) {
            DLinkedNode res = map.get(key);
            // 如果存在，那么返回对应位置，并且往后放
            if (res != null) {
                moveToHead(res);
                return res.value;
            } else {
                return -1;
            }
            // 如果不存在返回-1
        }

        public void put(int key, int value) {
            //先判断要put的这个值有没有
            DLinkedNode res = map.get(key);
            if (res != null) {
                // 修改值，并且往前挪就行
                res.value = value;
                moveToHead(res);
            } else {
                // 如果不存在的话，创建一个新的链表节点
                DLinkedNode node = new DLinkedNode(key, value);
                map.put(key, node);
                // 添加到链表的头部
                addToHead(node);
                // 如果已经超出容量
                this.size++;
                if (this.size > this.capacity) {
                    // 删除最后面的节点，记得删除对应的项
                    int delKey = removeTail();
                    // 删除哈希表中存的对应的项
                    map.remove(delKey);
                    this.size--;
                }
            }
        }
    }
}
