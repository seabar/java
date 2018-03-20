package snippet;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Snippet {
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add(  "111");
		list.add("ccc");
		list.add("dddd");
		// 只留下长度等于3的，也就是ccc，其他都过滤掉，不要
		List<String> stream = list.stream()
				.filter(action -> Optional.ofNullable(action).map(s -> s.length() ).orElseThrow(NoSuchElementException::new) == 3)
				.collect(Collectors.toList());
		// stream中只有一个ccc
		System.out.println(stream);

	}
}
