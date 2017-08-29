package com.beingmate.updateFile;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QueryStringAttParser implements NodeParser<StringNode> {
	private List<StringNode> targetList;

	@Override
	public void parser(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			node(node);
		}
		printList(targetList);
	}
	
	private void printList(List<StringNode> targetList){
		for(StringNode n:targetList){
			System.out.println(n);
		}
	}

	private void node(Node node) {
		String name = node.getNodeName();
		// 节点的名字为string
		if ("string".equals(name)) {
			NamedNodeMap atts = node.getAttributes();
			String valName = atts.getNamedItem("name").getNodeValue();
			StringNode sn = new StringNode();
			sn.attrName = "@string/" + valName;
			getTargetList().add(sn);
		}
		if (node.hasChildNodes()) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				node(n);
			}
		}
	}

	@Override
	public void setTargetList(List<StringNode> targetList) {
		// TODO Auto-generated method stub
		this.targetList = targetList;
	}

	@Override
	public List<StringNode> getTargetList() {
		if (targetList == null)
			targetList = new ArrayList<StringNode>();
		// TODO Auto-generated method stub
		return targetList;
	}

}
