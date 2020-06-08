package datastructure

import (
	"testing"

	"data-structure/sort/tool"
)

func TestBinarySearchTreeAdd(t *testing.T) {
	tmpArr := tool.GenarageDisorderInt64(10)
	bt := BinarySearchTree()
	for _, v := range tmpArr {
		bt.Add(v)
	}

	bt.PreOrder()
}

