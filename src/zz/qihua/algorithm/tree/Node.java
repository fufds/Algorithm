package zz.qihua.algorithm.tree;

import java.util.Optional;

public class Node<T> {
	Node<T> parent;
	Node<T> left;
	Node<T> right;
	T val;
	int balanceFactor;//left +1,right -1
	private boolean branchFlag;//left child:true,right child:false
	
	public Node(Node<T> left,Node<T> right,T value) {
		this.left=left;
		this.right=right;
		val=value;
	}

	public Node(T value) {
		this(null,null,value);
	}
	
	public void setChild(boolean left,Node<T> child) {
		if(left)
			setLeft(child);
		else
			setRight(child);
	}
	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
		if(left!=null) {
			left.parent=this;
			left.branchFlag=true;
		}
			
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
		if(right!=null) {
			right.parent=this;
			right.branchFlag=false;
		}
			
	}

	public Optional<Node<T>> balance(){
		return parent.findUnbalancedNode(this).map(Node::rotate);
	}
	public Optional<Node<T>> findUnbalancedNode(Node<T> son) {
		if(son==left)
			balanceFactor++;
		if(son==right)
			balanceFactor--;
		if(balanceFactor==2||balanceFactor==-2)
			return Optional.of(this);
		if(balanceFactor==0||parent==null)
			return Optional.empty();
		return parent.findUnbalancedNode(this);
	}
	public Node<T> rotate() {
		Node<T> newHead=null;
		if(balanceFactor==2) {
			if(left.balanceFactor==-1)
				left.leftRotation();
			newHead=rightRotation();
			updateBalanceFactor(parent.left);
		}else if(balanceFactor==-2) {
			if(right.balanceFactor==1)
				right.rightRotation();
			newHead=leftRotation();
			updateBalanceFactor(parent.right);
		}else {
			System.out.println("illegal state node!");
		}
		balanceFactor=0;
		parent.balanceFactor=0;
		return newHead;
	}
	private void updateBalanceFactor(Node<T> node) {
		node.balanceFactor=0;
		if(node.left!=null)
			node.balanceFactor++;
		if(node.right!=null)
			node.balanceFactor--;
	}

	public Node<T> leftRotation() {
		Node<T> pNode=parent;
		Node<T> newHead=right;
		Node<T> newRight=right.left;
		setRight(newRight);
		newHead.setLeft(this);
		if(pNode==null) {
			newHead.parent=null;
			return newHead;
		}else {
			pNode.setChild(this==pNode.left, newHead);
			return null;
		}
		
			
	}
	public Node<T> rightRotation() {
		Node<T> pNode=parent;
		Node<T> newHead=left;
		Node<T> newLeft=left.right;
		setLeft(newLeft);
		newHead.setRight(this);;
		if(pNode==null) {
			newHead.parent=null;
			return newHead;
		}else {
			pNode.setChild(this==pNode.left, newHead);
			return null;
		}
			
	}
	
	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val+"";
	}
}
