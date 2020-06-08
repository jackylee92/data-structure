package utils


func CompareTo(s interface{}, d interface{}) int {
	switch s.(type) {
	default:
		return 0
	case int:
		return s.(int) - d.(int)
	}
	return 0
}