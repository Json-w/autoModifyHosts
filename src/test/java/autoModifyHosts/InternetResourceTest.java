package autoModifyHosts;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

import com.jsonwang.file.FileOperator;
import com.jsonwang.net.AccessInternet;
import com.jsonwang.parser.HostUrlParser;
import com.jsonwang.parser.Parser;

public class InternetResourceTest {

	@Test
	public void getResource() {
		Parser hostUrlParser = new HostUrlParser();
		AccessInternet access = new AccessInternet(hostUrlParser.parseContent());
		FileOperator operator = new FileOperator();
		operator.setTargetFile(new File("C:\\Windows\\System32\\drivers\\etc\\hosts"));
		operator.setResource(access.getIntResource());
		operator.wirte();
		access.close();
	}
}
