///冒泡排序
///思路：比较相邻的元素。如果第一个比第二个大，就交换它们两个；
///这样，每一次比较都会将最大的元素“沉底”。 
 
fn bubble_sort(arr: &mut [i32]) {
  let n=arr.len();
  //外层循环控制比较的轮数
  for i in 0..n{
    let mut swapped = false;
    //内层循环控制每一轮比较的次数，由于每次比较之后数组的末尾都会形成一个有序的部分，所以每一轮比较的次数都会减少
    for j in 0..n-i-1{
        if arr[j]>arr[j+1]{
            // 交换 arr[j+1] 和 arr[j]
            arr.swap(j,j+1);
            swapped = true;
        }
    }
    if !swapped{
      break;
    }
  }
}

#[test]
fn test_bubble_sort() {
    //因为要修改数组，所以此处必须使用mut生命为可变数组
    let mut arr = [34, 90, 64, 12, 22, 25, 11];
    bubble_sort(&mut arr);
    assert_eq!(arr, [11, 12, 22, 25, 34, 64, 90]);
}