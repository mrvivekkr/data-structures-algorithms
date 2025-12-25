# Longest Non-decreasing Subarray From Two Arrays

## Problem
Given `nums1` and `nums2` of length `n`, choose `nums3[i]` as either `nums1[i]` or `nums2[i]` to maximize the longest non-decreasing subarray length in `nums3`.

**Constraints**: `1 ≤ n ≤ 10^5`, `1 ≤ nums[i] ≤ 10^9`

---

## Examples
**Input**: `nums1 = [1,4,2,3]`, `nums2 = [2,1,3,4]`  
**Output**: `4` (`[1,1,2,3]`)

**Input**: `nums1 = [1,3,2,1]`, `nums2 = [2,2,2,2]`  
**Output**: `4` (`[2,2,2,2]`)

---

## Approach
**DP States**:
- `dp1[i]`: max length ending at `i` using `nums1[i]`
- `dp2[i]`: max length ending at `i` using `nums2[i]`

**4 Transitions**:
dp1[i] = 1 + max(dp1[i-1] if nums1[i]≥nums1[i-1], dp2[i-1] if nums1[i]≥nums2[i-1])
dp2[i] = 1 + max(dp1[i-1] if nums2[i]≥nums1[i-1], dp2[i-1] if nums2[i]≥nums2[i-1])


---

## Complexity
| Time | Space    |
|------|----------|
| **O(n)** | **O(n)** |

---

### 📌 Tags: `Dynamic Programming`, `Array`
