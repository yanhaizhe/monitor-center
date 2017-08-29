package com.beingmate.updateFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class TargetNodeParser implements NodeParser<Dimen> {
	private List<Dimen> targetList = new ArrayList<Dimen>();

	@Override
	public void parser(NodeList list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			node(node);
		}
		System.out.println(Arrays.toString(targetList.toArray()));
	}

	private void node(Node node) {
		String name = node.getNodeName();
		// System.out.println("nodeName:" + name);
		if ("dimen".equals(name)) {
			NamedNodeMap atts = node.getAttributes();
			String valName = atts.getNamedItem("name").getNodeValue();
			String val = node.getTextContent();
			Dimen dimen = new Dimen();
			dimen.name = "@dimen/" + valName;
			dimen.value = val;
			targetList.add(dimen);
		}
		if (node.hasChildNodes()) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				node(n);
			}
		}
	}

	public List<Dimen> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<Dimen> targetList) {
		this.targetList = targetList;
	}

}