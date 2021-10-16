package ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSample {

	public static void main(String[] args) throws IOException {
		DataDriven d = new DataDriven();
		List<String> a = d.getData("Login");
		System.out.println(a);
		
	}

}
