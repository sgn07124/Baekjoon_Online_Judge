import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++)
		{
			int index = sc.nextInt();
			StringBuilder b = new StringBuilder(sc.next());
			b.deleteCharAt(index-1);
			System.out.println(b);
		}
		sc.close();
	}
}