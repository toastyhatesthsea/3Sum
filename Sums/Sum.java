package Sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sum
{

    /** Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * The solution set must not contain duplicate triplets.
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param num int[]
     * @return List
     */
    public List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.parallelSort(num);

        for (int i = 0; i + 1 < num.length; i++)
        {
            for (int j = num.length - 1; j > i; j--)
            {
                int theSum = (num[i] + num[j]) * -1;
                ArrayList<Integer> aList = new ArrayList<>();

                if (num[i] == 0 && i + 2 < num.length && num[i + 1] == 0 && num[i+2] == 0)
                {

                    aList.add(0);
                    aList.add(0);
                    aList.add(0);
                    answer.add(aList);
                    break;
                }
                else if (theSum >= 1 && theSum > num[j])
                {
                    break;
                }

                if (theSum >= 1 && theSum <= num[j - 1])
                {
                    int index = Arrays.binarySearch(num, i + 1, j, theSum);

                    if (index > 0 && index > i)
                    {
                        aList.add(num[i]);
                        aList.add(num[j]);
                        aList.add(num[index]);
                    }
                } else if (theSum < 1 && theSum >= num[i + 1])
                {
                    int index = Arrays.binarySearch(num, i + 1, j, theSum);

                    if (index > 0 && index > i)
                    {
                        aList.add(num[i]);
                        aList.add(num[j]);
                        aList.add(num[index]);
                    }
                }
                int k = j;

                while (k - 1 > i && num[j] == num[k - 1])
                {
                    if (num[j] == num[k])
                    {
                        k--;
                    }
                }
                j = k;
                if (aList.size() == 3)
                {
                    answer.add(aList);
                }
            }

            int h = i;
            //Skip duplicates
            while (h + 1 < num.length && num[i] == num[h + 1])
            {
                if (num[i] == num[h])
                {
                    h++;
                }
            }

            i = h;
        }
        return answer;
    }

    /**
     * Returns which third in the array the number is located in the sorted array
     * @param num Sorted Array
     * @param number int Number to find
     * @return int
     */
    public int whichThird(int[] num, int number)
    {
        int aThird = num.length / 3;

        int greatestValue = num[num.length - 1];
        int lowestValue = num[0];

        int firstThirdLowest = 0;
        int firstThirdHighest = aThird - 1;

        int secondThirdLowest = aThird;
        int secondThirdHighest = aThird + aThird - 1;

        int thirdLowest = aThird + aThird;
        int thirdHighest;

        if (num.length % 3 == 0) // even
        {
            thirdHighest = aThird + aThird + aThird - 1;
        }
        else //not even
        {
            thirdHighest = aThird + aThird + aThird;
        }

        if (number >= num[firstThirdLowest] && number <= num[firstThirdHighest])
        {
            return 1;
        } else if (number >= num[secondThirdLowest] && number <= num[secondThirdHighest])
        {
            return 2;
        } else if (number >= num[thirdLowest] && number <= num[thirdHighest])
        {
            return 3;
        }
        else
        {
            return 0;
        }
    }

    public HashMap<Integer, Integer> convertToHashMap(int[] nums)
    {
        HashMap<Integer, Integer> answer = new HashMap<>();
        for (Integer aNum : nums)
        {
            int total = answer.getOrDefault(aNum, 0);
            answer.put(aNum, total + 1);
        }
        return answer;
    }

    /**
     * Checks to see if the answer list has any duplicates
     * @param masterList
     * @param aList
     * @return
     */
    public boolean hasDuplicates(List<List<Integer>> masterList, List<Integer> aList)
    {
        boolean answer = false;
        for (List lister : masterList)
        {
            int totalEqualedValues = 0;
            ArrayList<Integer> valuesRemoved = new ArrayList<>();
            for (int i = 0; i < aList.size() && totalEqualedValues < 3; i++)
            {
                boolean hasValue = lister.contains(aList.get(i));
                if (hasValue)
                {
                    totalEqualedValues++;
                    lister.remove(aList.get(i));
                    valuesRemoved.add(aList.get(i));
                }
            }
            lister.addAll(valuesRemoved);
            if (totalEqualedValues == 3)
            {
                answer = true;
                break;
            }
        }
        return answer;
    }
}

class SumTest
{


    public static void main(String[] argsgssg)
    {
        Sum rawr = new Sum();

        int[] meow = {-1, 0, 1, 2, -1, -4};
        int[] testCase1 = {1, 2, -2, -1};
        int[] testCase2 = {3, 0, -2, -1, 1, 2};
        int[] testCase3 = {0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0};
        int[] largeCase = {10, -2, -12, 3, -15, -12, 2, -11, 3, -12, 9, 12, 0, -5, -4, -2, -7, -15, 7, 4, -5, -14, -15, -15, -4, 10, 9, -6, 7, 1, 12, -6, 14, -15, 12, 14, 10, 0, 10, -10, 3, 4, -12, 10, 7, -9, -7, -15, -8, -15, -4, 2, 9, -4, 3, -10, 13, -3, -1, 5, 5, -4, -15, 4, -11, 4, -4, 6, -11, -9, 12, 7, 11, 7, 2, -5, 13, 10, -5, -10, 3, 7, 0, -3, 10, -12, 2, 9, -8, 8, -9, 13, 12, 13, -6, 8, 3, 5, -9, 7, 12, 10, -8, 0, 2, 1, 10, -7, -3, -10, -10, 7, 4, 5, -11, -8, 0, -2, -14, 8, 13, -8, -2, 10, 13};

        int[] zeroTest = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] fourZeroes = {0, 0, 0, 0};

        List<List<Integer>> masterList = new ArrayList<>();

        List<Integer> oneList = new ArrayList<>();
        List<Integer> testerList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        List<Integer> allZeroes = new ArrayList<>();

        allZeroes.add(0);
        allZeroes.add(0);
        allZeroes.add(0);

        testerList.add(-1);
        testerList.add(0);
        testerList.add(1);

        oneList.add(0);
        oneList.add(1);
        oneList.add(4);

        secondList.add(0);
        secondList.add(3);
        secondList.add(-3);



        masterList.add(oneList);
        masterList.add(secondList);

        boolean answer = testerList.contains(0);

        boolean hasDuplicates = rawr.hasDuplicates(masterList, testerList);


        rawr.convertToHashMap(zeroTest);

        //List<List<Integer>> rawrs =  rawr.threeSum(zeroTest);

        Arrays.parallelSort(zeroTest);

        int index = Arrays.binarySearch(zeroTest, 0, zeroTest.length, 2);

        rawr.threeSum(testCase2);
    }
}