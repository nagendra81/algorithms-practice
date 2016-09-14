package topcoder.recursion;

import java.util.Arrays;
import java.util.Comparator;

public class HealthFood {

	public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
		int[] selected = new int[dietPlans.length];

		Meal[] meals = new Meal[protein.length];

		for (int i = 0; i < protein.length; i++) {
			meals[i] = new Meal(i, protein[i], carbs[i], fat[i]);
		}

		for (int i = 0; i < dietPlans.length; i++) {
			MealComparator cmp = new MealComparator(dietPlans[i]);
			Arrays.sort(meals, cmp);
			selected[i] = meals[0].index;
		}

		return selected;

	}

	static class MealComparator implements Comparator<Meal> {

		private String dietPlan;

		MealComparator(String dietPlan) {
			this.dietPlan = dietPlan;
		}

		@Override
		public int compare(Meal meal1, Meal that) {
			return meal1.compareTo(that, dietPlan);
		}

	}

	static class Meal {
		int protein;
		int carbs;
		int fat;
		int index;
		int calories;

		Meal(int index, int protein, int carbs, int fat) {
			this.index = index;
			this.protein = protein;
			this.carbs = carbs;
			this.fat = fat;

			this.calories = this.protein * 5 + this.carbs * 5 + this.fat * 9;

		}

		public int compareTo(Meal that, String dietPlan) {

			for (char d : dietPlan.toCharArray()) {
				if (d == 'p' && this.protein != that.protein) {
					return Integer.compare(this.protein, that.protein);
				} else if (d == 'P' && this.protein != that.protein) {
					return Integer.compare(that.protein, this.protein);
				} else if (d == 'c' && this.carbs != that.carbs) {
					return Integer.compare(this.carbs, that.carbs);
				} else if (d == 'C' && this.carbs != that.carbs) {
					return Integer.compare(that.carbs, this.carbs);
				} else if (d == 'f' && this.fat != that.fat) {
					return Integer.compare(this.fat, that.fat);
				} else if (d == 'F' && this.fat != that.fat) {
					return Integer.compare(that.fat, this.fat);
				} else if (d == 't' && this.calories != that.calories) {
					return Integer.compare(this.calories, that.calories);
				} else if (d == 'T' && this.calories != that.calories) {
					return Integer.compare(that.calories, this.calories);
				}
			}

			return Integer.compare(this.index, that.index);
		}
	}

	public static void main(String[] args) {
		HealthFood hf = new HealthFood();
		int[] proteins = { 18, 86, 76, 0, 34, 30, 95, 12, 21 };
		int[] carbs = { 26, 56, 3, 45, 88, 0, 10, 27, 53 };
		int[] fat = { 93, 96, 13, 95, 98, 18, 59, 49, 86 };
		String[] dietPlans = { "f", "Pt", "PT", "fT", "Cp", "C", "t", "", "cCp", "ttp", "PCFt", "P", "pCt", "cP",
				"Pc" };

		int[] res = hf.selectMeals(proteins, carbs, fat, dietPlans);
		System.out.println(Arrays.toString(res));
	}

}
