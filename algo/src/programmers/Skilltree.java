package programmers;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/49993
public class Skilltree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		System.out.println(solution(skill, skill_trees));
	}

	static public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		answer = skill_trees.length;
		for (int i = 0; i < skill_trees.length; i++) {
			String target = skill_trees[i];
			int bf = target.indexOf(skill.charAt(0));
			int now = 0;
			for (int j = 1; j < skill.length(); j++) {
				now = target.indexOf(skill.charAt(j));
				if ((bf > now && now != -1) || bf == -1) {
					answer--;
					break;
				}
				bf = now;
			}
		}
		System.out.println("-------");
		return answer;
	}

}
