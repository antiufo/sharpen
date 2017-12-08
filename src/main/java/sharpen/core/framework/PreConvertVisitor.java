package sharpen.core.framework;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import sharpen.core.CSharpBuilder;

import java.util.HashMap;
import java.util.Map;

public class PreConvertVisitor extends ASTVisitor {

    private final Map<String, String> renamingMap = new HashMap<>();

    @Override
    public boolean visit(TypeDeclaration node) {
        renameFieldsAmbiguousToMethods(node);
        return false;
    }

    private void renameFieldsAmbiguousToMethods(TypeDeclaration node) {
        for (FieldDeclaration field : node.getFields()) {
            for (Object item : field.fragments()) {
                VariableDeclarationFragment fragment = (VariableDeclarationFragment) item;
                String fieldName = fragment.getName().getIdentifier();
                if (ASTUtility.hasMethodWithName(node, fieldName)) {
	                renamingMap.put(CSharpBuilder.rezolveBinding(fragment.getName()).getKey(), fieldName + "__");
                }
            }
        }
    }

    public Map<String, String> getRenamingMap() {
        return renamingMap;
    }

}
