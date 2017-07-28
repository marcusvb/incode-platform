package domainapp.modules.exampledom.ext.togglz.dom.featuretoggle;

import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum TogglzDemoFeature implements org.togglz.core.Feature {

    @Label("Enable create")
    @EnabledByDefault
    create,

    @Label("Enable findByName")
    findByName,

    @Label("Enable listAll")
    @EnabledByDefault
    listAll;


    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

}