package com.jeev.leetcode;

public class TargetElementInInfiniteArray {

	public static void main(String[] args) {
		int[] arr = { 7, 8, 10, 11, 12, 15, 20, 23, 30 };
		int target = 15;
		System.out.println(searchElement(arr, target));
	}

	public static int searchElement(int[] arr, int target) {
		// first find the range
		// first start with a box of size 2
		int start = 0;
		int end = 1;

		// condition for the target to lie in the range
		while (target > arr[end]) {
			// this is my new start
			int temp = end + 1;
			// double the box value
			// end= previous end+sizeOfBox*2
			end = end + (end - start + 1) * 2;
			start = temp;
		}
		return binarySearch(arr, target, start, end);
	}

	public static int binarySearch(int[] arr, int target, int start, int end) {

		while (start <= end) {
			// find the mid element of the array
			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if(target > arr[mid]) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}
