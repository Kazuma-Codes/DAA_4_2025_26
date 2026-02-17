def lower_bound(arr, target):
    left, right = 0, len(arr) - 1
    ans = len(arr)   

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] >= target:
            ans = mid      
            right = mid - 1   
        else:
            left = mid + 1

    return ans

def upper_bound(arr, target):
    left, right = 0, len(arr) - 1
    ans = len(arr)

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] > target:
            ans = mid         
            right = mid - 1
        else:
            left = mid + 1

    return ans
arr = [1, 2, 2, 2, 3, 4, 5]

print("lower",lower_bound(arr, 2))  
print("upper",upper_bound(arr, 2))  
