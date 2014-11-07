/*
 *  Copyright 2013~2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.wicket.excel.cpt.ui;

import de.agilecoders.wicket.core.markup.html.bootstrap.common.NotificationPanel;

import java.io.File;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.model.LoadableDetachableModel;

import org.apache.isis.viewer.wicket.model.models.EntityCollectionModel;
import org.apache.isis.viewer.wicket.ui.panels.PanelAbstract;
import org.apache.isis.viewer.wicket.ui.panels.PanelUtil;

/**
 * {@link PanelAbstract Panel} that represents a {@link EntityCollectionModel
 * collection of entity}s rendered using {@link AjaxFallbackDefaultDataTable}.
 */
public class CollectionContentsAsExcel extends PanelAbstract<EntityCollectionModel> {

    private static final long serialVersionUID = 1L;

    private static final String ID_FEEDBACK = "feedback";
    private static final String ID_DOWNLOAD = "download";

    public CollectionContentsAsExcel(final String id, final EntityCollectionModel model) {
        super(id, model);

        buildGui();
    }

    private void buildGui() {

        final EntityCollectionModel model = getModel();
        
        final NotificationPanel feedback = new NotificationPanel(ID_FEEDBACK);
        feedback.setOutputMarkupId(true);
        addOrReplace(feedback);

        final LoadableDetachableModel<File> fileModel = new ExcelFileModel(model);
        final String xlsxFileName = xlsxFileNameFor(model);
        final DownloadLink link = new ExcelFileDownloadLink(ID_DOWNLOAD, fileModel, xlsxFileName);
        
        addOrReplace(link);
    }

    private static String xlsxFileNameFor(final EntityCollectionModel model) {
        return model.getName().replaceAll(" ", "") + ".xlsx";
    }

    
    @Override
    protected void onModelChanged() {
        buildGui();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        PanelUtil.renderHead(response, CollectionContentsAsExcel.class);
    }
}
