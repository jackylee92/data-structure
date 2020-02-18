#ifndef MERGESORTV1_H
#define MERGESORTV1_H 

template <typename T> 
void __merge(T arr[], int l, int mid, int r) {
    T aux[r - l + 1];
    for (int i=l; i<=r; i++) 
        aux[i - l] = arr[i];
    
    int i = l, j = mid + 1;
    for (int k=l; k<=r; k++) {
        if (i > mid) {
            arr[k] = aux[j-l]; j++;
        } else if (j > r) {
            arr[k] = aux[i-l]; i++;
        } else if (aux[i-l] < aux[j-l]) {
            arr[k] = aux[i-l]; i++;
        } else { // 左边的大于右边的
            arr[k] = aux[j-l]; j++;
        }
    }
}

template<typename T> 
void __mergeSort(T arr[], int l, int r) {
    if (l >= r)
        return;
    int mid = (l+r) / 2;

    __mergeSort(arr, l, mid);
    __mergeSort(arr, mid + 1, r);
    // 优化，如果mid+1所在元素本身就比mid所在元素要大，就不需要交换了
    if (mid < mid + 1)
        __merge(arr, l, mid, r);
}
 
template<typename T>
void mergeSort(T arr[], int n) {
    __mergeSort(arr, 0,  n - 1);
}

#endif 