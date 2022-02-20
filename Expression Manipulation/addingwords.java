import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class addingwords {

	static HashMap<String, Integer> vals=new HashMap<>();
	static HashMap<Integer, String> definitions=new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] split;
		int calc;
		boolean known=true;

		while((line=br.readLine())!=null) {
			split=line.split(" ");
			switch(split[0]) {
			case "clear": {
				vals=new HashMap<>();
				definitions=new HashMap<>();
				break;
			}
			case "def": {
				if(vals.containsKey(split[1])) {
					definitions.remove(vals.get(split[1]));
					vals.remove(split[1]);
					vals.put(split[1], Integer.parseInt(split[2]));
					definitions.put(Integer.parseInt(split[2]), split[1]);
				} else {
					vals.put(split[1], Integer.parseInt(split[2]));
					definitions.put(Integer.parseInt(split[2]),split[1]);
				}
				break;
			}
			default: {
				System.out.print(line.substring(5)+" ");
				for(String s : Arrays.copyOfRange(split, 1, split.length-1)) {
					if(!s.equals("+")&&!s.equals("-")) {
						if(!vals.containsKey(s)) {
//							System.out.print("S{"+s+"} ");
							known=false;
							break;
						}
					}
				}
			}
//			System.out.println(vals.toString()+"KNOWN{"+(known)+"}");
			if(known) {
				calc=expression(split);
				System.out.println((definitions.containsKey(calc)) ? definitions.get(calc) : "unknown");
			} else {
				System.out.println("unknown");
			}
			break;
			}
			known=true;
		}

		br.close();
	}

	public static int expression(String[] expression) {
		if(expression.length==0) return 0;
		int sum=vals.get(expression[1]);
		for(int i=1;i<expression.length;i++){
			switch(expression[i]) {
			case "+": {
				sum+=vals.get(expression[i+1]);
				break;
			}
			case "-": {
				sum-=vals.get(expression[i+1]);
				break;
			}
			default: {
				break;
			}
			}
		}
		return sum;
	}
}
