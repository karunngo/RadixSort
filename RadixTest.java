import java.util.Arrays;


public class RadixTest {
	//参考：http://www.ics.kagoshima-u.ac.jp/~fuchida/edu/algorithm/sort-algorithm/radix-sort.html

public static void main(String argv[]){
	int numberItem[]={21,25,42,78,34,217,99,11,13,114,21};
	System.out.println(Arrays.toString(numberItem));
	Bucket bucket= new Bucket();


	int Date1[]=bucket.sort(numberItem,1);
	System.out.println(Arrays.toString(Date1));

	int Date2[]=bucket.sort(Date1, 2);
	System.out.println(Arrays.toString(Date2));

	int Date3[]=bucket.sort(Date2, 3);
	System.out.println(Arrays.toString(Date3));
}
}





class Bucket{

	public int[] sort(int[] date,int x){
		//バケツ生成
		int[] newDate=new int[date.length];
		int m=10;
		int bucket[][];
		bucket = new int[m][];
		for (int i=0;i<m;i++){
			bucket[i]= new int[date.length];
		}

		//各バケツのカウンターつくる
		int counter[]=  new int[m];
		for (int c=0; c<m; c++){
			counter[c]=0;
		}
		//バケツに入れる
		for(int i=0;i<date.length;i++){
			double yy=date[i]%(Math.pow(10,x));
			int y =(int)Math.floor(yy/((int)Math.pow(10,x-1)));
			bucket[y][counter[y]]= date[i];
			counter[y]++;
		}

	//バケツの順番に中のデータを取り出して格納
		int a=0;
		for(int i=0; i<m;i++){
		int j =0;
		while(bucket[i][j]>0){
			newDate[a]=bucket[i][j];
			j++;
			a++;
		}
			}

		return newDate;

	}
}


