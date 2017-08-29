package com.beingmate.updateFile;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ChangeAttParser implements NodeParser<Dimen> {
	private String[] propertys = { "android:layout_width", "android:layout_height", "android:paddingTop",
			"android:layout_marginRight", "android:layout_marginBottom", "android:layout_marginLeft",
			"android:layout_marginTop", "android:paddingBottom", "android:paddingLeft", "android:paddingRight",
			"android:textSize", "android:horizontalSpacing", "android:verticalSpacing", "android:drawablePadding",
			"android:minHeight", "android:layout_margin", "android:padding", "android:padding", "android:radius" };
	private List<Dimen> targetList;

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
			resetAttributeValue((Element) node);
		}
		if (node.hasChildNodes()) {
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node n = nodeList.item(i);
				node(n);
			}
		}
	}

	private void resetAttributeValue(Element e) {
		for (String pro : propertys) {
			Attr att = e.getAttributeNode(pro);
			if (att != null) {
				System.out.println("attr:" + "name:" + att.getName() + " value:" + att.getValue());
				String val = att.getValue();
				for (Dimen dimen : targetList) {
					if (val.equals(dimen.name)) {
						System.out.println("修改成功:" + "name:" + att.getName() + " value:" + dimen.value);
						att.setValue(dimen.value);
						break;
					}
				}
			}
		}
	}

	public void setTargetList(List<Dimen> targetList) {
		this.targetList = targetList;
	}

	public List<Dimen> getTargetList() {
		return targetList;
	}

}
