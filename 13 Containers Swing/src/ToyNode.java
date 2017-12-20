import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class ToyNode {

    Node node;

    public ToyNode(Node node) {
        this.node = node;
    }

    public List<ParamNode> getParams() {

        ArrayList<ParamNode> methods = new ArrayList<ParamNode>();

        NodeList methodNodes = node.getChildNodes();

        for (int i = 0; i < methodNodes.getLength(); i++) {
            node = methodNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                ParamNode methodNode = new ParamNode(node);
                methods.add(methodNode);
            }
        }

        return methods;
    }

    public String getName() {

        NamedNodeMap attributes = node.getAttributes();

        Node nameAttrib = attributes.getNamedItem("name");

        return nameAttrib.getNodeValue();
    }
}