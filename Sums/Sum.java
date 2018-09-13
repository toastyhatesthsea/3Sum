package Sums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sum
{


    public List<List<Integer>> threeSum(int[] nums)
    {
        if (nums.length < 3)
        {
            return null;
        }

        HashMap<Integer, Integer> aMap = convertToHashMap(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 1; i < nums.length; i++)
        {
            int theSum = (nums[0] + nums[i]) * -1; //Gets the number you need to make zero

            Integer hasValue = aMap.get(theSum);

            if (hasValue != null)
            {
                ArrayList<Integer> aList = new ArrayList<>();

                aList.add(nums[0]);
                aList.add(nums[i]);
                aList.add(theSum);

                if (!hasDuplicates(answer, aList))
                {
                    answer.add(aList);
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
            answer = aList.containsAll(aList);
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

        List<List<Integer>> rawrs =  rawr.threeSum(meow);
    }
}