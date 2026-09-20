package homework.week2.AlgorithmAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bai14 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        res.add(tmp);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
/*
1. Y tuong thuat toan:
- Buoc 1: Sap xep mang theo thu tu tang dan. Viec sap xep mat thoi gian O(N log N).
- Buoc 2: Dung 2 vong lap ben ngoai de chon 2 so dau tien:
    + Chi so i chay tu 0 den N - 4.
    + Chi so j chay tu i + 1 den N - 3.
- Buoc 3: Voi moi cap (i, j), su dung 2 con tro cho phan con lai cua mang:
    + left = j + 1
    + right = N - 1
    + Tinh tong: sum = (long) a[i] + a[j] + a[left] + a[right]
      ( ep kieu long de tranh tran so nguyen).
    + Neu sum == target: Tim thay bo bon hop le, tang bien dem, dong thoi tang left va giam right.
    + Neu sum < target: Tong dang nho hon target, can so lon hon nen tang left (left++).
    + Neu sum > target: Tong dang lon hon target, can so nho hon nen giam right (right--).

2. Do phuc tap:
- Thoi gian (Time Complexity): O(N^3)
  + Vong lap i: O(N) buoc.
  + Vong lap j: O(N) buoc.
  + Do cap con tro (left, right): O(N) buoc.
  Tong thoi gian: O(N * N * N) = O(N^3)
 */

