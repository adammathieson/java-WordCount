package wordCount;

import java.util.*; // { Component, HashMap, Iterator, Map, Set }

public class Main
{
	public static void main(String[] args)
	{
		String text = new Declaration().getDeclaration();

		text.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");

		String[] words = text.split(" +");
		HashMap<String, Integer> textMap = new HashMap<>();

		for (String word : words)
		{
			if(!textMap.containsKey(word))
			{
				textMap.put(word, 1);
			}
			else 
			{
				textMap.put(word, textMap.get(word) + 1);
			}
		}
		// for (String i : textMap.keySet())
		// {
		// 	System.out.println("Key: " + i + " value: " + textMap.get(i));
  //       }
		ArrayList<HashMap.Entry<String, Integer>> sortList = new ArrayList<>();
		sortList.addAll(textMap.entrySet());

		Collections.sort(sortList, new Comparator<HashMap.Entry<String, Integer>>()
		{
			public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2)
			{
				return o2.getValue() - o1.getValue();
			}
		});
		for (int i = 0; i < 50 ; i++)
		{
		System.out.println("Common Word < " + sortList.get(i).getKey() + " > occurs " + sortList.get(i).getValue() + " times");
		}
	}
}