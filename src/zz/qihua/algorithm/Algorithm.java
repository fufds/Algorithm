package zz.qihua.algorithm;

import zz.qihua.algorithm.tree.Node;
import zz.qihua.algorithm.tree.TreeUtil;

public class Algorithm {
	public static void main(String[] args) {
//		3,2,328,8,6,5,7
		Node<Integer> head=TreeUtil.AVLTree(new int[] {3,2,328,8,6,507});
		System.out.println(TreeUtil.walkLPR(head));
	}

} 
