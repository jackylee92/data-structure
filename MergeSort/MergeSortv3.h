#ifndef MERGESORTV3_H
#define MERGESORTV3_H

#include <iostream>

// 自底向上的排序 
// 自底向上的排序比递归的效率要稍差
// 自底向上的排序可应用于链表
// 自底向上的归并排序也是O(nlogn)复杂度的算法
// 可以在1秒之内轻松处理100万数量级的数据
template <typename T> 
void mergeSortBu(T arr[], int n) {
    // 无优化版本
    // for (int sz = 1; sz<n; sz += sz) 
    //     for (int i = 0; i < n - sz; i += sz + sz) 
    //         __merge(arr, i, i + sz - 1, std::min(i + sz + sz -1, n-1));

    // 优化版本
    for (int i=0; i<n; i+= 16) 
        insertionSort(arr, i, std::min(i+15, n-1));
    
    for (int sz=16; sz<n; sz += sz) 
        for (int i=0; i<n-sz; i+=sz+sz)
            if (arr[i+sz-1] > arr[i+sz])
                __merge(arr, i, i+sz-1, std::min(i+sz+sz-1, n-1));
}

#endif 