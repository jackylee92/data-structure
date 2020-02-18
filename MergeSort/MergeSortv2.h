#ifndef MERGESORTV2_H 
#define MERGESORTV2_H

template <typename T> 
void __mergeSortV2(T arr[], int l, int r) {
    if (r - l < 15) {
        insertSort(arr, l, r);
        return;
    }

    int mid = (l + r) / 2;
    __mergeSortV2(arr, l, mid);
    __mergeSortV2(arr, mid + 1, r);

    if (arr[mid] > arr[mid+1])
        __merge(arr, l, mid, r);
    return;
}

template <typename T> 
void mergeSortV2(T arr[], int n) {
    // 前闭后闭
    __mergeSortV2(arr, 0, n-1);
}

#endif 