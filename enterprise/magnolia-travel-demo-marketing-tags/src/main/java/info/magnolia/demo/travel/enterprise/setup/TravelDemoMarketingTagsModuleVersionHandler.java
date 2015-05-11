/**
 * This file Copyright (c) 2015 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This program and the accompanying materials are made
 * available under the terms of the Magnolia Network Agreement
 * which accompanies this distribution, and is available at
 * http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package info.magnolia.demo.travel.enterprise.setup;

import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.PropertyValueDelegateTask;
import info.magnolia.module.delta.SetPropertyTask;
import info.magnolia.module.delta.Task;
import info.magnolia.repository.RepositoryConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Replace the travel demo prototype script areas templateScript & modelClass with those supporting Marketing Tags.
 */
public class TravelDemoMarketingTagsModuleVersionHandler extends DefaultModuleVersionHandler {

    protected static final String SITE_AREAS_PROTOTYPE = "/modules/site/config/site/templates/prototype/areas/headerScripts";

    @Override
    protected List<Task> getExtraInstallTasks(InstallContext installContext) {
        final List<Task> tasks = new ArrayList<Task>();

        tasks.addAll(super.getExtraInstallTasks(installContext));

        tasks.add(new PropertyValueDelegateTask("Replace Travel Demo prototype's headerScripts model with MarketingTags model.", "", RepositoryConstants.CONFIG, SITE_AREAS_PROTOTYPE, "modelClass", "info.magnolia.templating.models.areas.PlaceholderAreaModel", true,
                new SetPropertyTask(RepositoryConstants.CONFIG, SITE_AREAS_PROTOTYPE, "modelClass", "info.magnolia.marketingtags.model.ScriptsAreaModel")));

        tasks.add(new PropertyValueDelegateTask("Replace Travel Demo prototype's headerScripts script with MarketingTags script.", "", RepositoryConstants.CONFIG, SITE_AREAS_PROTOTYPE, "templateScript", "/mte/areas/placeholder.ftl", true,
                new SetPropertyTask(RepositoryConstants.CONFIG, SITE_AREAS_PROTOTYPE, "templateScript", "/templates/scriptsArea.ftl")));

        return tasks;
    }

}