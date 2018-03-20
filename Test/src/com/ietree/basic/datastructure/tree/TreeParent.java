package com.ietree.basic.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ietree
 * 2017/4/30
 */
public class TreeParent<E> {

    public static class Node<T> {

        T data;
        // �����丸�ڵ��λ��
        int parent;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, int parent) {
            this.data = data;
            this.parent = parent;
        }

        public String toString() {
            return "TreeParent$Node[data=" + data + ", parent=" + parent + "]";
        }

    }

    private final int DEFAULT_TREE_SIZE = 100;
    private int treeSize = 0;
    // ʹ��һ��Node[]��������¼����������нڵ�
    private Node<E>[] nodes;
    // ��¼���Ľڵ���
    private int nodeNums;

    // ��ָ���ڵ㴴����
    public TreeParent(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data, -1);
        nodeNums++;
    }

    // ��ָ�����ڵ㡢ָ��treeSize������
    public TreeParent(E data, int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data, -1);
        nodeNums++;
    }

    // Ϊָ���ڵ�����ӽڵ�
    public void addNode(E data, Node parent) {
        for (int i = 0; i < treeSize; i++) {
            // �ҵ������е�һ��Ϊnull��Ԫ�أ���Ԫ�ر����½ڵ�
            if (nodes[i] == null) {
                // �����½ڵ㣬����ָ��������Ԫ�ر�����
                nodes[i] = new Node(data, pos(parent));
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("�����������޷�����½ڵ�");
    }

    // �ж����Ƿ�Ϊ��
    public boolean empty() {
        // ������Ƿ�Ϊnull
        return nodes[0] == null;
    }

    // ���ظ��ڵ�
    public Node<E> root() {
        // ���ظ��ڵ�
        return nodes[0];
    }

    // ����ָ���ڵ㣨�Ǹ���㣩�ĸ��ڵ�
    public Node<E> parent(Node node) {
        // ÿ���ڵ��parent��¼���丸�ڵ��λ��
        return nodes[node.parent];
    }

    // ����ָ���ڵ㣨��Ҷ�ӽڵ㣩�������ӽڵ�
    public List<Node<E>> children(Node parent) {
        List<Node<E>> list = new ArrayList<Node<E>>();
        for (int i = 0; i < treeSize; i++) {
            // �����ǰ�ڵ�ĸ��ڵ��λ�õ���parent�ڵ��λ��
            if (nodes[i] != null && nodes[i].parent == pos(parent)) {
                list.add(nodes[i]);
            }
        }
        return list;
    }

    // ���ظ��������
    public int deep() {
        // ���ڼ�¼�ڵ��������
        int max = 0;
        for (int i = 0; i < treeSize && nodes[i] != null; i++) {
            // ��ʼ�����ڵ�����
            int def = 1;
            // m ��¼��ǰ�ڵ�ĸ��ڵ��λ��
            int m = nodes[i].parent;
            // ����丸�ڵ����
            while (m != -1 && nodes[m] != null) {
                // ���ϼ����������ڵ�
                m = nodes[m].parent;
                def++;
            }
            if (max < def) {
                max = def;
            }
        }
        return max;
    }

    // ���ذ���ָ��ֵ�Ľڵ�
    public int pos(Node node) {
        for (int i = 0; i < treeSize; i++) {
            // �ҵ�ָ���ڵ�
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

}