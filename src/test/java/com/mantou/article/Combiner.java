package com.mantou.article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combiner {
    /**
     * 对集合中的元素进行组合，排除不想要的组合
     * 比如，颜色集合[1, 2, 3], 不理想的组合[1, 2] [2, 3]
     * 以Cn^2为例
     * 第一层循环，i = 0：
     *  第一次函数调用, copyDatas为 [1, 2, 3], copyWorkSpace为 []， k=1:
     *      1、先将颜色集合，和临时集合拷贝一份，因为后面要对集合进行操作，防止原始数据变动，保证每次循环，原始集合数据是一致的
     *      2、外层循环取第一个颜色 1（即 i = 0），添加到临时集合(copyWorkSpace)中保存起来，此时copyWorkSpace为 [1]
     *      3、因为1已经取了，把拷贝的颜色集合中1删除，即（copyDatas）为[2, 3]
     *  第二次函数调用, copyDatas为 [2, 3], copyWorkSpace为 [1]:
     *      由于copyWorkSpace的size为1，满足递归终止条件，结束
     * 第一层循环，i = 1：
     *  第一次函数调用, copyDatas为 [1, 2, 3], copyWorkSpace为 []， k=1:
     *      1、先将颜色集合，和临时集合拷贝一份，因为后面要对集合进行操作，防止原始数据变动，保证每次循环，原始集合数据是一致的
     *      2、外层循环取第一个颜色 1（即 i = 0），添加到临时集合(copyWorkSpace)中保存起来，此时copyWorkSpace为 [1]
     *      3、因为1已经取了，把拷贝的颜色集合中1删除，即（copyDatas）为[2, 3]
     *  第二次函数调用, copyDatas为 [2, 3], copyWorkSpace为 [1]:
     *      1、一样，先将颜色集合，和临时集合拷贝一份
     *      2、外层循环取第一个颜色 2，添加到临时集合(copyWorkSpace)中保存起来，此时copyWorkSpace为 [1, 2]
     *      3、因为2已经取了，把拷贝的颜色集合中2删除，即（copyDatas）为[3]
     *  第三次函数调用, copyDatas为 [3], copyWorkSpace为 [1, 2]:
     *      同理，copyWorkSpace为[1, 2, 3],
     * @param datas 0~N 数据集合，如：[1, 2, 3]
     * @param workSpace 每一次的组合，如：[1] [1, 2] [1, 2, 3]
     * @param excludeSet 需要排除的组合,如[1, 2]
     * @param k 递归结束条件
     */
    private void combinerList(List<Integer> datas, List<Integer> workSpace, List<Integer[]> excludeSet, int k) {
        if (workSpace.size() == k) {
            for (Integer[] integers : excludeSet) {
                if (workSpace.containsAll(Arrays.asList(integers))) {
                    return;
                }
            }
            printWorkSpace(workSpace);
            return;
        }
        for (int i = 0; i < datas.size(); i++) {
            List<Integer> copyDatas = new ArrayList<>(datas);
            List<Integer> copyWorkSpace = new ArrayList<>(workSpace);
            copyWorkSpace.add(copyDatas.get(i));
            for (int j = i; j >=0; j--) {
                copyDatas.remove(j);
            }
            combinerList(copyDatas, copyWorkSpace, excludeSet, k);
        }
    }

    private void printWorkSpace(List<Integer> workSpace) {
        for (Integer integer : workSpace) {
            System.out.print(integer);
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        Integer[] i1 = {1, 2};
        Integer[] i2 = {1, 3};
        List<Integer[]> excludeSet = new ArrayList<>();
        excludeSet.add(i1);
        excludeSet.add(i2);
        Combiner t = new Combiner();
        for(int i = 1; i < data.size(); i++) {
            t.combinerList(data, new ArrayList<>(), excludeSet, i);
        }
    }
}


