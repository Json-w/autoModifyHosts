package com.jsonwang.parser;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HostUrlParser extends Parser {

	private String url = "http://laod.cn/hosts/2015-google-hosts.html";
	private String containString = "http://laod.cn/wp-content/uploads/2015/06";

	public HostUrlParser(String url, String containString) {
		this.url = url;
		this.containString = containString;
	}

	public HostUrlParser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String parseContent() {
		// TODO Auto-generated method stub
		List<String> result = null;
		result = getLinkList(url, containString);
		return result.get(0);
	}

	/**
	 * @param url
	 *            "http://laod.cn/hosts/2015-google-hosts.html"
	 * @param containString
	 *            "http://laod.cn/wp-content/uploads/2015/06/"
	 * @return
	 */
	private List<String> getLinkList(String content, String containString) {
		List<String> result = new ArrayList<String>();
		try {
			org.htmlparser.Parser parser = new org.htmlparser.Parser(content);
			NodeFilter aNodeFilter = new NodeClassFilter(LinkTag.class);
			NodeList nodeList = parser.extractAllNodesThatMatch(aNodeFilter);
			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				LinkTag linkTag = (LinkTag) node;
				String link = linkTag.getLink();
				if (link.contains(containString)) {
					// System.out.println(link);
					result.add(link);
				}
			}

		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
