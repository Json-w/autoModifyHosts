package com.jsonwang.start;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.jsonwang.file.FileOperator;
import com.jsonwang.net.AccessInternet;
import com.jsonwang.parser.HostUrlParser;
import com.jsonwang.parser.Parser;

public class Start {
	public static void main(String[] args) {
		Parser hostUrlParser = new HostUrlParser();
		AccessInternet access = new AccessInternet(hostUrlParser.parseContent());
		FileOperator operator = new FileOperator();
		operator.setTargetFile(new File(
				"C:\\Windows\\System32\\drivers\\etc\\hosts"));
		operator.setResource(access.getIntResource());
		operator.wirte();
		System.out.println(new Date() + "host file modify success!");
		access.close();
	}
}
