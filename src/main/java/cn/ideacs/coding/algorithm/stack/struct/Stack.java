package cn.ideacs.coding.algorithm.stack.struct;

import lombok.Data;

/**
 * 数据结构--栈
 * 使用链表的方式实现
 * 只能操作栈顶元素
 * @param <T>
 */
public class Stack<T> {

    /**
     * 栈中元素节点类
     * @param <T>
     */
    @Data
    class Node<T> {
        /** 节点真实数字 */
        private T data;

        /** 节点的上一个元素引用 */
        private Node pre;
    }

    /** 栈顶元素的引用 */
    private Node tail;

    /** 栈中元素的数量 */
    private Integer size = 0;

    /**
     * 判断是否是空栈
     * 这里的落实是判断栈顶引用是否为空，也可以根据size == 0来判断。
     * @return
     */
    public Boolean isEmpty() {
        return tail == null;
    }

    /**
     * 取出栈顶元素并获得其值
     * @return
     */
    public T pull() {
        Node node = tail;
        if (node == null) {
            return null;
        } else {
            tail = tail.pre;
            size--;
            return (T) node.getData();
        }
    }

    /**
     *  获得栈顶元素的值，但不取出栈顶元素。
     * @return
     */
    public T get() {
        if (tail == null) {
            return null;
        } else {
            return (T) tail.getData();
        }
    }

    /**
     * 向栈中压入一个对应值的元素。
     * @param value
     */
    public void push(T value) {
        Node<T> node = new Node<T>();
        node.setData(value);
        node.setPre(tail);
        tail = node;
        size++;
    }
}
