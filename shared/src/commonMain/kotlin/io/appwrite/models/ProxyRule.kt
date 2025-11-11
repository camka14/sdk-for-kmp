package io.appwrite.models

import io.appwrite.enums.ProxyRuleDeploymentResourceType
import io.appwrite.enums.ProxyRuleStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Rule
 */
@Serializable
data class ProxyRule(
    /**
     * Rule ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Rule creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Rule update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Domain name.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * Action definition for the rule. Possible values are &quot;api&quot;, &quot;deployment&quot;, or &quot;redirect&quot;
     */
    @SerialName("type")
    val type: String,

    /**
     * Defines how the rule was created. Possible values are &quot;manual&quot; or &quot;deployment&quot;
     */
    @SerialName("trigger")
    val trigger: String,

    /**
     * URL to redirect to. Used if type is &quot;redirect&quot;
     */
    @SerialName("redirectUrl")
    val redirectUrl: String,

    /**
     * Status code to apply during redirect. Used if type is &quot;redirect&quot;
     */
    @SerialName("redirectStatusCode")
    val redirectStatusCode: Long,

    /**
     * ID of deployment. Used if type is &quot;deployment&quot;
     */
    @SerialName("deploymentId")
    val deploymentId: String,

    /**
     * Type of deployment. Possible values are &quot;function&quot;, &quot;site&quot;. Used if rule&#039;s type is &quot;deployment&quot;.
     */
    @SerialName("deploymentResourceType")
    val deploymentResourceType: ProxyRuleDeploymentResourceType,

    /**
     * ID deployment&#039;s resource. Used if type is &quot;deployment&quot;
     */
    @SerialName("deploymentResourceId")
    val deploymentResourceId: String,

    /**
     * Name of Git branch that updates rule. Used if type is &quot;deployment&quot;
     */
    @SerialName("deploymentVcsProviderBranch")
    val deploymentVcsProviderBranch: String,

    /**
     * Domain verification status. Possible values are &quot;created&quot;, &quot;verifying&quot;, &quot;verified&quot; and &quot;unverified&quot;
     */
    @SerialName("status")
    val status: ProxyRuleStatus,

    /**
     * Certificate generation logs. This will return an empty string if generation did not run, or succeeded.
     */
    @SerialName("logs")
    val logs: String,

    /**
     * Certificate auto-renewal date in ISO 8601 format.
     */
    @SerialName("renewAt")
    val renewAt: String,

    )

