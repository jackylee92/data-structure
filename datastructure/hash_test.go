package datastructure

import (
	"fmt"
	"strconv"
	"testing"
)

func TestHashData(t *testing.T) {
	h := Hash()
	for i := 0; i < 100; i++ {
		key := "key"+strconv.Itoa(i)
		h.Add(key, i)
	}

	fmt.Println(h)
}