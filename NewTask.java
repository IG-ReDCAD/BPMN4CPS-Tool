package bpmnforcpsextension;

import org.eclipse.bpmn2.modeler.core.features.CustomShapeFeatureContainer;
import org.eclipse.bpmn2.modeler.core.model.ModelDecorator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class newtask extends CustomShapeFeatureContainer{

     private final static String TYPE_VALUE = "PE";
     private final static String CUSTOM_TASK_ID = "bpmnforcpsextension.physicalentitytaskfeaturecontainer";
    public newtask ()
    {   
        super();
    }
    @Override
    public String getId(EObject object) {
                
        EStructuralFeature f = ModelDecorator.getAnyAttribute(object, "TypeDevice");
        if (f!=null) {
            Object id = object.eGet(f);
            if (TYPE_VALUE.equals(id))
                return CUSTOM_TASK_ID;
            
        }
        return null;
    }
}
