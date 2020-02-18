#include <iostream>
#include "TestHelper.h"
#include "MergeSortv1.h"
#include "MergeSortv2.h"
#include "InsertionSort.h"

using namespace std;

int main() {
    int n = 100000;

    cout<<"一般测试"<<endl;
    int *arr = TestHelper::generateRandArray(n , 0, n);
    int *arr2 = TestHelper::copyIntArray(arr, n);

    TestHelper::testSort("Insertion Sort", insertionSort, arr, n);
    TestHelper::testSort("Merger Sort", mergeSort, arr2, n);

    if (!TestHelper::isSort(arr, n)) {
        cout<<"arr1 is not sort"<<endl;
    }
    if (!TestHelper::isSort(arr2, n)) {
        cout<<"arr2 is not sort"<<endl;
    }
    
    delete[] arr;
    delete[] arr2;


    // 接近有序
    cout<<"接近有序"<<endl;
    arr = TestHelper::generateNearlyOrderedArray(n, 0);
    arr2 = TestHelper::copyIntArray(arr, n);

    TestHelper::testSort("Insertion Sort", insertionSort, arr, n);
    TestHelper::testSort("Merger Sort", mergeSort, arr2, n);

    if (!TestHelper::isSort(arr, n)) {
        cout<<"arr1 is not sort"<<endl;
    }
    if (!TestHelper::isSort(arr2, n)) {
        cout<<"arr2 is not sort"<<endl;
    }

    // TestHelper::printArray(arr, n);

    
    return 0;
}