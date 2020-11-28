package zz.qihua.algorithm;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

import zz.qihua.algorithm.tree.Node;
import zz.qihua.algorithm.tree.TreeUtil;

public class Algorithm {
	public static void main(String[] args) {
//		3,2,31,29,18,8,6,5,7
		int[] sample=Arrays.stream(TreeUtil.randomArray(1520,0,2000)).distinct().toArray();
		System.out.println(Arrays.toString(sample));
		IntSummaryStatistics statistics=Arrays.stream(sample).summaryStatistics();
		Node<Integer> head=TreeUtil.AVLTree(sample);
		System.out.println(TreeUtil.walkLPR(head));
		System.out.println(statistics);
	}

} 
