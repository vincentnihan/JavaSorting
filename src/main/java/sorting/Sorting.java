package sorting;

import java.util.HashMap;

public class Sorting {
	public static void main(String args[]) 
    { 
        int arr[] = {64,25,12,22,11,33}; 
        Sorting ob = new Sorting(arr); 
        //ob.selectionSort();
        //ob.quickSort();
        //ob.insertionSort();
        //ob.countingSort(100);
        ob.merge();
    } 
	
	private int[] input;
	Sorting(int [] input)
	{
		this.input = input;
	}
	
	private void swap(int arr[], int start, int finish)
	{
		int temp = arr[start];
		arr[start] = arr[finish];
		arr[finish] = temp;
	}
	
	public void selectionSort()
	{
		int sample[] = input;
		int min_index = 0;
		for(int i = 0; i < sample.length; i++)
		{
			min_index = i;
			for(int j = min_index; j < sample.length; j++)
			{
				min_index = sample[min_index] > sample[j] ? j : min_index;
			}
			swap(sample, i, min_index);
		}
		printInput("Selection sort", sample);
	}
	
	private void printInput(String header, int[] result)
	{
		System.out.print(header + " result: ");
		for(int i = 0; i < result.length; i++)
		{
			System.out.print(result[i] + " ");
		}
	}
	
	public void quickSort() 
	{
		int sample[] = input;
		quickSort(sample,(sample.length - 1),0);
		printInput("Quick sort", sample);
		
	}
	
	private void quickSort(int arr[], int high, int low)
	{
		if(low < high)
		{
			int pi = partition(arr,high,low);
			
			quickSort(arr,pi-1,low);
			quickSort(arr,high,pi+1);
		}
	}
	private int partition(int arr[], int high, int low)
	{
        
		int pivot = arr[high];
		int i = (low - 1);
		for(int j = low; j < high; j++)
		{
			if(arr[j] <= pivot)
			{
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,(i + 1),high);
		return i + 1;
	}
	
	public void insertionSort()
	{
		int sample[] = input;
		
		for(int i = 1; i<sample.length; i++)
		{
			int key = sample[i];
			int j = i - 1;
			while(j >= 0 && sample[j] > key)
			{
				sample[j+1] = sample[j];
				j--;
			}
			sample[j+1] = key;
		}
		
		printInput("Insertion Sort",sample);
	}
	
	public void countingSort(int max)
	{
		int sample[] = input;
		int count[] = new int[max];
		int ans[] = new int[sample.length];
		for(int i = 0; i< sample.length; i++)
		{
			count[sample[i]] += 1;
		}
		for(int i = 1 ; i < max; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		for(int i = sample.length - 1; i >= 0;i--)
		{
			ans[count[sample[i]] - 1] = sample[i];
			count[sample[i]] -= 1;
		}
		
		printInput("Counting Sort",ans);
	}
	
	public void merge()
	{
		int sample[] = input;
		int ans[] = new int[sample.length];
		merge(sample,ans,0,sample.length - 1);
		printInput("Merge Sort", sample);
	}
	
	private void merge(int arr[], int result[],int start, int end)
	{
		if(start >= end)
		{
			return;
		}
		int mid = (start+end)/2;
		int lowStart = start;
		int lowEnd = mid;
		int highStart = mid+1;
		int highEnd = end;
		merge(arr,result,lowStart,lowEnd);
		merge(arr,result,highStart,highEnd);
		int k = start;
		while(lowStart <= lowEnd && highStart <= highEnd)
		{
			result[k++] = arr[lowStart] < arr[highStart] ? arr[lowStart++] : arr[highStart++];
		}
		while(lowStart <= lowEnd)
		{
			result[k++] = arr[lowStart++];
		}
		while(highStart <= highEnd)
		{
			result[k++] = arr[highStart++];
		}
		for(k = start; k <= end; k++)
		{
			arr[k] = result[k];
		}
		
	}
}
