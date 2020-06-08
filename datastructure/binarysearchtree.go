package datastructure

import (
	"fmt"

	"data-structure/datastructure/utils"
)

type binarySearchTreeNode struct {
	data interface{}
	left *binarySearchTreeNode
	right *binarySearchTreeNode
}

type binarySearchTree struct {
	root *binarySearchTreeNode
	size int
}

func BinarySearchTree() *binarySearchTree {
	return &binarySearchTree{root:nil, size:0}
}

func (b *binarySearchTree) Add(data interface{}) {
	b.root = b.add(b.root, data)
}

func (b *binarySearchTree) add(node *binarySearchTreeNode, e interface{}) *binarySearchTreeNode {
	if (node == nil) {
		b.size++
		return &binarySearchTreeNode{data:e,left: nil,right: nil}
	}
	if (utils.CompareTo(e, node.data)) < 0 {
		node.left = b.add(node.left, e)
	}
	if (utils.CompareTo(e, node.data)) > 0 {
		node.right = b.add(node.right, e)
	}
	return node
}

func (b *binarySearchTree) PreOrder() {
	b.preOrder(b.root)
}

func (b *binarySearchTree) preOrder(node *binarySearchTreeNode) {
	if node == nil {
		return
	}
	fmt.Println(node.data)
	b.preOrder(node.left)
	b.preOrder(node.right)
}