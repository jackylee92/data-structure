package datastructure

type queue struct {
	data linkList
	size int
}

func Queue(size int) *queue {
	return &queue{
		data: linkList{},
	}
}

func (q *queue) Push(data interface{}) {
	q.data.AddHead(data)
}

func (q *queue) Pop(data interface{}) interface{} {
	return q.data.RemoveLast().data
}

func (q *queue) Size() int {
	return q.data.size
}