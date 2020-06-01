package datastructure

type stack struct {
	data *linkList
	peekData interface{}
}

func Stack() *stack {
	return &stack{
		data: &linkList{},
	}
}

func (s *stack) Push(data interface{}) {
	s.data.AddHead(data)
	s.peekData = data
}

func (s *stack) Pop(data interface{}) interface{} {
	return s.data.RemoveFirst().data
}

func (s *stack) Peek() interface{} {
	return s.data.headNode.next.data
}

func (s *stack) Size() int {
	return s.data.size
}