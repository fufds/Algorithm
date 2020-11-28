package zz.qihua.algorithm.tree;

import java.util.Optional;
import java.util.Random;

public class TreeUtil {
	
	
	public static int[] randomArray(int length,int min,int max) {
		int[] array=new int[length];
		Random rnd=new Random();
		for(int i=0;i<length;i++) {
			array[i]=rnd.nextInt(max)+min;
		}
		return array;
	}
	public static int[] randomArray(int length) {
		return randomArray(length,1,20);
	}
	public static int[] randomArray() {
		return randomArray(10,1,20);
	}
	public static Node<Integer> BSTree(int nodeCounts){
		return BSTree(randomArray(nodeCounts));
	}
	public static Node<Integer> BSTree(int[] arr){
		if(arr==null||arr.length==0)
			return null;
		Node<Integer> head=new Node<Integer>(arr[0]);
		for(int i=1;i<arr.length;i++) {
			BSTreeAdd(head, new Node<Integer>(arr[i]));
//			Node<Integer> tmp=head;
//			while(true) {
//				if(arr[i]>tmp.val) {
//					if(tmp.right==null) {
//						tmp.right=new Node<Integer>(arr[i]);
//						break;
//					}else
//						tmp=tmp.right;
//				}else if(arr[i]<tmp.val) {
//					if(tmp.left==null) {
//						tmp.left=new Node<Integer>(arr[i]);
//						break;
//					}else
//						tmp=tmp.left;
//				}else {
//					break;
//				}
//			}
			
		}
		return head;
	} 
	private static void BSTreeAdd(Node<Integer> head,Node<Integer> newNode) {
		while(true) {
			if(newNode.val>head.val) {
				if(head.right==null) {
					head.setRight(newNode);
					break;
				}
				head=head.right;
			}else if(newNode.val<head.val) {
				if(head.left==null) {
					head.setLeft(newNode);
					break;
				}
				head=head.left;
			}else {
				break;
			}
		}
	}
	public static Node<Integer> AVLTree(int[] values){
		if(values==null||values.length==0)
			return null;
		Node<Integer> head=new Node<Integer>(values[0]);
		for(int i=1;i<values.length;i++) {
			Node<Integer> newNode=new Node<Integer>(values[i]);
			BSTreeAdd(head, newNode);
//			Optional<Node<Integer>> unbalancedNode=newNode.parent.findUnbalancedNode(newNode);
//			head=unbalancedNode.map(Node::rotate).orElse(head);
			head=newNode.balance().orElse(head);
		}
		return head;
	}
	public static Node<Integer> AVLTree(int nodeCount){
		return AVLTree(randomArray(nodeCount));
	}
	
	public static <T>String walkLPR(Node<T> node) {
		StringBuilder path=new StringBuilder();
		if(node.left!=null) 
			path.append(walkLPR(node.left)).append(">");
		path.append(node.val);
		if(node.right!=null)
			path.append("<").append(walkLPR(node.right));
		return path.toString();
	}

}
