package Sums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum
{


    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums.length < 3)
        {
            return answer;
        }

        HashMap<Integer, Integer> aMap = convertToHashMap(nums);

        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                int theSum = (nums[i] + nums[j]) * -1; //Gets the number you need to make zero

                Integer hasValue = aMap.get(theSum);

                if (hasValue != null)
                {
                    boolean canAdd = true;
                    if ((theSum == nums[i] && hasValue < 2) || (theSum == nums[j] && hasValue < 2))
                    {
                        canAdd = false;
                    }

                    if (canAdd)
                    {
                        ArrayList<Integer> aList = new ArrayList<>();

                        aList.add(nums[i]);
                        aList.add(nums[j]);
                        aList.add(theSum);

                        if (!hasDuplicates(answer, aList))
                        {
                            answer.add(aList);
                        }
                    }
                }
            }
        }
        return answer;
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
            answer = aList.containsAll(lister);
            if (answer)
            {
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

        int[] zeroTest = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

        List<List<Integer>> masterList = new ArrayList<>();

        List<Integer> oneList = new ArrayList<>();
        List<Integer> allZeroes = new ArrayList<>();

        allZeroes.add(0);
        allZeroes.add(0);
        allZeroes.add(0);

        oneList.add(0);
        oneList.add(1);
        oneList.add(4);

        masterList.add(oneList);

        boolean hasDuplicates = rawr.hasDuplicates(masterList, allZeroes);


        rawr.convertToHashMap(zeroTest);

        List<List<Integer>> rawrs =  rawr.threeSum(zeroTest);
    }
}