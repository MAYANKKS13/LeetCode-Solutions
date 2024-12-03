package org.example.arrayandStrings;

import java.util.Arrays;

public class DividePlayersIntoTeamsofEqualSkill {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,5,1,3,4};
        int arr1[] = new int[]{3,4};
        int arr2[] = new int[]{1,1,2,3};
        System.out.println(dividePlayers(arr));
        System.out.println(dividePlayers(arr1));
        System.out.println(dividePlayers(arr2));

    }

    public static long dividePlayers(int[] skill) {
        long answer = 0;
        Arrays.sort(skill);
        int i = 0, j = skill.length - 1;
        while (i < j) {
            if(skill[i] + skill[j] != skill[0] + skill[skill.length - 1]) {
                return -1;
            }
            answer = answer + (long) (skill[i] * skill[j]);
            i++;
            j--;
        }
        return answer;
    }

}
