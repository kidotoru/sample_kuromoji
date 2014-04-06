package net.treewoods.sample_kuromoji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

/**
 *
 * @author toru
 */
public class SampleKuromoji {

	public static void main(String[] args) throws IOException {

		InputStream is = ClassLoader.getSystemResourceAsStream("mazda6.txt");
		
		
		InputStreamReader reader = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(reader);
		
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null )
		{
			sb.append(line);
		}
		
		
		Tokenizer tokenizer = Tokenizer.builder().build();
		
		Map<String,Integer> map = new HashMap<>();
		for (Token token : tokenizer.tokenize(sb.toString())) {
//		for (Token token : tokenizer.tokenize("寿司が食べたい。")) {
			
			if(map.containsKey(token.getSurfaceForm())){
				int i = map.get(token.getSurfaceForm());
				map.put(token.getSurfaceForm(), ++i);
			} else {
				map.put(token.getSurfaceForm(), 1);
				
			}
			
			System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
		}
		
		Set<Entry<String,Integer>>  set = map.entrySet();
		
		for ( Entry<String,Integer>  entry : set){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}

	}

}
