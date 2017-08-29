package com.beingmate.updateFile;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class StringAttIncludeParser implements NodeParser<StringNode> {
	private String[] propertys = { "android:layout_width", "android:layout_height", "android:paddingTop",
			"android:layout_marginRight", "android:layout_marginBottom", "android:layout_marginLeft",
			"android:layout_marginTop", "android:paddingBottom", "android:paddingLeft", "android:paddingRight",
			"android:textSize", "android:horizontalSpacing", "android:verticalSpacing", "android:drawablePadding",
			"android:minHeight", "android:layout_margin", "android:padding", "android:padding", "android:radius" };
	
	private List<StringNode> targetList;

	@Override
	public void parser(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			node(node);
		}
	}

	private void node(Node node) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println("resetAttributeValue:" + node.getNodeName());
			queryAttributeValue((Element) node);
		}
		if (node.hasChildNodes()) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				node(n);
			}
		}
	}

	private void queryAttributeValue(Element e) {
		for (String pro : propertys) {
			Attr att = e.getAttributeNode(pro);
			if (att != null) {
				System.out.println("attr:" + "name:" + att.getName() + " value:" + att.getValue());
				String val = att.getValue();
				for (StringNode dimen : targetList) {
					if (val.equals(dimen.attrName)) {
						dimen.hitCount++;
						break;
					}
				}
			}
		}
	}

	public void setTargetList(List<StringNode> targetList) {
		this.targetList = targetList;
	}

	public List<StringNode> getTargetList() {
		return targetList;
	}

}
