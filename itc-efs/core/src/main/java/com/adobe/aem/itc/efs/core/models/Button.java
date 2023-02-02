package com.adobe.aem.itc.efs.core.models;


import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.wcm.core.components.commons.link.Link;
import com.adobe.cq.wcm.core.components.models.Component;

/**
 * Defines the {@code Button} Sling Model used for the {@code /apps/core/wcm/components/button} component.
 *
 * @since com.adobe.cq.wcm.core.components.models 12.8.0
 */
@ConsumerType
public interface Button extends Component {

    /**
     * Returns the button text.
     *
     * @return the button text
     * @since com.adobe.cq.wcm.core.components.models 12.8.0
     */
    default String getText() {
        return null;
    }

    /**
     * Returns the button link.
     *
     * @return the button link
     * @since com.adobe.cq.wcm.core.components.models 12.21.0
     */
    default Link getButtonLink() {
        return null;
    }

    /**
     * Returns the button link.
     *
     * @return the button link
     * @since com.adobe.cq.wcm.core.components.models 12.8.0
     * @deprecated Please use {@link #getButtonLink()}
     */
    @Deprecated
    default String getLink() {
        return null;
    }

    /**
     * Returns the button icon identifier.
     *
     * @return the button icon identifier
     * @since com.adobe.cq.wcm.core.components.models 12.8.0
     */
    default String getIcon() {
        return null;
    }

    /**
     * Returns an accessibility label for the button.
     *
     * @return an accessibility label for the button
     * @since com.adobe.cq.wcm.core.components.models 12.9.0
     */
    default String getAccessibilityLabel() {
        return null;
    }

}