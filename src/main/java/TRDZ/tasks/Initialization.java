package TRDZ.tasks;

import java.util.Arrays;

public class Initialization {

	public static void main(String[] args) {

		int[] arr = new int[15];
		int miss = 1+(int)(Math.random()*(arr.length-2));
		System.out.println("Недостающий элемент - "+miss);
		generate(arr,miss);
		System.out.println(Arrays.toString(arr));
	//region Поиск пропущеного элемента массива с помощью экспоненциального поиска
		long startTime = System.currentTimeMillis();
		System.out.println("=> "+Exponential_Search(arr));
		long endTime = System.currentTimeMillis();
		System.out.println("Время экспоненциального поиска: "+(endTime-startTime));
	//endregion
	//region Проведение поиска пропущеного элемента массива с помощью линейного поиска для сравнения
		startTime = System.currentTimeMillis();
		System.out.println("=> "+Basic_Search(arr));
		endTime = System.currentTimeMillis();
		System.out.println("Время базового поиска: "+(endTime-startTime));
	//endregion
		}

	/** Создание массива из чисел равных предыдущее+1
	 * но с одним пропущенным эелемнтом
	 * @param arr массив для заполнения
	 * @param num Пропущенный
	 */
	public static void generate(int[] arr, int num) {
		for (int i=0; i<arr.length; i++) {
			if ((i+1)<num) arr[i]=i+1;
			else arr[i]=i+2;
			}
		}

	/**
	 * Определнеи диапазона расположения пропущеного элемента и его отправка на обработку
	 * @param arr заданны массив
	 * @return значение пропущеного элемента
	 */
	public static int Exponential_Search(int[] arr) {
		if ((arr.length==0)||(arr[0]!=1)) return 1;
		if (arr[arr.length - 1]==arr.length) return 0;
		int	pointer = 1;
		while ((pointer < arr.length) && (arr[pointer] <= (pointer+1))) pointer *= 2;
		return Binary_Search(arr, pointer / 2, Math.min(pointer, arr.length - 1));
		}

	/**
	 * Поиск пропущенного элемента массива
	 * @param arr заданны массив
	 * @param start начало диапазона поиска
	 * @param end конец диапазона поиска
	 * @return значение пропущеного элемента
	 */
	public  static int Binary_Search(int[] arr, int start, int end) {
		int	pointer;
		while ((start<end)&&(end-start)!=1)	{
			pointer = (start + end) / 2;
			if (arr[pointer] < pointer+2) start = pointer;
			else end = pointer;
			}
		return (arr[start]+1);
		}

	/**
	 * Поиск пропущенного элемента массива
	 * @param arr заданны массив
	 * @return значение пропущеного элемента
	 */
	public static int Basic_Search(int[] arr) {
		if ((arr.length==0)||(arr[0]!=1)) return 1;
		for (int i=0; i<arr.length-2; i++) {
			if (arr[i]+1!=arr[i+1]) return arr[i]+1;
			}
		return 0;
		}

	}
